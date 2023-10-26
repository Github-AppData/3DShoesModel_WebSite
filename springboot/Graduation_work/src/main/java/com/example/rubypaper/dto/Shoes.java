package com.example.rubypaper.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Shoes {
	private String shoes_Id;
	private String shoes_name;
	private int shoes_price;
	private int sales;
	private int final_price;
	private int num_Like;
	private int is_Like;	
	private int is_delete;	
	
	@JsonCreator
    public void Shoes2(@JsonProperty("shoes_Name") String shoes_Name, @JsonProperty("shoes_Price") int shoes_Price) {
        this.shoes_name = shoes_Name;
        this.shoes_price = shoes_Price;
    }

	public String getShoes_Id() {
		return shoes_Id;
	}

	public void setShoes_Id(String shoes_Id) {
		this.shoes_Id = shoes_Id;
	}

	public String getShoes_Name() {
		return shoes_name;
	}

	public void setShoes_Name(String shoes_name) {
		this.shoes_name = shoes_name;
	}

	public int getShoes_Price() {
		return shoes_price;
	}

	public void setShoes_Price(int shoes_price) {
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

	public int getNum_Like() {
		return num_Like;
	}

	public void setNum_Like(int num_Like) {
		this.num_Like = num_Like;
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
		return "Shoes [shoes_Id=" + shoes_Id + ", shoes_Name=" + shoes_name + ", shoes_Price=" + shoes_price
				+ ", sales=" + sales + ", final_price=" + final_price + ", num_Like=" + num_Like + ", is_Like="
				+ is_Like + ", is_delete=" + is_delete + "]";
	}
	
}
