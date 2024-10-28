package com.lec.member.service;

import java.sql.Connection;

import com.lec.db.JDBCUtility;
import com.lec.member.dao.MemberDAO;

public class MemberDeleteService {

	private MemberDeleteService() {}
	private static MemberDeleteService memberDeleteService = null;
	public static MemberDeleteService getInstance() {
		if(memberDeleteService == null) memberDeleteService = new MemberDeleteService();
		return memberDeleteService;
	}
	public boolean isMemberId(String id, String pw) {
		boolean isId=false;
		
		Connection conn = JDBCUtility.getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		isId = memberDAO.isMemberId(id, pw);
		
		return isId;
	}
	public boolean deleteMember(String id) {
		
		boolean isDeleteSuccess = false;
		
		Connection conn = JDBCUtility.getConnection();
		MemberDAO memberDAO=MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		
		int deleteCount=memberDAO.deleteMember(id);
		
		if(deleteCount>0) {
			JDBCUtility.commit(conn);
			JDBCUtility.close(conn, null, null);
			isDeleteSuccess=true;
		}else {
			JDBCUtility.rollback(conn);
		}
		return isDeleteSuccess;
	}

}
