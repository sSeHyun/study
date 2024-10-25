package com.lec.member.service;

import java.sql.Connection;

import com.lec.db.JDBCUtility;
import com.lec.member.dao.MemberDAO;
import com.lec.member.vo.MemberVO;

public class MemberDetailService {
	
	private MemberDetailService() {}
	private static MemberDetailService memberDetailService = null;
	
	public static MemberDetailService getInstance() {
		if(memberDetailService==null) memberDetailService=new MemberDetailService();
		return memberDetailService;
	}

	public MemberVO getMember(String id) {
		
		MemberVO member =null;
		
		Connection conn = JDBCUtility.getConnection();
		MemberDAO memberDAO =MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		

		//member = MemberDAO.selectMember(id);
		return member;
	}

}
