package com.lec.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.member.vo.ActionForward;

public class MemberDeleteFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		int p= Integer.parseInt(req.getParameter("p"));
		
		return null;
	}
}
