package com.example.rubypaper.dto;

public class Paging {
	private int page; // 현재 페이지 번호
	private int totalPage; // 페이지 갯수
	private int pageSize = 10; // 한 페이지에 들어가는 객체 개수
	private int totalArticle; // 전체 객체 개수
	private int startRow; // 한 페이지에 객체 시작 행
	private int endRow; // 한 페이지에 객체 끝 행
	private String searchWord;
	private String searchTag;

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public Paging() {
		super();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		//페이지 번호가 없거나 음수일 경우 1로 맞춤
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		var num = totalPage % this.pageSize;
		if(num != 0) {
			num = 1;
		}
		this.totalPage = totalPage/this.pageSize + num;
		if(this.totalPage == 0) {
			this.totalPage = 1;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalArticle() {
		return totalArticle;
	}

	public void setTotalArticle(int totalArticle) {
		this.totalArticle = totalArticle;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow() {
		this.endRow = page * pageSize;
		if(this.endRow > this.totalArticle) this.endRow = this.totalArticle;
	}

	public String getSearchTag() {
		return searchTag;
	}

	public void setSearchTag(String searchTag) {
		this.searchTag = searchTag;
	}
}
