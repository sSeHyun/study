package com.lec.service;

import java.sql.Connection;
import java.util.List;


import com.lec.dao.MessageDAO;
import com.lec.jdbc.ConnectionProvider;
import com.lec.jdbc.JDBCUtility;
import com.lec.model.MessageDTO;

public class GetMessageListService {

	private static GetMessageListService instance = new GetMessageListService();
	private GetMessageListService() {}
	public static GetMessageListService getIntance() {
		return instance;
	}
	
	public List<MessageDTO> getMessageList() {
		
		Connection conn = null;
		List<MessageDTO> listMessage = null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDAO messageDAO = MessageDAO.getInstance();
			listMessage = messageDAO.selectList(conn, 0, 3);
		} catch (Exception e) {
			throw new RuntimeException("방명록 목록 조회 실패!!! " + e.getMessage());
		} finally {
			JDBCUtility.close(conn, null, null);
		}
		return listMessage;
	}
}
