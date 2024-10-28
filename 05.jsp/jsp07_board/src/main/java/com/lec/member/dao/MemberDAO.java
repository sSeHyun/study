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
		String sql = "insert into member(id, pw, name, age, gender, email) "
				   + " values(?,?,?,?,?,?)";
		
		
		int insertCount = 0;
		
		try {
			
			//중복에러 체크	로직 추가하기
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원 등록실패!! !" + e.getMessage());
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
		String sql = "select * from member where id = ?";
		
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
	//회원ID 확인하기
	public boolean isMemberId(String id, String pw) {
		
		boolean isId=false;
		
		MemberVO member = new MemberVO();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from member where id = ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			rs.next();
			if(pw.equals(rs.getString("pw"))) isId=true;
		}catch (Exception e) {
			System.out.println("회원조회실패!"+e.getMessage());
		}finally {
			JDBCUtility.close(null, pstmt, rs);
		}
		
		return isId;
	}

	//4. 회원정보 수정하기
	public int updateMember(MemberVO member) {
		int updateCount=0;
		
		PreparedStatement pstmt=null;
		String sql="update member set pw = ?, name = ?, age = ? , gender = ? ,email = ? "
				   + " where id = ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,member.getPw());
			pstmt.setString(2,member.getName());
			pstmt.setInt(3,member.getAge());
			pstmt.setString(4,member.getGender());
			pstmt.setString(5,member.getEmail());
			pstmt.setString(6,member.getId());
			updateCount=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("회원정보 수정 실패!"+e.getMessage());
		}finally {
			JDBCUtility.close(null, pstmt, null);
		}
		return updateCount;
	}

	//5. 회원삭제하기
	public int deleteMember(String id) {
		int deleteCount=0;
		
		PreparedStatement pstmt = null;
		String sql ="delete from member where id = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원정보 삭제 실패!"+e.getMessage());
		}finally {
			JDBCUtility.close(null, pstmt, null);
		}
		
		return deleteCount;
	}








}
