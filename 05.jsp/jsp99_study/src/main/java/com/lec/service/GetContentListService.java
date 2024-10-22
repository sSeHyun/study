package com.lec.service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import com.lec.dao.ContentDAO;
import com.lec.jdbc.ConnectionProvider;
import com.lec.jdbc.JDBCUtility;
import com.lec.model.ContentDTO;
import com.lec.model.ListContentDTO;

public class GetContentListService {
	
	private static GetContentListService instance =new GetContentListService();
	private GetContentListService() {}
	public static GetContentListService getInstance() {
		return instance;
	}
	
	private static final int CONTENT_COUNT_PER_PAGE=5;
	
	public ListContentDTO getContentList(int pageNumber) {
		
		Connection conn=null;
		int currentPage=pageNumber;
		
		try {
			conn=ConnectionProvider.getConnection();
			ContentDAO contentDAO = ContentDAO.getInstance();
			
			int contentTotalCount=contentDAO.selectCount(conn);
			
			List<ContentDTO> listContent=null;
			int firstRow=0;
			int  endRow=0;
			
			if(contentTotalCount>0) {
				firstRow=(pageNumber-1)*CONTENT_COUNT_PER_PAGE;
				endRow=firstRow+CONTENT_COUNT_PER_PAGE;
				listContent=contentDAO.selectList(conn, firstRow, endRow);
			}else {
				currentPage=0;
				listContent=Collections.emptyList();
			}
			return new ListContentDTO(listContent, contentTotalCount, currentPage
					, CONTENT_COUNT_PER_PAGE, firstRow, endRow);
		}catch(Exception e) {
			throw new ServiceException("게시글 목록 조회 실패!"+e.getMessage(),e);
			
		}finally {
			JDBCUtility.close(conn, null, null);
		}
		
	}
	

}
