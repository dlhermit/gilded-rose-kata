package com.gildedrose;

import com.gildedrose.updater.*;

public class ItemQualityUpdaterFactory {
    public ItemQualityUpdater createItemQualityUpdater(Item item) {
        if (ItemNameChecker.isSulfuras(item)) {
            return new FixedItemQualityUpdater();
        } else if (ItemNameChecker.isAgedBrie(item)) {
            return new AgedBrieQualityUpdater();
        } else if (ItemNameChecker.isBackstagePass(item)) {
            return new BackstagePassesQualityUpdater();
        } else if (ItemNameChecker.isConjuredItem(item)) {
            return new ConjuredItemQualityUpdater();
        }
        return new BasicItemQualityUpdater();
    }
}
