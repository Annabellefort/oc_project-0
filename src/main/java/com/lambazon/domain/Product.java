package com.lambazon.domain;

public class Product {
	
	private Integer id;
	private String name, description, details;
	private int quantity;
	private double price;

	public Product(int id, int quantity, double price, String name, String description) {
		setId(id);
		setQuantity(quantity);
		setPrice(price);
		setName(name);
		setDescription(description);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set the quantity of the product
	 * the quantity can t be negative, otherwise it will be set to 0
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		if (quantity < 0) {
			this.quantity = 0;
		}
		else {
			this.quantity = quantity;
		}
	}

	public double getPrice() {
		return price;
	}

	/**
	 * Set the price of the product
	 * the price can t be negative, otherwise it will be set to 0
	 * the price can t be more than 1000, otherwise it will be set to 1000
	 * @param price of product
	 */
	public void setPrice(double price) {
		// Price should not be negative
		if (price < 0) {
			this.price = 0;
		}
		// Price should not be more than 1000
		else if (price > 1000) {
			this.price = 1000;
		}
		else {
			this.price = price;
		}
	}

	/**
	 * Return the total amount of the product
	 * @return total amount of the product
	 */
	public double getInventoryPrice() {
		return quantity*price;
	}
}
