package com.lec.customer.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.customer.vo.ActionForward;
import com.lec.customer.vo.CustomerVO;

public class CustomerLogoutAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
	
		ActionForward forward = null;
		CustomerVO customer = null;
		ServletContext context = req.getServletContext();
		
		HttpSession session = req.getSession();
		
		
		boolean isLogin=true;
		
		if(isLogin) {
			session.removeAttribute("customer_id");
			session.removeAttribute("customer_pw");
		
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("pre_index.jsp");
		
		}
		return forward;
	}
	
		
}
	

