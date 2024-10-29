package com.lec.customer.service;

import java.sql.Connection;

import com.lec.customer.dao.CustomerDAO;
import com.lec.customer.vo.CustomerVO;
import com.lec.db.JDBCUtility;

public class CustomerCreateService {
	
	private CustomerCreateService() {}
	private static CustomerCreateService customercreateService=null;
	

	public static CustomerCreateService getInstance() {
		if(customercreateService == null) customercreateService=new CustomerCreateService();
		return customercreateService;
	}
	
	public boolean registerCustomer(CustomerVO customer) {
		
		boolean isIdSuccess = false;
		
		Connection conn = JDBCUtility.getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(conn);
		int insertCount=customerDAO.insert(customer);
		
		if(insertCount>0) {
			JDBCUtility.commit(conn);
			JDBCUtility.close(conn, null, null);
			isIdSuccess=true;
		}else {
			JDBCUtility.rollback(conn);
		}
		
		
		return isIdSuccess;
	}

}
