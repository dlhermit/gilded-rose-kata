package com.gildedrose.updater;

import com.gildedrose.Item;

public abstract class AbstractItemUpdater implements ItemUpdater {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    @Override
    public final void updateQualityForUpdatedSellIn(Item item) {
        item.quality = qualityDropsToZeroWhenSellNegative(item)
                ? 0
                : limit(item.quality + getBasicQualityUpdateFactor(item) * oneOrTwoIfSellInNegative(item));
    }

    @Override
    public final void updateSellIn(Item item) {
        decreaseSellIn(item);
    }

    public abstract int getBasicQualityUpdateFactor(Item item);

    public abstract boolean qualityDropsToZeroWhenSellInNegative();

    private int limit(int quality) {
        return Math.max(MIN_QUALITY, Math.min(quality, MAX_QUALITY));
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean sellInPositiveOrZero(Item item) {
        return item.sellIn >= 0;
    }

    private boolean qualityDropsToZeroWhenSellNegative(Item item) {
        return qualityDropsToZeroWhenSellInNegative() && !sellInPositiveOrZero(item);
    }

    private int oneOrTwoIfSellInNegative(Item item) {
        return sellInPositiveOrZero(item) ? 1 : 2;
    }
}
