package com.lec.member.service;

import java.sql.Connection;

import com.lec.db.JDBCUtility;
import com.lec.member.dao.MemberDAO;
import com.lec.member.vo.MemberVO;

public class MemberCreateService {

	private MemberCreateService() {}
	private static MemberCreateService memberCreateService = null;

	public static MemberCreateService getInstance() {
		if(memberCreateService == null) memberCreateService = new MemberCreateService(); 
		return memberCreateService;
	}

	public boolean registerMember(MemberVO member) {
		
		boolean isIdSuccess = false ;
		
		Connection conn = JDBCUtility.getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		int insertCount = memberDAO.insert(member);
		
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
