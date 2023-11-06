package com.example.rubypaper.dto;

public class Cart {

	private int cart_id;
	private String user_id;
	private String shoes_id;
	private String shoes_name;
	private int shoes_price;
	private int quantity;
	private int size;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getShoes_id() {
		return shoes_id;
	}
	public void setShoes_id(String shoes_id) {
		this.shoes_id = shoes_id;
	}
	public String getShoes_name() {
		return shoes_name;
	}
	public void setShoes_name(String shoes_name) {
		this.shoes_name = shoes_name;
	}
	public int getShoes_price() {
		return shoes_price;
	}
	public void setShoes_price(int shoes_price) {
		this.shoes_price = shoes_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", user_id=" + user_id + ", shoes_id=" + shoes_id + ", shoes_name="
				+ shoes_name + ", shoes_price=" + shoes_price + ", quantity=" + quantity + ", size=" + size + "]";
	}
	
	
}
