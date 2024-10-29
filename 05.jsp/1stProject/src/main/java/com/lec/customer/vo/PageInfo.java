package com.lec.customer.vo;

public class PageInfo {
	
	private int page;
	private int startPage;
	private int endPage;
	private int totalPage;
	private int listCount;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	@Override
	public String toString() {
		return "PageInfo [page=" + page + ", startPage=" + startPage + ", endPage=" + endPage + ", totalPage="
				+ totalPage + ", listCount=" + listCount + "]";
	}
	
	
	
}
