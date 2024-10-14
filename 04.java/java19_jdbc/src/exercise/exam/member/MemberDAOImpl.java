package exercise.exam.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class MemberDAOImpl implements MemberDAOService {
	
	private MemberVO inputBoard() {
		
		MemberVO member=new MemberVO();
		
		String member_pw=JOptionPane.showInputDialog("pw를 입력하세요.");
		String member_name=JOptionPane.showInputDialog("이름을 입력하세요.");
		String member_age=JOptionPane.showInputDialog("나이를 입력하세요.");
		String member_gender=JOptionPane.showInputDialog("성별을 입력하세요.");
		String member_email=JOptionPane.showInputDialog("e-mail을 입력하세요.");
		
		member.setMember_pw(member_pw);
		member.setMember_name(member_name);
		member.setMember_age(member_age);
		member.setMember_gender(member_gender);
		member.setMember_email(member_email);
		
		return member;
	}

	@Override
	public void createMember() {
		MemberVO member=inputBoard();
		
		ConnectionFactory cf=new ConnectionFactory();
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=null;
		String sql=cf.getInsert();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getMember_pw());
			pstmt.setString(2, member.getMember_name());
			pstmt.setString(3, member.getMember_age());
			pstmt.setString(4, member.getMember_gender());
			pstmt.setString(5, member.getMember_email());
			
			int row=pstmt.executeUpdate();
			System.out.println(row+"건이 성공적으로 등록되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e2) {
				
			}
		}
		
	}

	@Override
	public ArrayList<MemberVO> listMember() {
		
		 ArrayList<MemberVO> memberList=new ArrayList<MemberVO>();
		 
		 ConnectionFactory cf=new ConnectionFactory();
		 Connection conn=cf.getConnection();
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 String sql=cf.getSelect()+" where member_id between ? and ? "
				 					+"order by member_id desc";
		 
		 
		
		 try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 1);
				pstmt.setInt(2, 10);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					MemberVO member = new MemberVO();
					member.setMember_id(rs.getInt("member_id"));
					member.setMember_pw(rs.getString("member_pw"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_age(rs.getString("member_age"));
					member.setMember_gender(rs.getString("member_gender"));
					member.setMember_email(rs.getString("member_email"));
					memberList.add(member);
					
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// dummy
				}
			}		
				
		return memberList;
	}

	@Override
	public MemberVO viewMember(int member_id) {
		
		MemberVO member=new MemberVO();
		
		ConnectionFactory cf=new ConnectionFactory();
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=cf.getSelect()+" where member_id = ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, member_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member.setMember_id(rs.getInt("member_id"));
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_age(rs.getString("member_age"));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_email(rs.getString("member_email"));
			}
			else {
				System.out.println(String.format("%S 회원의 정보가 존재하지 않습니다.",member_id));
			}
			
		} catch (Exception e) {
			System.out.println("회원 조회 실패!!!!");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// dummy
			}
			
		}
		return member;
		
	}

	@Override
	public void updateMember(int member_id) {
		
		MemberVO member=viewMember(member_id);
		
		String member_pw=JOptionPane.showInputDialog("수정할 회원의 비밀번호를 입력하세요",member.getMember_pw());
		String member_name=JOptionPane.showInputDialog("수정할 회원의 이름을 입력하세요",member.getMember_name());
		String member_email=JOptionPane.showInputDialog("수정할 회원의 이메일을 입력하세요",member.getMember_email());
		
		ConnectionFactory cf=new ConnectionFactory();
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=null;
		int row=0;
		
		String sql=cf.getUpdate();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_pw);
			pstmt.setString(2, member_name);
			pstmt.setString(3, member_email);
			pstmt.setInt(4, member_id);
	
			row=pstmt.executeUpdate();
			System.out.println(String.format("%d 회원의 정보가 수정되었습니다.",member_id));
		} catch (SQLException e) {
			System.out.println("회원 정보 수정 실패!!!!");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// dummy
			}
		}			
			
	}

	@Override
	public void deleteMember(int member_id) {
		ConnectionFactory cf=new ConnectionFactory();
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=null;
		
		String sql=cf.getDelete();
		int row=0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member_id);
			row = pstmt.executeUpdate();			
			System.out.println(String.format("회원번호(" + member_id + ") 회원정보가 성공적으로 삭제되었습니다!!"));
		} catch (SQLException e) {
			System.out.println("회원정보 삭제 실패!!!!");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// dummy
			}
		}	
	}

	@Override
	public ArrayList<MemberVO> findByNameMember(String member_name) {
		
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect() 
				+ " where member_name like '%" +member_name  + "%'"
				+ " order by member_id desc";		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setMember_id(rs.getInt("member_id"));
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_age(rs.getString("member_age"));
				member.setMember_email(rs.getString("member_email"));
				memberList.add(member);
			}
		
		} catch (SQLException e) {
			System.out.println("회원목록(by 이름) 조회 실패!!!");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// dummy
			}
		}		
	
		return memberList;
	}

	@Override
	public ArrayList<MemberVO> findByEmailMember(String member_email) {
		
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect() 
				+ " where member_email like '%" +member_email  + "%'"
				+ " order by member_id desc";		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setMember_id(rs.getInt("member_id"));
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_age(rs.getString("member_age"));
				member.setMember_email(rs.getString("member_email"));
				memberList.add(member);
			}
		
		} catch (SQLException e) {
			System.out.println("회원목록(by 이메일) 조회 실패!!!");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// dummy
			}
		}		
	
		return memberList;
	}
	
	

}
