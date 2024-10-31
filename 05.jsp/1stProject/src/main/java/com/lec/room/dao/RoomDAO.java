package com.lec.room.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.lec.db.JDBCUtility;
import com.lec.room.vo.RoomVO;

public class RoomDAO {
	
	private static RoomDAO roomDAO;
	private RoomDAO() {}
	
	public static RoomDAO getInstance() {
		if(roomDAO==null) roomDAO = new RoomDAO();
		return roomDAO;
	}
	
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	//객실 목록 조회하기
	public List<RoomVO> selectRoomList(int p, int l, String f, String q){
		
		RoomVO room = null;
		List<RoomVO> roomList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from roominfo1 "
				   + " where " + f + " like ?"
				   + " limit ?, " + l;
		

		int startRow = (p-1) * l ;
		
		try {	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + q + "%");
			pstmt.setInt(2, startRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				room = new RoomVO();
				room.setRoom_id(rs.getString("room_id"));
				room.setRoom_peopleCnt(rs.getInt("room_peopleCnt"));
				room.setRoom_type(rs.getString("room_type"));
				room.setRoom_price(rs.getString("room_price"));
				
				roomList.add(room);
			}
				
		}catch (Exception e) {
			System.out.println("객실 목록 조회 실패!"+e.getMessage());
		}finally {
			JDBCUtility.close(null,pstmt,rs);
		}
		
		return roomList;
	}

	//객실 수 구하기
	public int selectListCount(String f, String q) {
		
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select count(*) from roominfo1 "
				   + " where " + f + " like ? ";	
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + q + "%");
			rs = pstmt.executeQuery();
			
			if(rs.next()) listCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("객실 수 조회실패!!! " + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return listCount;
	}

	//객실 선택 
	public RoomVO selectRoom(String room_id) {
		
		RoomVO room = new RoomVO();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from roominfo1 where room_id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, room_id);
			rs=pstmt.executeQuery();

			if(rs.next()) {
				room.setRoom_id(room_id);
				room.setRoom_peopleCnt(rs.getInt("room_peopleCnt"));
				room.setRoom_type(rs.getString("room_type"));
				room.setRoom_price(rs.getString("room_price"));		
			}
			
		}catch (Exception e) {
			System.out.println("객실 예약 실패!" + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return room;
	}

}
















