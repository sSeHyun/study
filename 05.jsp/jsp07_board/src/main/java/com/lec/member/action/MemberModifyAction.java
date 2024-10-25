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
		
		boolean isID = false;
		boolean isModifySuccess = false;
		
		try {
			
			int p = Integer.parseInt(req.getParameter("p"));
			String id = req.getParameter("id");

			
			member = new MemberVO();
			MemberModifyService memberModifyService = MemberModifyService.getInstance();
			isID = memberModifyService.isMemberId(id);
			String msg = "";
		
			if(isID) {
				member.setId(bno);
				board.setSubject(req.getParameter("subject"));
				board.setContent(req.getParameter("content"));
			
				isModifySuccess = boardModifyService.modifyBoard(board);
				
				if(isModifySuccess) {
					forward = new ActionForward();
					forward.setRedirect(true);
					forward.setPath(String.format("boardDetail.do?p=%d&bno=%d", p, bno));					
				} else {
					msg = "게시글 수정 실패!!!";
					res.setContentType("text/html; charset=utf-8");
					PrintWriter out = res.getWriter();
					out.println("<script>");
					out.println("  alert('" + msg + "')");
					out.println("  history.back()");
					out.println("</script>");
					forward = new ActionForward();
					forward.setRedirect(true);
					forward.setPath("error.do?msg=" + URLEncoder.encode(msg, "utf-8"));
				}
			} else {
				msg = "게시글을 수정할 권한이 없습니다!\n비밀번호를 확인하세요!!";
				res.setContentType("text/html; charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println("<script>");
				out.println("  alert('" + msg + "')");
				out.println("  history.back()");
				out.println("</script>");	
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("error.do?msg=" + URLEncoder.encode(msg, "utf-8"));					
			}		
			
		} catch (Exception e) {
			System.out.println("게시글수정실패!!!" + e.getMessage());
		} 
	
		return forward;
		
		
	}
}
