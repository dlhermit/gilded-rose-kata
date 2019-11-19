package com.gildedrose.updater;

import com.gildedrose.Item;

public abstract class AbstractItemQualityUpdater implements ItemQualityUpdater {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    @Override
    public final void updateQualityForUpdatedSellIn(Item item) {
        item.quality = qualityDropsToZero(item)
                ? 0
                : limit(item.quality + getBasicFactor(item) * getFactorForNegativeSellIn(item));
    }

    public abstract int getBasicFactor(Item item);

    public abstract boolean qualityDropsToZeroWhenSellInNegative();

    private int limit(int quality) {
        return Math.max(MIN_QUALITY, Math.min(quality, MAX_QUALITY));
    }

    private boolean sellInPositiveOrZero(Item item) {
        return item.sellIn >= 0;
    }

    private boolean qualityDropsToZero(Item item) {
        return qualityDropsToZeroWhenSellInNegative() && !sellInPositiveOrZero(item);
    }

    private int getFactorForNegativeSellIn(Item item) {
        return sellInPositiveOrZero(item) ? 1 : 2;
    }
}
