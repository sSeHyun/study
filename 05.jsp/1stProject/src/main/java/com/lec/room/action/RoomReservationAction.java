package com.lec.room.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.customer.action.Action;
import com.lec.customer.vo.ActionForward;
import com.lec.room.service.RoomReservationService;
import com.lec.room.vo.RoomVO;

public class RoomReservationAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		
		int p = Integer.parseInt(req.getParameter("p"));
		String room_id = req.getParameter("room_id");
		
		RoomReservationService roomReservationService = RoomReservationService.getInstance();
		RoomVO room = roomReservationService.getRoom(room_id);
		
		ActionForward forward = null;
		req.setAttribute("room", room);

		forward.setPath(String.format("/room/room_reservation.jsp?p=%d&room_id=%s",p,room_id));
		
		return forward;
	}
}
