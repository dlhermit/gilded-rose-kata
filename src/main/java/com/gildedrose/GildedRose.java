package com.gildedrose;

import com.gildedrose.updater.ItemUpdater;

import java.util.Arrays;

class GildedRose {
    private final ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQualityAndSellIn() {
        Arrays.asList(items)
                .forEach(this::updateQualityAndSellIn);
    }

    private void updateQualityAndSellIn(Item item) {
        ItemUpdater itemUpdater = itemUpdaterFactory.createItemUpdater(item);
        itemUpdater.updateSellIn(item);
        itemUpdater.updateQualityForUpdatedSellIn(item);
    }

}