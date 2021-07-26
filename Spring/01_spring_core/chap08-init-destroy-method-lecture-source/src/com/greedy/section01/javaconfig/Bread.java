package com.greedy.section01.javaconfig;

public class Bread extends Product {
	
	private java.util.Date bakedDate;

	public Bread() {}

	public Bread(String name, int price, java.util.Date bakedDate) {
		super(name, price);
		this.bakedDate = bakedDate;
	}

	public java.util.Date getBakedDate() {
		return bakedDate;
	}

	public void setBakedDate(java.util.Date bakedDate) {
		this.bakedDate = bakedDate;
	}

	@Override
	public String toString() {
		return super.toString() + " " + this.bakedDate;
	}
	
}
