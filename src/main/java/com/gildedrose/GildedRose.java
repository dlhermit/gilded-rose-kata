package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            // if item is not "Aged Brie" or "Backstage passes to a TAFKAL80ETC concert"
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                // quality >= 0
                if (items[i].quality > 0) {

                    // quality decreases by 1, except when name is "Sulfuras, Hand of Ragnaros"
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }

            // else if quality < 50 (and "Aged Brie" or "Backstage passes to a TAFKAL80ETC concert")
            else {
                if (items[i].quality < 50) {

                    // quality increase by 1
                    items[i].quality = items[i].quality + 1;

                    // if backstage pass
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // extra increase if sellIn <= 10
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        // extra increase if sellIn <= 5
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            // sell decreases, except "Sulfuras, Hand of Ragnaros"
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            // if negative sell in
            if (items[i].sellIn < 0) {

                // if item is not aged brie, backstage pass of sulfura
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                // quality decreases extra point
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        // quality becomes 0 for backstage pass
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    // if quality < 50
                    if (items[i].quality < 50) {
                        // quality increases by 1
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}