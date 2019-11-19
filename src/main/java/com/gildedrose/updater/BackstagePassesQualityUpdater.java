package com.gildedrose.updater;

import com.gildedrose.Item;

public class BackstagePassesQualityUpdater extends AbstractItemQualityUpdater {
    @Override
    public int getBasicQualityUpdateFactor(Item item) {
        if (item.sellIn < 5) {
            return 3;
        } else if (item.sellIn < 10) {
            return 2;
        }
        return 1;
    }

    @Override
    public boolean qualityDropsToZeroWhenSellInNegative() {
        return true;
    }
}
