package com.lec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.lec.customer.vo.CustomerVO;
import com.lec.db.JDBCUtility;

public class CustomerDAO {
	
	private static CustomerDAO customerDAO;
	private  CustomerDAO() {}
	
	public static CustomerDAO getInstance() {
		if(customerDAO==null) customerDAO = new CustomerDAO();
		return customerDAO;
	}
	
	Connection conn = null;
	DataSource ds =null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	//회원 추가 생성
	public int insert(CustomerVO customer) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into customer(customer_id, customer_pw, customer_name, customer_jumin, customer_phone, customer_addr,customer_email)"+
					" values(?,?,?,?,?,?,?)";
		
		int insertCount = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,customer.getId());
			pstmt.setString(2, customer.getPw());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getJumin());
			pstmt.setString(5, customer.getPhone());
			pstmt.setString(6, customer.getAddr());
			pstmt.setString(7, customer.getEmail());
			
			insertCount = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("회원 등록실패!! !" + e.getMessage());
		}finally {
			JDBCUtility.close(null, pstmt, rs);
		}
		return insertCount;
	}

}
