package com.gildedrose;

import java.util.Objects;

public class ItemNameChecker {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public static boolean isSulfuras(Item item) {
        return Objects.equals(item.name, SULFURAS);
    }

    public static boolean isAgedBrie(Item item) {
        return Objects.equals(item.name, AGED_BRIE);
    }

    public static boolean isBackstagePass(Item item) {
        return Objects.equals(item.name, BACKSTAGE_PASSES);
    }
}
