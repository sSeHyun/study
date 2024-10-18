package com.lec.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lec.dao.MessageDAO;
import com.lec.jdbc.ConnectionProvider;
import com.lec.jdbc.JDBCUtility;

public class DeleteMessageService {
	private static DeleteMessageService instance = new DeleteMessageService(); 
	private DeleteMessageService() {}
	public static DeleteMessageService getInstance() {
		return instance;
	}
	
	public void deleteMessage(int id, String password) throws Exception {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDAO messageDAO = MessageDAO.getInstance();
			int row = messageDAO.delete(conn, id);
		} catch (SQLException e) {
			throw new RuntimeException("방명록 삭제 실패!!! " + e.getMessage());
		} finally {
			JDBCUtility.close(conn, null, null);
		}
		
	}
}
