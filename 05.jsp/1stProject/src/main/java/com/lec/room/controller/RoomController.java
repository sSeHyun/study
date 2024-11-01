package com.lec.room.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lec.customer.action.Action;
import com.lec.customer.vo.ActionForward;
import com.lec.room.action.RoomListAction;
import com.lec.room.action.RoomPickDateAction;
import com.lec.room.action.RoomReservationAction;
import com.lec.room.action.RoomDetailAction;

@WebServlet("*.ht")
public class RoomController extends HttpServlet {
	
	Action action = null;
	ActionForward forward = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, res);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath(); 
		String command = requestURI.substring(contextPath.length()+1, requestURI.length()-3); // *.do
		
		RequestDispatcher dispatcher = null;
		
		if(command.equalsIgnoreCase("roomCreateForm")) {
			forward = new ActionForward();
			forward.setPath("/room/room_create.jsp");
		} else if(command.equalsIgnoreCase("roomList")) {
			action = new RoomListAction();
			forward = action.execute(req, res);
		} else if(command.equalsIgnoreCase("roomDetail")) {
			action = new RoomDetailAction();
			forward = action.execute(req, res);
		}else if(command.equalsIgnoreCase("roomReservation")) {
			action = new RoomReservationAction();
			forward = action.execute(req, res);
		}else if(command.equalsIgnoreCase("roomPickDate")) {
			action = new RoomPickDateAction();
			forward = action.execute(req, res);
	}
	

		
		
		

		if(forward != null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getPath());
			} else {
				dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, res);
			}
		}
	}

}
