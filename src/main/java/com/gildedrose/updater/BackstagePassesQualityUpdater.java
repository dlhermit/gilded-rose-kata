package com.gildedrose.updater;

import com.gildedrose.Item;

public class BackstagePassesQualityUpdater extends BasicItemQualityUpdater {
    @Override
    public void updateQualityForUpdatedSellIn(Item item) {
        if (sellInPositiveOrZero(item)) {
            super.updateQualityForUpdatedSellIn(item);
        } else {
            item.quality = 0;
        }
    }

    @Override
    protected int getDecrement(Item item) {
        if (item.sellIn < 5) {
            return -3;
        } else if (item.sellIn < 10) {
            return -2;
        }
        return -1;
    }
}
