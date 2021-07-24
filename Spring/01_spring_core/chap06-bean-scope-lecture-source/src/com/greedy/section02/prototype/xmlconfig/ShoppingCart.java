package com.greedy.section02.prototype.xmlconfig;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private final List<Product> items;
	
	public ShoppingCart() {
		items = new ArrayList<>();
	}
	
	public void addItem(Product item) {
		items.add(item);
	}
	
	public List<Product> getItem() {
		return items;
	}
}
