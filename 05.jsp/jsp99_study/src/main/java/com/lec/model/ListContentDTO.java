package com.lec.model;

import java.util.List;

public class ListContentDTO {
	
	private int contentTotalCount;
	private int currentPageNumber;
	private List<ContentDTO> listContent;
	private int pageTotalCount;
	private int contentCountPerPage;
	private int firstRow;
	private int endRow;
	
	public ListContentDTO(List<ContentDTO> listContent,
			int contentTotalCount,
			int currentPageNumber,
			int contentCountPerPage,
			int firstRow,
			int endRow ) {
		this.listContent=listContent;
		this.contentTotalCount=contentTotalCount;
		this.currentPageNumber=currentPageNumber;
		this.contentCountPerPage=contentCountPerPage;
		this.firstRow=firstRow;
		this.endRow=endRow;
		
		calculatePageTotalCount();
	}
	
	private void calculatePageTotalCount() {
		if(contentTotalCount==0) {
			pageTotalCount=0;
		}else {
			pageTotalCount=contentTotalCount/contentCountPerPage;
			if(contentTotalCount%contentCountPerPage>0) pageTotalCount++;
		}
		
	}

	public int getContentTotalCount() {
		return contentTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<ContentDTO> getListContent() {
		return listContent;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getContentCountPerPage() {
		return contentCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	
}
