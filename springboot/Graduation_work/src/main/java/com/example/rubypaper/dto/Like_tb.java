package com.example.rubypaper.dto;

public class Like_tb {
	
	private int like_id;
	private int link_id;
	private String shoes_id;
	private String shoes_name;
	private String user_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getShoes_name() {
		return shoes_name;
	}
	public void setShoes_name(String shoes_name) {
		this.shoes_name = shoes_name;
	}
	public int getLike_id() {
		return like_id;
	}
	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}
	public int getLink_id() {
		return link_id;
	}
	public void setLink_id(int link_id) {
		this.link_id = link_id;
	}
	public String getShoes_id() {
		return shoes_id;
	}
	public void setShoes_id(String shoes_id) {
		this.shoes_id = shoes_id;
	}
	@Override
	public String toString() {
		return "Like_tb [like_id=" + like_id + ", link_id=" + link_id + ", shoes_id=" + shoes_id + ", shoes_name="
				+ shoes_name + ", user_id=" + user_id + "]";
	}
	
	

}
