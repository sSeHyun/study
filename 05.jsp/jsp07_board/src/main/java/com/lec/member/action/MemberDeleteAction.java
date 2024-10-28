package com.lec.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.member.dao.MemberDAO;
import com.lec.member.service.MemberDeleteService;
import com.lec.member.vo.ActionForward;

public class MemberDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		
		ActionForward forward = null;
		boolean isID = false;
		boolean isDeleteSuccess = false;
		
		int p = Integer.parseInt(req.getParameter("p"));
		String id = req.getParameter("id");
		
		MemberDeleteService memberDeleteService = MemberDeleteService.getInstance();
		isID=memberDeleteService.isMemberId(id, req.getParameter("pw"));
		String msg="";
		
		if(isID) {
			isDeleteSuccess=memberDeleteService.deleteMember(id);
			
			if(isDeleteSuccess) {
				forward =new ActionForward();
				forward.setRedirect(true);
				forward.setPath(String.format("memberList.mb?p=%d", p));
			}else {
				try {
					msg="회원정보 삭제 실패!";
					res.setContentType("text/html; charset=utf-8");
					PrintWriter out = res.getWriter();
					out.println("<script>");
					out.println("  alert('" + msg + "')");
					out.println("  history.back()");
					out.println("</script>");			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else {
			try {
				msg = "회원정보를 삭제할 권한이 없습니다!!!";
				res.setContentType("text/html; charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println("<script>");
				out.println("  alert('" + msg + "')");
				out.println("  history.back()");
				out.println("</script>");					
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}
		return forward;
	}
}
