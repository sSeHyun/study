package com.lec.member.action;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lec.member.service.MemberModifyService;
import com.lec.member.vo.ActionForward;
import com.lec.member.vo.MemberVO;



public class MemberModifyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
	
		ActionForward forward = null;
		MemberVO member=null;
		
		ServletContext context = req.getServletContext();
		boolean isID = false;
		boolean isModifySuccess = false;
		
		try {

			int p = Integer.parseInt(req.getParameter("p"));
			String id = req.getParameter("id");
			String pass = req.getParameter("pass");
			
			member = new MemberVO();
			MemberModifyService memberModifyService = MemberModifyService.getInstance();
			isID = memberModifyService.isMemberId(id, pass);
			String msg = "";
		
			if(isID) {
				member.setId(id);
				member.setPw(req.getParameter("pw"));
				member.setName(req.getParameter("name"));
				member.setAge(Integer.parseInt(req.getParameter("age")));
				member.setGender(req.getParameter("gender"));
				member.setEmail(req.getParameter("email"));
				isModifySuccess = memberModifyService.modifyMember(member);
				
				if(isModifySuccess) {
					forward = new ActionForward();
					forward.setRedirect(true);
					forward.setPath(String.format("memberDetail.mb?p=%d&id=%s", p, id));					
				} else {
					msg = "회원 정보 수정 실패!!!";
					res.setContentType("text/html; charset=utf-8");
					PrintWriter out = res.getWriter();
					out.println("<script>");
					out.println("  alert('" + msg + "')");
					out.println("  history.back()");
					out.println("</script>");
					forward = new ActionForward();
					forward.setRedirect(true);
					forward.setPath("error.mb?msg=" + URLEncoder.encode(msg, "utf-8"));
				}
			} else {
				msg = "회원정보를 수정할 권한이 없습니다!\n 아이디를 확인하세요!!";
				res.setContentType("text/html; charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println("<script>");
				out.println("  alert('" + msg + "')");
				out.println("  history.back()");
				out.println("</script>");	
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("error.mb?msg=" + URLEncoder.encode(msg, "utf-8"));					
			}		
			
		} catch (Exception e) {
			System.out.println("회원정보수정실패!!!" + e.getMessage());
		} 
	
		return forward;
	}
}
