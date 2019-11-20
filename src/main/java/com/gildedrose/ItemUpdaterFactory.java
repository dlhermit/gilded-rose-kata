package com.gildedrose;

import com.gildedrose.updater.*;

public class ItemUpdaterFactory {
    public ItemUpdater createItemUpdater(Item item) {
        if (ItemNameChecker.isSulfuras(item)) {
            return new SulfurasUpdater();
        } else if (ItemNameChecker.isAgedBrie(item)) {
            return new AgedBrieUpdater();
        } else if (ItemNameChecker.isBackstagePass(item)) {
            return new BackstagePassesUpdater();
        } else if (ItemNameChecker.isConjuredItem(item)) {
            return new ConjuredItemUpdater();
        }
        return new BasicItemUpdater();
    }
}
