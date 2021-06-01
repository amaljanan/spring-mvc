package com.pits.trainingmvc.model;

public class Product {

	String productName;
	String price;
	String department;
	int stocksAvailable;

	public int getStocksAvailable() {
		return stocksAvailable;
	}

	public void setStocksAvailable(int stocksAvailable) {
		this.stocksAvailable = stocksAvailable;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProduct_name() {
		return productName;
	}

	public void setProduct_name(String product_name) {
		this.productName = product_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
