package com.lec.room.service;

import java.sql.Connection;

import com.lec.db.JDBCUtility;
import com.lec.room.dao.RoomDAO;
import com.lec.room.vo.RoomVO;

public class RoomDetailService {
	
	private RoomDetailService() {}
	private static RoomDetailService roomDetailService = null;

	public static RoomDetailService getInstance() {
		if(roomDetailService == null ) roomDetailService = new RoomDetailService();
		return roomDetailService;
	}

	public RoomVO getDetailServiceRoom(String room_id) {
		
		RoomVO room = null;
		
		Connection conn = JDBCUtility.getConnection();
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(conn);
		
		JDBCUtility.commit(conn);
		room = roomDAO.selectRoom(room_id);
		
		return room;
	}

}
