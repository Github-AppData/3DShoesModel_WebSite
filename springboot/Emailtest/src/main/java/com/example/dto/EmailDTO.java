package com.example.dto;


public class EmailDTO {

	private String address;
	private String title;
	private String message;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "EmailDTO [address=" + address + ", title=" + title + ", message=" + message + "]";
	}
	
}
