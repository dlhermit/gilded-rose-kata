package com.gildedrose.updater;

import com.gildedrose.Item;

public class BasicItemQualityUpdater implements ItemQualityUpdater {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    @Override
    public void updateQualityForUpdatedSellIn(Item item) {
        decreaseQuality(item);
    }

    protected int getBasicDecrement() {
        return 1;
    }

    protected int getDecrement(Item item) {
        return (sellInPositiveOrZero(item) ? 1 : 2) * getBasicDecrement();
    }

    private void decreaseQuality(Item item) {
        item.quality = limit(item.quality - getDecrement(item));
    }

    private int limit(int quality) {
        return Math.max(MIN_QUALITY, Math.min(quality, MAX_QUALITY));
    }

    protected final boolean sellInPositiveOrZero(Item item) {
        return item.sellIn >= 0;
    }
}
