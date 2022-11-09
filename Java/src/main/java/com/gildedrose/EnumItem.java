package com.gildedrose;

import java.util.*;

public enum EnumItem {
	
	AGED_BRIE("Aged Brie",0,50,1,false),
	BACKSTAGE("Backstage passes to a TAFKAL80ETC concert",0,50,1,false),
	SULFURAS("Sulfuras, Hand of Ragnaros",80,80,0,true),
	AUTRE(null,0,50,-1,false);
	
	
	private String  name ;
	private int minQuality ; 
	private int maxQuality ; 
	private int value;
	private boolean isLegendary;
	
	private EnumItem(String name, int minQuality, int maxQuality, int value, boolean isLegendary) {
		this.name = name;
		this.minQuality = minQuality;
		this.maxQuality = maxQuality ;
		this.value = value ; 
		this.isLegendary = isLegendary;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * return EnumItem from name else null 
	 * @param name 
	 * @return EnumItem
	 */
	public static EnumItem fromString(String name) {

		return name != null ? Arrays.asList(values()).stream().filter(element -> 
								name.equalsIgnoreCase(element.getName()))
									.findFirst()
									.orElse(AUTRE)
							: AUTRE;

	}
	
	
	public int getMinQuality() {
		return minQuality;
	}

	public int getMaxQuality() {
		return maxQuality;
	}

	public int getValue() {
		return value;
	}
	
	public boolean isLegendary() {
		return isLegendary;
	}

	
	

}
