package com.lec.customer.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.customer.service.CustomerListService;
import com.lec.customer.vo.ActionForward;
import com.lec.customer.vo.CustomerVO;
import com.lec.customer.vo.PageInfo;

public class CustomerListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		
		int page=1;
		int limit=10;
		
		int p=1;
		String f="";
		String q="";
		
		if(req.getParameter("p") != null) p = Integer.parseInt(req.getParameter("p"));
		if(req.getParameter("f") != null) f = req.getParameter("f"); else f = "customer_id";
		if(req.getParameter("q") != null) q = req.getParameter("q");
		
		List<CustomerVO> customerList = new ArrayList<>();
		PageInfo pageInfo = new PageInfo();
		
		CustomerListService customerListService = CustomerListService.getInstance();
		req.setAttribute("customerList", customerList);
		
		ActionForward forward = new ActionForward();
		forward.setPath(String.format("/customer/customer_list.jsp?p=%s&f=%s&q=%s", p, f, q));
		return forward;
	}
}
