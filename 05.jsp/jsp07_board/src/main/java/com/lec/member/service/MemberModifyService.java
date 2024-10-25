package com.lec.member.service;

import java.sql.Connection;

import com.lec.db.JDBCUtility;
import com.lec.member.dao.MemberDAO;
import com.lec.member.vo.MemberVO;

public class MemberModifyService {

	private MemberModifyService() {}
	private static MemberModifyService memberModifyService = null;

	public static MemberModifyService getInstance() {
		if(memberModifyService==null) memberModifyService=new MemberModifyService();
		return memberModifyService;
	}
	
	public boolean isMemberId(String id,String pass) {
		
		boolean isId=false;
		
		Connection conn=JDBCUtility.getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		isId=memberDAO.isMemberId(id,pass);

		return isId;
	}
	public boolean modifyMember(MemberVO member) {
		
		boolean isModifySuccess = false;
		
		Connection conn =JDBCUtility.getConnection();
		MemberDAO memberDAO=MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		
		int updateCount=memberDAO.updateMember(member);
		
		if(updateCount>0) {
			JDBCUtility.commit(conn);
			JDBCUtility.close(conn, null, null);
			isModifySuccess=true;
		}else {
			JDBCUtility.rollback(conn);
		}
			
		return isModifySuccess;
	}

}
