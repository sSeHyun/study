package com.lec.customer.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.customer.service.CustomerCreateService;
import com.lec.customer.vo.ActionForward;
import com.lec.customer.vo.CustomerVO;

public class CustomerCreateAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		
		ActionForward forward = null;
		CustomerVO customer = null;
		ServletContext context = req.getServletContext();
		
		try {
			customer=new CustomerVO();
			
			customer.setId(req.getParameter("customer_id"));
			customer.setPw(req.getParameter("customer_pw"));
			customer.setName(req.getParameter("customer_name"));
			customer.setJumin(req.getParameter("customer_jumin"));
			customer.setPhone(req.getParameter("customer_phone"));
			customer.setAddr(req.getParameter("customer_addr"));
			customer.setEmail(req.getParameter("customer_email"));	
	
			CustomerCreateService customercreateService = CustomerCreateService.getInstance();
			boolean isIdSuccess = customercreateService.registerCustomer(customer);
			
			if(isIdSuccess) {
				
				System.out.println("id parameter: " + req.getParameter("customer_id"));
				System.out.println("pw parameter: " + req.getParameter("customer_pw"));
				System.out.println("name parameter: " + req.getParameter("customer_name"));
				System.out.println("jumin parameter: " + req.getParameter("customer_jumin"));
				System.out.println("phone parameter: " + req.getParameter("customer_phone"));
				System.out.println("addr parameter: " + req.getParameter("customer_addr"));
				System.out.println("email parameter: " + req.getParameter("customer_email"));
				
				forward =new ActionForward();
				forward.setRedirect(true);
				forward.setPath("customerList.cs");
				
				
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
		}
		return forward;
	}

}
