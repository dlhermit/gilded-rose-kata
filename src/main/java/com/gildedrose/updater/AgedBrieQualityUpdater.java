package com.gildedrose.updater;

import com.gildedrose.Item;

public class AgedBrieQualityUpdater extends AbstractItemQualityUpdater {
    @Override
    public int getBasicFactor(Item item) {
        return 1;
    }

    @Override
    public boolean qualityDropsToZeroWhenSellInNegative() {
        return false;
    }
}
