package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
	
	
	public static final String AGED_BRIE = "Aged Brie";
	public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String FOO = "foo";

	// test name
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.getItems()[0].name);
    }
    
    
    //test Quality of products
  	@Test
  	void normalProductQualityTest() {
  		Item[] items = new Item[] { new Item(FOO, 2, 10) };
  		GildedRose app = new GildedRose(items);
  		app.updateQuality();
  		assertEquals(9, app.getItems()[0].quality);    
  	}
 

  //test Quality Once the sell by date has passed, Quality degrades twice as fast
  	@Test
  	void normalProductQualitySellInPassedTest() {
  		Item[] items = new Item[] { new Item(FOO, 0, 10) };
  		GildedRose app = new GildedRose(items);
  		app.updateQuality();
  		assertEquals(8, app.getItems()[0].quality);    
  	}
    
    
  //tester Quality never less 0 if normal case 
  	@Test
  	void normalProductQualityMinTest() {
  		Item[] items = new Item[] { new Item(FOO, 0, 0) };
  		GildedRose app = new GildedRose(items);
  		app.updateQuality();
  		assertEquals(0, app.getItems()[0].quality);    
  	}
    
  	
  //tester SellIn 
  	@Test
  	void normalProductSellInTest() {
  		Item[] items = new Item[] { new Item(FOO, 0, 0) };
  		GildedRose app = new GildedRose(items);
  		app.updateQuality();
  		assertEquals(-1, app.getItems()[0].sellIn);   
  	}
  	
  //"Aged Brie" actually increases in Quality the older it gets
  	@Test
  	void agedBrieIncreaseQualityWhenUpdate() {
  		Item[] items = new Item[] { new Item(AGED_BRIE, 5, 10) };
  		GildedRose app = new GildedRose(items);
  		app.updateQuality();
  		assertEquals(4, app.getItems()[0].sellIn);  
  		assertEquals(11, app.getItems()[0].quality); 
  	}
    
  //The Quality of an item is never more than 50
  	@Test
  	void qualityNeverMoreFifty() {
  		Item[] items = new Item[] { new Item(AGED_BRIE, 5, 50) };
  		GildedRose app = new GildedRose(items);
  		app.updateQuality();
  		assertEquals(4, app.getItems()[0].sellIn);  
  		assertEquals(50, app.getItems()[0].quality); 
  	}
  	
  	
 // "Sulfuras", being a legendary item, never has to be sold 
 	@Test
 	void sulfurasNeverHasSold() {
 		Item[] items = new Item[] { new Item(SULFURAS, 5, 80) };
 		GildedRose app = new GildedRose(items);
 		app.updateQuality();
 		assertEquals(5, app.getItems()[0].sellIn);   
 	}
    
    
 // "Sulfuras", being a legendary item, never decreases in Quality
 	@Test
 	void SulfurasqualityNeverMoreFifty() {
 		Item[] items = new Item[] { new Item(SULFURAS, 5, 80) };
 		GildedRose app = new GildedRose(items);
 		app.updateQuality(); 
 		assertEquals(80, app.getItems()[0].quality); 
 	}

 	
 // "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches
 	@Test
 	void backstagePassesIncreaseQualityWhenUpdate() {
 		Item[] items = new Item[] { new Item(BACKSTAGE, 15, 10) };
 		GildedRose app = new GildedRose(items);
 		app.updateQuality();
 		assertEquals(14, app.getItems()[0].sellIn);  
 		assertEquals(11, app.getItems()[0].quality); 
 	}
 	
 	
 // "Backstage passes" Quality increases by 2 when there are 10 days or less
 	@Test
 	void backstagePassesIncreaseQualityWhenUpdateLessThan() {
 		Item[] items = new Item[] { new Item(BACKSTAGE, 10, 15) };
 		GildedRose app = new GildedRose(items);
 		app.updateQuality();
 		assertEquals(9, app.getItems()[0].sellIn);  
 		assertEquals(17, app.getItems()[0].quality); 
 	}
    
 	
 // "Backstage passes" Quality increases  by 3 when there are 5 days or less 
 	@Test
 	void backstagePassesIncreaseQualityWhenUpdateLessFive() {
 		Item[] items = new Item[] { new Item(BACKSTAGE, 5, 10) };
 		GildedRose app = new GildedRose(items);
 		app.updateQuality();
 		assertEquals(4, app.getItems()[0].sellIn);  
 		assertEquals(13, app.getItems()[0].quality); 
 	}
    
 	
 // "Backstage passes" Quality drops to 0 after the concert
 	@Test
 	void backstagePassesIncreaseQualityWhenUpdateDropToZero() {
 		Item[] items = new Item[] { new Item(BACKSTAGE, 0, 10) };
 		GildedRose app = new GildedRose(items);
 		app.updateQuality();
 		assertEquals(-1, app.getItems()[0].sellIn);  
 		assertEquals(0, app.getItems()[0].quality); 
 	}
    
    

}
