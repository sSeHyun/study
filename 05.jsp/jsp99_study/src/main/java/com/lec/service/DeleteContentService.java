package com.lec.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lec.dao.ContentDAO;
import com.lec.jdbc.ConnectionProvider;
import com.lec.jdbc.JDBCUtility;
import com.lec.model.ContentDTO;

public class DeleteContentService {
	private static DeleteContentService instance=new DeleteContentService();
	private DeleteContentService() {}
	public static DeleteContentService getInstance() {
		return instance;
	}
	
	public void deleteContent(String writer){
		Connection conn=null;
		
		try {
			conn=ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			ContentDAO contentDAO=ContentDAO.getInstance();
			ContentDTO content=contentDAO.select(conn,writer);
			
			if(content==null) {
				throw new ContentNotFoundException("게시글이 없습니다.");
			}
			if(!content.matchWriter(writer)) {
				throw new InvalidWriterException("작성자명이 틀립니다. 다시입력하세요!");
			}
			
			int row=ContentDAO.delete(conn,writer);
			conn.commit();
			
		}catch(SQLException e) {
			JDBCUtility.rollback(conn);
			throw new ServiceException("게시글 삭제 실패"+e.getMessage(),e);
		}catch(ContentNotFoundException | InvalidWriterException e) {
			JDBCUtility.rollback(conn);
			throw e;
		}finally {
			JDBCUtility.close(conn, null, null);
		}
	}

}
