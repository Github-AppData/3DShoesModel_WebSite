package com.example.rubypaper.dto;

import java.util.Date;

public class NoticeBoard {

	private int idx;
	private String title;
	private String writer;
	private String content;
	private String write_date;
	private String user_id;
	private int is_delete;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}
	@Override
	public String toString() {
		return "NoticeBoard [idx=" + idx + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", write_date=" + write_date + ", user_id=" + user_id + ", is_delete=" + is_delete + "]";
	}
	
	
}
