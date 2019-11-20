package com.gildedrose.updater;

import com.gildedrose.Item;

public class AgedBrieUpdater extends AbstractItemUpdater {
    @Override
    public int getBasicQualityUpdateFactor(Item item) {
        return 1;
    }

    @Override
    public boolean qualityDropsToZeroWhenSellInNegative() {
        return false;
    }
}
