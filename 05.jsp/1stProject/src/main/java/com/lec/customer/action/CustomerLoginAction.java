package com.lec.customer.action;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.customer.service.CustomerCreateService;
import com.lec.customer.service.CustomerLoginService;
import com.lec.customer.vo.ActionForward;
import com.lec.customer.vo.CustomerVO;

public class CustomerLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		
		ActionForward forward = null;
		CustomerVO customer = null;
		ServletContext context = req.getServletContext();
		
		boolean isCustomer=false;
		
		
		try {
			
			String customer_id = req.getParameter("customer_id");
			String customer_pw = req.getParameter("customer_pw");
			
			customer = new CustomerVO();
			CustomerLoginService customerLoginService = CustomerLoginService.getInstance();
			isCustomer = customerLoginService.isCustomer(customer_id,customer_pw);
			
			String msg="";
					
			
			if(isCustomer) {
				customer.setId(customer_id);
				customer.setPw(customer_pw);
				
				forward =new ActionForward();
				forward.setRedirect(true);
				forward.setPath("customerList.cs");	//이후 main.cs로 수정해야함.
				
			}else {
				msg = "아이디 / 비밀번호를 확인하세요!!";
				res.setContentType("text/html; charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println("<script>");
				out.println("  alert('" + msg + "')");
				out.println("  history.back()");
				out.println("</script>");	
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("error.cs?msg=" + URLEncoder.encode(msg, "utf-8"));					
			}		
		
		}catch (Exception e) {
			System.out.println("CustomerLoginAction_로그인_실패!!!" + e.getMessage());
		}
		
		return forward;
	}

}
