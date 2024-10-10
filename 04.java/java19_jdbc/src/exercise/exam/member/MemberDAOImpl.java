package exercise.exam.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ex02_board.ConnectionFactory;

public class MemberDAOImpl implements MemberDAOService {
	
	private MemberVO inputBoard() {
		
		MemberVO member=new MemberVO();
		
		String member_id=JOptionPane.showInputDialog("id를 입력하세요.");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void viewMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<MemberVO> findByNameMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemberVO> findByEmailMember() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
