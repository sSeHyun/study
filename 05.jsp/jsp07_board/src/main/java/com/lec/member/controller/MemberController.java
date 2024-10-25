package com.lec.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lec.member.action.Action;
import com.lec.member.action.MemberCreateAction;
import com.lec.member.action.MemberDeleteAction;
import com.lec.member.action.MemberDeleteFormAction;
import com.lec.member.action.MemberDetailAction;
import com.lec.member.action.MemberListAction;
import com.lec.member.action.MemberModifyAction;
import com.lec.member.action.MemberModifyFormAction;
import com.lec.member.vo.ActionForward;

@WebServlet("*.mb")
public class MemberController extends HttpServlet {
	
	// 회원관리
	Action action = null;
	ActionForward forward = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		process(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		process(req, res);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath(); 
		String command = requestURI.substring(contextPath.length()+1, requestURI.length()-3); // *.do
		
		RequestDispatcher dispatcher = null;
		
		if(command.equalsIgnoreCase("memberCreateForm")) {
			forward = new ActionForward();
			forward.setPath("/member/member_create.jsp");
		} else if(command.equalsIgnoreCase("memberCreate")) {
			action = new MemberCreateAction();
			forward = action.execute(req, res);
		} else if(command.equalsIgnoreCase("memberList")) {
			action = new MemberListAction();
			forward = action.execute(req, res);
		} else if(command.equalsIgnoreCase("memberDetail")) {
			action = new MemberDetailAction();
			forward = action.execute(req, res);
		} else if(command.equalsIgnoreCase("memberModifyForm")) {
			action = new MemberModifyFormAction();
			forward = action.execute(req, res);
		} else if(command.equalsIgnoreCase("memberModify")) {
			action = new MemberModifyAction();
			forward = action.execute(req, res);
		} else if(command.equalsIgnoreCase("memberDeleteForm")) {
			action = new MemberDeleteFormAction();
			forward = action.execute(req, res);
		} else if(command.equalsIgnoreCase("memberDelete")) {
			action = new MemberDeleteAction();
			forward = action.execute(req, res);
		} else if(command.equalsIgnoreCase("error")) {
				forward = new ActionForward();
				forward.setPath("/member/error.jsp");
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
	


