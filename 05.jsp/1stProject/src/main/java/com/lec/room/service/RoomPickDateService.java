package com.lec.room.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;

import javax.swing.JFrame;

import com.lec.db.JDBCUtility;
import com.lec.room.dao.RoomDAO;
import com.lec.room.vo.RoomVO;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class RoomPickDateService  {
	
	private RoomPickDateService() {}
	private static RoomPickDateService roomPickDateService = null;
	
	public static RoomPickDateService getInstance() {
		if(roomPickDateService == null) roomPickDateService = new RoomPickDateService();
		return roomPickDateService;
	}
	public RoomVO getPickDateRoom(String room_id) {
		
		RoomVO room = null;
		
		Connection conn = JDBCUtility.getConnection();
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(conn);
		
		JDBCUtility.commit(conn);
		room = roomDAO.selectRoom(room_id);
		
		return room;
	}
		
}
