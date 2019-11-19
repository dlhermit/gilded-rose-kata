package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private final ItemSellInUpdaterFactory itemSellInUpdaterFactory = new ItemSellInUpdaterFactory();
    private final ItemQualityUpdaterFactory itemQualityUpdaterFactory = new ItemQualityUpdaterFactory();

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQualityAndSellIn() {
        Arrays.asList(items)
                .forEach(this::updateQualityAndSellIn);
    }

    private void updateQualityAndSellIn(Item item) {
        itemSellInUpdaterFactory.createSellInUpdater(item).updateSellIn(item);
        itemQualityUpdaterFactory.createItemQualityUpdater(item).updateQualityForUpdatedSellIn(item);
    }

}