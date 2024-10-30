package com.lec.customer.service;

import java.sql.Connection;

import com.lec.customer.dao.CustomerDAO;
import com.lec.db.JDBCUtility;

public class CustomerLoginService {
	
	private CustomerLoginService() {}
	private static CustomerLoginService customerLoginService = null;
	
	public static CustomerLoginService getInstance() {
		if(customerLoginService == null) customerLoginService=new CustomerLoginService();
		return customerLoginService;
	}

	public boolean isCustomer(String customer_id, String customer_pw) {
		
		boolean isCustomer = false;
		
		Connection conn = JDBCUtility.getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(conn);
		isCustomer = customerDAO.isRightCustomer(customer_id, customer_pw);
		
		
		System.out.println("isCustomer_"+customer_id);
		System.out.println("isCustomer_"+customer_pw);
		
		return isCustomer;
	}

}
