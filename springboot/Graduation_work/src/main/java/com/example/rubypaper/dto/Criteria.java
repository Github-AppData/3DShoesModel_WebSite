package com.example.rubypaper.dto;

public class Criteria {
	//현재 페이지 번호
	private int page;
	//한 페이지당 보여줄 게시글의 갯수
	private int perPageNum;
	
	public int getPageStart() {
		//현재 페이지의 게시글 시작 번호 = (현재 페이지 번호 - 1) * 페이지당 보여줄 게시글 갯수
		return (this.page-1)*perPageNum;
	}
	
	public Criteria() {
		//초기값
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		//음수가 되지않게 막아줌
		if(page <= 0) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int pageCount) {
		int cnt = this.perPageNum;
		if(pageCount != cnt) {
			this.perPageNum = cnt;
		} else {
			this.perPageNum = pageCount;
		}
	}
	
}
