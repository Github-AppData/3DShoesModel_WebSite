package com.example.rubypaper.dto;



import java.util.Date;

import org.springframework.stereotype.Component;


public class User {

	private int idx;
	private String user_id;
	private String pw;
	private String email;
	private Date birthday;
	private String adress;
	private String detail_adress;
	private String phone;
	private String salt;
	private String name;
	private boolean loggedIn;
	
	// 로그인 O -> 1 / 로그인 X -> 0  
	private Integer is_Status;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDetail_adress() {
		return detail_adress;
	}

	public void setDetail_adress(String detail_adress) {
		this.detail_adress = detail_adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getIs_Status() {
		return is_Status;
	}

	public void setIs_Status(Integer is_Status) {
		this.is_Status = is_Status;
	}

	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String togetSalt() {
		return salt;
	}
	
	public String togetPw() {
		return pw;
	}

	@Override
	public String toString() {
		return "User [idx=" + idx + ", user_id=" + user_id + ", pw=" + pw + ", email=" + email + ", birthday="
				+ birthday + ", adress=" + adress + ", detail_adress=" + detail_adress + ", phone=" + phone + ", salt="
				+ salt + ", name=" + name + ", loggedIn=" + loggedIn + ", is_Status=" + is_Status + "]";
	}

	
	
	
}
