package com.lec.room.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.customer.action.Action;
import com.lec.customer.vo.ActionForward;
import com.lec.room.service.RoomReservationService;
import com.lec.room.vo.RoomVO;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class RoomReservationAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		
		String room_id = req.getParameter("room_id");
			
		RoomReservationService roomReservationService = RoomReservationService.getInstance();
		RoomVO room = roomReservationService.getReservationRoom(room_id);
		
		ActionForward forward = new ActionForward();
		req.setAttribute("room", room);

		forward.setPath(String.format("/room/room_reservation.jsp?room_id=%s",room_id));		
		return forward;
	}
}
