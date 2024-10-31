package com.lec.room.service;

import java.sql.Connection;

import com.lec.db.JDBCUtility;
import com.lec.room.dao.RoomDAO;
import com.lec.room.vo.RoomVO;

public class RoomReservationService {
	
	private RoomReservationService () {} 
	private static RoomReservationService roomReservationService = null;
	
	public static RoomReservationService getInstance() {
		if(roomReservationService == null) roomReservationService = new RoomReservationService();
		return roomReservationService;
	}


	public RoomVO getRoom(String room_id) {
		
		RoomVO room = null;
		
		Connection conn = JDBCUtility.getConnection();
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(conn);
		
		JDBCUtility.commit(conn);
		room = roomDAO.selectRoom(room_id);
		
		return room;
	}

}
