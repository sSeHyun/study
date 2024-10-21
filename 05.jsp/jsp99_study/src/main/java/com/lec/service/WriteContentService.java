package com.lec.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lec.dao.ContentDAO;
import com.lec.jdbc.ConnectionProvider;
import com.lec.jdbc.JDBCUtility;
import com.lec.model.ContentDTO;

public class WriteContentService {
	private static WriteContentService instance=new WriteContentService();
	private WriteContentService() {}
	public static WriteContentService getInstance() {
		return instance;
	}
	public void write(ContentDTO content) {
		Connection conn=null;
		try {
			conn=ConnectionProvider.getConnection();
			ContentDAO contentDAO=ContentDAO.getInstance();
			contentDAO.insert(conn, content);
			
		}catch(SQLException e){
			throw new RuntimeException("콘텐츠 등록 실패!"+e.getMessage());
		}finally {
			JDBCUtility.close(conn,null,null);
		}
	}

}
