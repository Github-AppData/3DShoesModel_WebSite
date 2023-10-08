package com.example.rubypaper.dto;

import java.util.Date;

public class Shoes {
	private String shoes_Id;
	private String shoes_Name;
	private Long shoes_Price;
	private Long num_Like;
	private String cate_Name;
	private Date revise_Date;
	private Long is_Like;
	private String brand_Name;
	private String color_Code;
	
	@Override
	public String toString() {
		return "Shoes [shoes_Id=" + shoes_Id + ", shoes_Name=" + shoes_Name + ", shoes_Price=" + shoes_Price
				+ ", num_Like=" + num_Like + ", cate_Name=" + cate_Name + ", revise_Date=" + revise_Date + ", is_Like="
				+ is_Like + ", brand_Name=" + brand_Name + ", color_Code=" + color_Code + "]";
	}
	public String getShoes_Id() {
		return shoes_Id;
	}
	public void setShoes_Id(String shoes_Id) {
		this.shoes_Id = shoes_Id;
	}
	public String getShoes_Name() {
		return shoes_Name;
	}
	public void setShoes_Name(String shoes_Name) {
		this.shoes_Name = shoes_Name;
	}
	public Long getShoes_Price() {
		return shoes_Price;
	}
	public void setShoes_Price(Long shoes_Price) {
		this.shoes_Price = shoes_Price;
	}
	public Long getNum_Like() {
		return num_Like;
	}
	public void setNum_Like(Long num_Like) {
		this.num_Like = num_Like;
	}
	public String getCate_Name() {
		return cate_Name;
	}
	public void setCate_Name(String cate_Name) {
		this.cate_Name = cate_Name;
	}
	public Date getRevise_Date() {
		return revise_Date;
	}
	public void setRevise_Date(Date revise_Date) {
		this.revise_Date = revise_Date;
	}
	public Long getIs_Like() {
		return is_Like;
	}
	public void setIs_Like(Long is_Like) {
		this.is_Like = is_Like;
	}
	public String getBrand_Name() {
		return brand_Name;
	}
	public void setBrand_Name(String brnad_Name) {
		this.brand_Name = brnad_Name;
	}
	public String getColor_Code() {
		return color_Code;
	}
	public void setColor_Code(String color_Code) {
		this.color_Code = color_Code;
	}
}
