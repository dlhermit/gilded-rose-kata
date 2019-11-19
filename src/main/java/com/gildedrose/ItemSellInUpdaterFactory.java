package com.gildedrose;

import com.gildedrose.updater.DecreasingItemSellInUpdater;
import com.gildedrose.updater.FixedItemSellInUpdater;
import com.gildedrose.updater.ItemSellInUpdater;

public class ItemSellInUpdaterFactory {
    public ItemSellInUpdater createSellInUpdater(Item item) {
        return ItemNameChecker.isSulfuras(item)
                ? new FixedItemSellInUpdater()
                : new DecreasingItemSellInUpdater();
    }
}
