package com.lec.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.member.service.MemberDetailService;
import com.lec.member.vo.ActionForward;
import com.lec.member.vo.MemberVO;

public class MemberModifyFormAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		
		int p = Integer.parseInt(req.getParameter("p"));
		String id=req.getParameter("id");
		
		MemberDetailService memberDetailService=MemberDetailService.getInstance();
		MemberVO member=memberDetailService.getMember(id);
		
		ActionForward forward=new ActionForward();
		req.setAttribute("member", member);
		forward.setPath(String.format("/member/member_modify.jsp?p=%d&id=%s", p,id));
		return forward;
	}
}
