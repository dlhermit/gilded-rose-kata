package com.gildedrose.updater;

import com.gildedrose.Item;

public class DecreasingItemSellInUpdater implements ItemSellInUpdater {
    @Override
    public void updateSellIn(Item item) {
        decreaseSellIn(item);
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}