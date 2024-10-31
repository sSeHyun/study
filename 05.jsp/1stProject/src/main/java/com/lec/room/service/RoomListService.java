package com.lec.room.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


import com.lec.db.JDBCUtility;
import com.lec.room.dao.RoomDAO;
import com.lec.room.vo.RoomVO;

public class RoomListService {
	private RoomListService() {}
	private static RoomListService roomListService = null;
	
	public static RoomListService getInstance() {
		if(roomListService == null) roomListService = new RoomListService();
		return roomListService;
	}
	
	public int getListCount(String f, String q) {
		
		int listCount=0;
		
		Connection conn = JDBCUtility.getConnection();
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(conn);
		
		listCount=roomDAO.selectListCount(f,q);
		
		return listCount;
	}
	public List<RoomVO> getCustomerList(int p, int l ,String f, String q){
		
		List<RoomVO> roomList = new ArrayList<RoomVO>();
		Connection conn = JDBCUtility.getConnection();
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(conn);
		roomList=roomDAO.selectRoomList(p,l,f,q);

		return roomList;
	}
	

}
