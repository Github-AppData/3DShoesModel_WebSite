package com.example.rubypaper.dto;

import java.util.Date;

public class Order_List {
	
	private int oreder_id;
	private int size;
	private String shoes_name;
	private int quantity;
	private int price;
	private String user_id;
	private String order_date;
	private String way;
	
	public int getOreder_id() {
		return oreder_id;
	}
	public void setOreder_id(int oreder_id) {
		this.oreder_id = oreder_id;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getShoes_name() {
		return shoes_name;
	}
	public void setShoes_name(String shoes_name) {
		this.shoes_name = shoes_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	@Override
	public String toString() {
		return "Order_List [oreder_id=" + oreder_id + ", size=" + size + ", shoes_name=" + shoes_name + ", quantity="
				+ quantity + ", price=" + price + ", user_id=" + user_id + ", order_date=" + order_date + ", way=" + way
				+ "]";
	}
	
	
	

}
