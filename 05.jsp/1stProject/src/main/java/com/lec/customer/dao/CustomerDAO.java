package com.lec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	//2. 회원 수 구하기 
	public int selectListCount(String f, String q) {
		
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select count(*) from customer "
				   + " where " + f + " like ? ";	
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + q + "%");
			rs = pstmt.executeQuery();
			
			if(rs.next()) listCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("가입 회원 수 조회실패!!! " + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return listCount;
	}
	
	//3. 회원 목록 조회하기

	public List<CustomerVO> selectCustomerList(int p, int l, String f, String q) {
		
		CustomerVO customer = null;
		List<CustomerVO> customerList = new ArrayList<>();
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select * from customer "
				   + " where " + f + " like ?"
				   + " limit ?, " + l;
		
		int startRow = (p-1) * l;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + q + "%");
			pstmt.setInt(2, startRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				customer = new CustomerVO();
				customer.setId(rs.getString("customer_id"));
				customer.setPw(rs.getString("customer_pw"));
				customer.setName(rs.getString("customer_name"));
				customer.setJumin(rs.getString("customer_jumin"));
				customer.setPhone(rs.getString("customer_phone"));
				customer.setAddr(rs.getString("customer_addr"));
				customer.setEmail(rs.getString("customer_email"));	
				
				customerList.add(customer);
			}
		} catch (Exception e) {
			System.out.println("회원목록조회실패!!! " + e.getMessage());
		} finally {
			JDBCUtility.close(null, pstmt, rs);
		}
		return customerList;	
		
		
	
	}
	
	//회원 확인(아이디, 비밀번호) 
	public boolean isRightCustomer(String customer_id,String customer_pw) {
		
		boolean isCustomer = false;
		
		CustomerVO customer = new CustomerVO();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from customer where customer_id = ? and customer_pw = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_id);
			pstmt.setString(2, customer_pw);
			rs = pstmt.executeQuery();
			rs.next();
			if(customer_id.equals(rs.getString("customer_id")) &&
			   customer_pw.equals(rs.getString("customer_pw"))) isCustomer=true;
			
		}catch (Exception e) {
			System.out.println("CustomerDAO_로그인 실패!"+ e.getMessage());
		}finally {
			JDBCUtility.close(null, pstmt, rs);
		}
		
		return isCustomer;
	}
	

}
