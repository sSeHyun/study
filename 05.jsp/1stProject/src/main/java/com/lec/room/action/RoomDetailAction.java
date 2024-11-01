package com.lec.room.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.customer.action.Action;
import com.lec.customer.vo.ActionForward;
import com.lec.room.service.RoomDetailService;
import com.lec.room.vo.RoomVO;

public class RoomDetailAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		
		int p = Integer.parseInt(req.getParameter("p"));
		String room_id = req.getParameter("room_id");
		
		HttpSession session = req.getSession();
		session.setAttribute("room_id", req.getParameter("room_id"));
		
		RoomDetailService roomReservationService = RoomDetailService.getInstance();
		RoomVO room = roomReservationService.getDetailServiceRoom(room_id);
		
		ActionForward forward = new ActionForward();
		req.setAttribute("room", room);
		
		forward.setPath(String.format("/room/room_detail.jsp?p=%d&room_id=%s",p,room_id));
		
		return forward;
	}

}
