package com.example.rubypaper.dto;

public class Paging {
	private int page; // 현재 페이지 번호
	private int totalPage; // 페이지 갯수
	private int pageSize = 10; // 한 페이지에 들어가는 객체 개수
	private int totalArticle; // 전체 객체 개수
	private int startRow; // 한 페이지에 객체 시작 행
	private int endRow; // 한 페이지에 객체 끝 행

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
		this.totalPage = this.totalArticle/this.pageSize + (this.totalArticle%this.pageSize==0?0:1);
		
		if(this.page <=0 || this.page > totalPage)
		{
			this.page = 1;
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

	public void setEndRow(int endRow) {
		this.endRow = page * pageSize;
		if(endRow > this.totalArticle) endRow = this.totalArticle;
	}
}
