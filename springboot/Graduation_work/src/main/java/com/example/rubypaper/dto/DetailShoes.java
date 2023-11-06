package com.example.rubypaper.dto;

public class DetailShoes {

	private String uid;
	private String iframeId;
	private String shoes_name;
    private int final_price;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getIframeId() {
		return iframeId;
	}
	public void setIframeId(String iframeId) {
		this.iframeId = iframeId;
	}
	public String getShoes_name() {
		return shoes_name;
	}
	public void setShoes_name(String shoes_name) {
		this.shoes_name = shoes_name;
	}
	public int getFinal_price() {
		return final_price;
	}
	public void setFinal_price(int final_price) {
		this.final_price = final_price;
	}
	@Override
	public String toString() {
		return "DetailShoes [uid=" + uid + ", iframeId=" + iframeId + ", shoes_name=" + shoes_name + ", final_price="
				+ final_price + "]";
	}
	
	
    
}
