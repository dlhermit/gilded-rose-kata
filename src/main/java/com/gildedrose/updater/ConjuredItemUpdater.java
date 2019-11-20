package com.gildedrose.updater;

import com.gildedrose.Item;

public class ConjuredItemUpdater extends AbstractItemUpdater {

    @Override
    public int getBasicQualityUpdateFactor(Item item) {
        return -2;
    }

    @Override
    public boolean qualityDropsToZeroWhenSellInNegative() {
        return false;
    }
}
