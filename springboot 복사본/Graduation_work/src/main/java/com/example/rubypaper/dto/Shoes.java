package com.example.rubypaper.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Shoes {
	private String shoes_id;
	private String shoes_name;
	private int shoes_price;
	private int sales;
	private int final_price;
	private int review_stars;
	private int is_Like;	
	private int is_delete;	
	

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

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getFinal_price() {
		return final_price;
	}

	public void setFinal_price(int final_price) {
		this.final_price = final_price;
	}

	

	public int getReview_stars() {
		return review_stars;
	}

	public void setReview_stars(int review_stars) {
		this.review_stars = review_stars;
	}

	public int getIs_Like() {
		return is_Like;
	}

	public void setIs_Like(int is_Like) {
		this.is_Like = is_Like;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	@Override
	public String toString() {
		return "Shoes [shoes_id=" + shoes_id + ", shoes_name=" + shoes_name + ", shoes_price=" + shoes_price
				+ ", sales=" + sales + ", final_price=" + final_price + ", review_stars=" + review_stars + ", is_Like="
				+ is_Like + ", is_delete=" + is_delete + "]";
	}


	
	
}
