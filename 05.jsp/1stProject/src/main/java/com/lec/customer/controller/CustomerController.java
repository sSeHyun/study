package com.lec.customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.customer.action.Action;
import com.lec.customer.action.CustomerCreateAction;
import com.lec.customer.action.CustomerListAction;
import com.lec.customer.action.CustomerLoginAction;
import com.lec.customer.vo.ActionForward;


@WebServlet("*.cs")
public class CustomerController extends HttpServlet {
	
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
	
	private void process(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String requestURI=req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length()+1,requestURI.length()-3);
		
	
		RequestDispatcher dispatcher = null;
		

		if(command.equalsIgnoreCase("customerCreateForm")) {
			forward = new ActionForward();
			forward.setPath("/customer/customer_create.jsp");
		} else if(command.equalsIgnoreCase("customerCreate")) {
			action = new CustomerCreateAction();
			forward = action.execute(req, res);
		} else if(command.equalsIgnoreCase("customerLoginForm")) {
			forward = new ActionForward();
			forward.setPath("/customer/customer_login.jsp");
		} else if(command.equalsIgnoreCase("customerLogin")) {
			action = new CustomerLoginAction();
			forward = action.execute(req, res);
		} else if(command.equalsIgnoreCase("customerList")) {
			action = new CustomerListAction();
			forward = action.execute(req, res);
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
