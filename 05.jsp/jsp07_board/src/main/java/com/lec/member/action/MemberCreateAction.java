package com.lec.member.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.member.service.MemberCreateService;
import com.lec.member.vo.ActionForward;
import com.lec.member.vo.MemberVO;


public class MemberCreateAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)  {
		
		ActionForward forward = null;
		MemberVO member=null;
		ServletContext context = req.getServletContext();
		
		try {
			
			member=new MemberVO();
			
			member.setId(req.getParameter("id"));
			member.setPw(req.getParameter("pw"));
			member.setName(req.getParameter("name"));
			member.setAge(Integer.parseInt(req.getParameter("age")));
			member.setEmail(req.getParameter("email"));
			
			MemberCreateService memberCreateService = MemberCreateService.getInstance(); 
			boolean isIdSuccess = memberCreateService.registerMember(member);
			
			if(isIdSuccess) {
				forward =new ActionForward();
				forward.setRedirect(true);
				forward.setPath("memberList.mb");				
			}else {
				res.setContentType("text/html ; charset=utf-8");
				PrintWriter out =res.getWriter();
				out.println("<script>");
				out.println("  alert('회원등록을 실패 했습니다!!')");
				out.println("  history.back()");
				out.println("</script>");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("id parameter: " + req.getParameter("id"));
			System.out.println("pw parameter: " + req.getParameter("pw"));
			System.out.println("name parameter: " + req.getParameter("name"));
			System.out.println("Age parameter: " + req.getParameter("age"));
			System.out.println("email parameter: " + req.getParameter("email"));
		}
		
		return forward;
	}
}
