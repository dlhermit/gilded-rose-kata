package com.gildedrose;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    private static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String ELIXIR = "Elixir of the Mongoose";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    @Test
    public void updateQuality_NameDoesNotChange() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void updateQuality_QualityDecreasesOneByDefault() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(DEXTERITY_VEST, 10, 20));

        assertThat(app.items[0].quality).isEqualTo(19);
    }

    @Test
    public void updateQuality_SellInDecreasesOneByDefault() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(DEXTERITY_VEST, 10, 20));

        assertThat(app.items[0].sellIn).isEqualTo(9);
    }

    @Test
    public void updateQuality_QualityDecreasesTwiceAsFastWhenSellInPassed() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(DEXTERITY_VEST, 0, 20));

        assertThat(app.items[0].quality).isEqualTo(18);
    }

    @Test
    public void updateQuality_QualityNeverDecreasesUnderZero() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(DEXTERITY_VEST, 10, 0));

        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    public void updateQuality_QualityIncreasesForBrie() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(AGED_BRIE, 10, 20));

        assertThat(app.items[0].quality).isEqualTo(21);
    }

    @Test
    public void updateQuality_QualityNeverIncreasesAboveFifty() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(AGED_BRIE, 10, 50));

        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    public void updateQuality_QualityDoesNotChangeForSulfuras() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(SULFURAS, 10, 80));

        assertThat(app.items[0].quality).isEqualTo(80);
    }

    @Test
    public void updateQuality_SellInDoesNotChangeForSulfuras() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(SULFURAS, 10, 80));

        assertThat(app.items[0].sellIn).isEqualTo(10);
    }

    @Test
    public void updateQuality_QualityIncreasesForBackstagePasses_SellInAboveTen() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(BACKSTAGE_PASSES, 11, 20));

        assertThat(app.items[0].quality).isEqualTo(21);
    }

    @Test
    public void updateQuality_QualityIncreasesForBackstagePasses_SellInBetweenSixAndTen() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(BACKSTAGE_PASSES, 7, 20));

        assertThat(app.items[0].quality).isEqualTo(22);
    }

    @Test
    public void updateQuality_QualityIncreasesForBackstagePasses_SellInUnderFive() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(BACKSTAGE_PASSES, 4, 20));

        assertThat(app.items[0].quality).isEqualTo(23);
    }

    @Test
    public void updateQuality_QualityIncreasesForBackstagePasses_QualityDropsToZeroAfterSellInPassed() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(BACKSTAGE_PASSES, 0, 20));

        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    // TODO: implement this
    public void updateQuality_QualityDegradesAsFastForConjuredItems() {
        GildedRose app = buildAppAndUpdateQualityFor(new Item(CONJURED_MANA_CAKE, 14, 20));

        assertThat(app.items[0].quality).isEqualTo(18);
    }

    @Test
    public void updateQuality_QualityUpdatesCorrectly() {
        assertItemsQualityUpdatesCorrectly(
                buildTestSet(),
                buildExpectedUpdatedTestSet());
    }

    @Test
    public void updateQuality_SellInUpdatesCorrectly() {
        assertItemsSellInUpdatesCorrectly(
                buildTestSet(),
                buildExpectedUpdatedTestSet());
    }

    @Test
    public void updateQualityNameDoesNotUpdate() {
        assertItemsNameDoesNotUpdate(
                buildTestSet(),
                buildExpectedUpdatedTestSet());
    }

    private GildedRose buildAppAndUpdateQualityFor(Item item) {
        return buildAppAndUpdateQualityFor(new Item[] {item});
    }

    private GildedRose buildAppAndUpdateQualityFor(Item[] items) {
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        return app;
    }

    private void assertItemsQualityUpdatesCorrectly(Item[] items, Item[] updatedItems) {
        GildedRose app = buildAppAndUpdateQualityFor(items);

        IntStream
                .range(0, items.length)
                .forEach(index -> assertThat(app.items[index].quality).isEqualTo(updatedItems[index].quality));
    }

    private void assertItemsSellInUpdatesCorrectly(Item[] items, Item[] updatedItems) {
        GildedRose app = buildAppAndUpdateQualityFor(items);

        IntStream
                .range(0, items.length)
                .forEach(index -> assertThat(app.items[index].sellIn).isEqualTo(updatedItems[index].sellIn));
    }

    private void assertItemsNameDoesNotUpdate(Item[] items, Item[] updatedItems) {
        GildedRose app = buildAppAndUpdateQualityFor(items);

        IntStream
                .range(0, items.length)
                .forEach(index -> assertThat(app.items[index].name).isEqualTo(updatedItems[index].name));
    }

    // TODO move to respective classes
    private Item[] buildTestSet() {
        return new Item[] {
                new Item(DEXTERITY_VEST, 10, 20), //
                new Item(DEXTERITY_VEST, 1, 20), //
                new Item(DEXTERITY_VEST, 0, 20), //
                new Item(DEXTERITY_VEST, 15, 0), //
                new Item(DEXTERITY_VEST, 5, 50), //

                new Item(ELIXIR, 10, 20), //
                new Item(ELIXIR, 1, 20), //
                new Item(ELIXIR, 0, 20), //
                new Item(ELIXIR, 15, 0), //
                new Item(ELIXIR, 5, 50), //

                new Item(SULFURAS, 10, 80), //
                new Item(SULFURAS, 0, 80), //

                new Item(AGED_BRIE, 10, 20), //
                new Item(AGED_BRIE, 1, 20), //
                new Item(AGED_BRIE, 0, 20), //
                new Item(AGED_BRIE, 15, 0), //
                new Item(AGED_BRIE, 5, 50), //

                new Item(BACKSTAGE_PASSES, 15, 20), //
                new Item(BACKSTAGE_PASSES, 15, 50), //
                new Item(BACKSTAGE_PASSES, 10, 20), //
                new Item(BACKSTAGE_PASSES, 10, 50), //
                new Item(BACKSTAGE_PASSES, 6, 20), //
                new Item(BACKSTAGE_PASSES, 5, 20), //
                new Item(BACKSTAGE_PASSES, 5, 50), //
                new Item(BACKSTAGE_PASSES, 1, 20), //
                new Item(BACKSTAGE_PASSES, 0, 20), //
                new Item(BACKSTAGE_PASSES, 0, 50), //

                new Item(SULFURAS, 0, 80), //
                new Item(SULFURAS, -1, 80),
                new Item(SULFURAS, 50, 80),

                // this conjured item does not work properly yet
//                new Item(CONJURED_MANA_CAKE, 3, 6)
        };
    }

    private Item[] buildExpectedUpdatedTestSet() {
        return new Item[] {
                new Item(DEXTERITY_VEST, 9, 19), //
                new Item(DEXTERITY_VEST, 0, 19), //
                new Item(DEXTERITY_VEST, -1, 18), //
                new Item(DEXTERITY_VEST, 14, 0), //
                new Item(DEXTERITY_VEST, 4, 49), //

                new Item(ELIXIR, 9, 19), //
                new Item(ELIXIR, 0, 19), //
                new Item(ELIXIR, -1, 18), //
                new Item(ELIXIR, 14, 0), //
                new Item(ELIXIR, 4, 49), //

                new Item(SULFURAS, 10, 80), //
                new Item(SULFURAS, 0, 80), //

                new Item(AGED_BRIE, 9, 21), //
                new Item(AGED_BRIE, 0, 21), //
                new Item(AGED_BRIE, -1, 22), //
                new Item(AGED_BRIE, 14, 1), //
                new Item(AGED_BRIE, 4, 50), //

                new Item(BACKSTAGE_PASSES, 14, 21), //
                new Item(BACKSTAGE_PASSES, 14, 50), //
                new Item(BACKSTAGE_PASSES, 9, 22), //
                new Item(BACKSTAGE_PASSES, 9, 50), //
                new Item(BACKSTAGE_PASSES, 5, 22), //
                new Item(BACKSTAGE_PASSES, 4, 23), //
                new Item(BACKSTAGE_PASSES, 4, 50), //
                new Item(BACKSTAGE_PASSES, 0, 23), //
                new Item(BACKSTAGE_PASSES, -1, 0), //
                new Item(BACKSTAGE_PASSES, -1, 0), //

                new Item(SULFURAS, 0, 80), //
                new Item(SULFURAS, -1, 80),
                new Item(SULFURAS, 50, 80),

                // this conjured item does not work properly yet
//                new Item(CONJURED_MANA_CAKE, 3, 6)
        };
    }

}
