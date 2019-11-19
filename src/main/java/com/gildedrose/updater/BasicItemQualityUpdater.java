package com.gildedrose.updater;

import com.gildedrose.Item;

public class BasicItemQualityUpdater extends AbstractItemQualityUpdater {
    @Override
    public int getBasicQualityUpdateFactor(Item item) {
        return -1;
    }

    @Override
    public boolean qualityDropsToZeroWhenSellInNegative() {
        return false;
    }
}
