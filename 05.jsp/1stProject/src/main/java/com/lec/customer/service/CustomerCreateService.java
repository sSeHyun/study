package com.lec.customer.service;

import java.sql.Connection;

import com.lec.customer.dao.CustomerDAO;
import com.lec.customer.vo.CustomerVO;
import com.lec.db.JDBCUtility;

public class CustomerCreateService{
	
	private CustomerCreateService() {}
	private static CustomerCreateService customerCreateService = null;
	
	public static CustomerCreateService getInstance() {
		if(customerCreateService == null) customerCreateService = new CustomerCreateService();
		return customerCreateService;
	}

	public boolean registerCustomer(CustomerVO customer) {
		
		boolean isIdSuccess = false;
		
		Connection conn = JDBCUtility.getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(conn);
		int insertCount = customerDAO.insert(customer);
		
		if(insertCount > 0) {
			JDBCUtility.commit(conn);
			JDBCUtility.close(conn, null, null);
			isIdSuccess = true;
		} else {
			JDBCUtility.rollback(conn);
		}
		return isIdSuccess;
	}
}
