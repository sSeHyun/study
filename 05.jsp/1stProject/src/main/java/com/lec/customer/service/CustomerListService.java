package com.lec.customer.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.lec.customer.dao.CustomerDAO;
import com.lec.customer.vo.CustomerVO;
import com.lec.db.JDBCUtility;

public class CustomerListService {
	private CustomerListService() {}
	private static CustomerListService customerListService =null;
	
	public static CustomerListService getInstance() {
		if(customerListService == null) customerListService = new CustomerListService();
		return customerListService;
	}
	
	public int getListCount(String f, String q) {
		
		// 회원전체갯수 : select count(*) from customer where subject like '%%';		
		int listCount=0;
		
		Connection conn = JDBCUtility.getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(conn);
		
		listCount=customerDAO.selectListCount(f,q);
		
		
		return listCount;
	}
	public List<CustomerVO> getCustomerList(int p, int l ,String f, String q){
		
		List<CustomerVO> customerList = new ArrayList<CustomerVO>();
		Connection conn = JDBCUtility.getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(conn);
		customerList=customerDAO.selectCustomerList(p,l,f,q);

		return customerList;
	}
	

}
