package com.lec.member.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtility;
import com.lec.member.dao.MemberDAO;
import com.lec.member.vo.MemberVO;

public class MemberListService {
	
	private MemberListService() {}
	private static MemberListService memberListService=null;
	public static MemberListService getInstance() {
		if(memberListService==null) memberListService =new MemberListService();
		return memberListService;
	}
	
	public int getListCount(String f, String q) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<MemberVO> getMemberList(int p, int l, String f, String q) {
		List<MemberVO> memberList=new ArrayList<MemberVO>();
		Connection conn = JDBCUtility.getConnection();
		MemberDAO memberDAO=MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		memberList=memberDAO.selectMemberList(p,l,f,q);
		
		return memberList;
	}



}
