package com.lec.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.lec.db.JDBCUtility;
import com.lec.member.vo.MemberVO;

public class MemberDAO {
	
	//Singleton
	private MemberDAO() {}
	private static MemberDAO memberDAO;
	public static MemberDAO getInstance() {
		if(memberDAO==null) memberDAO=new MemberDAO();
		return memberDAO;
	}
	
	Connection conn=null;
	DataSource ds=null;
	
	public void setConnection(Connection conn) {
		this.conn=conn;
	}
	
	//1. 회원 추가
		
	public int insert(MemberVO member) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into member(id, pw, name, age, gender,email) "
				
				   + " values(?,?,?,?,?,?)";
		
		int insertCount = 0;
		
		try {
			pstmt = conn.prepareStatement("select max(bno) from board");
			rs = pstmt.executeQuery();
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원 등록실패!!!");
		} finally {
			JDBCUtility.close(null, pstmt, rs);
		}
		return insertCount;
		
	}

	

	//2. 회원 조회하기
	public List<MemberVO> selectMemberList(int p, int l, String f, String q) {
		
		MemberVO member=null;
		List<MemberVO> memberList = new ArrayList<>();
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql = "select * from member "
				   + " where " + f + " like ?"
				   + " limit ?, " + l;
		
		int startRow=(p-1) * l;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + q + "%");
			pstmt.setInt(2, startRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
				
				memberList.add(member);
			}
		} catch (Exception e) {
			System.out.println("회원목록조회실패!!! " + e.getMessage());
		} finally {
			JDBCUtility.close(null, pstmt, rs);
		}
		return memberList;	
	}
	
	//3. 회원정보 상세보기
	public MemberVO selectMember(String id) {
		MemberVO member = new MemberVO();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(id);
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("회원정보 상세보기 실패!!! " + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return member;
	}




	
	
	
	
	
	//4. 회원정보 수정하기
	//5. 회원삭제하기

}