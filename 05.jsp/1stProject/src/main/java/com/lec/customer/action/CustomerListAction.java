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
		int listCount=customerListService.getListCount(f, q);
		customerList = customerListService.getCustomerList(p, limit, f, q);
		
		//페이징 처리
		//1. 총 페이지수 = (총레코드수 / limit ) + 1 
		int totalPage = (int)((double)listCount/limit + 0.95);
		
		//2. 현재페이지 ( 1~10 , 11~20 , 21~30....)
		int startPage = (p-1) / 10 * 10 +1;
		
		//3. 마지막페이지 
		int endPage = startPage + 9;
		endPage= endPage > totalPage ? (totalPage > 0 ? totalPage : 1) : endPage;
		
		pageInfo.setListCount(listCount);
		pageInfo.setPage(p);
		pageInfo.setTotalPage(totalPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		
		req.setAttribute("customerList", customerList);
		req.setAttribute("pageInfo", pageInfo);
		
		ActionForward forward = new ActionForward();
		forward.setPath(String.format("/customer/customer_list.jsp?p=%s&f=%s&q=%s", p, f, q));
		return forward;
	}
}
