package com.gildedrose;

import java.util.Objects;

public class ItemNameChecker {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    public static boolean isSulfuras(Item item) {
        return isItem(item, SULFURAS);
    }

    public static boolean isAgedBrie(Item item) {
        return isItem(item, AGED_BRIE);
    }

    public static boolean isBackstagePass(Item item) {
        return isItem(item, BACKSTAGE_PASSES);
    }

    public static boolean isConjuredItem(Item item) {
        return isItem(item, CONJURED_MANA_CAKE);
    }

    private static boolean isItem(Item item, String name) {
        return Objects.equals(item.name, name);
    }
}
