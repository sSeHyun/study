package exercise.exam.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class MemberMenu {
	
	public MemberMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public void mainMenu() throws Exception {
		
		mainTextMenu();
		
		MemberDAOImpl mbdao=MemberFactory.getInstance();
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		while(true) {
			switch((char)br.read()) 
			{
			case '1': mbdao.createMember(); break;
			case '2': mbdao.listMember(); break;
			case '3': mbdao.viewMember(1); break;
			case '4': mbdao.updateMember(1);; break;
			case '5': mbdao.deleteMember(1); break;
			case '6': mbdao.findByNameMember(""); break;
			case '7': mbdao.findByEmailMember(""); break;
			case '0': System.out.println("프로그램종료!!!"); System.exit(0);
			}
		}	
		
	}
	
	private int mainJOptionPanMenu() {
		
		String menuNo=JOptionPane.showInputDialog(
				"======회원관리 프로그램======\n\n"+
				"1. 신규회원등록\n"+
				"2. 전체회원조회\n"+
				"3. 회원상세조회\n"+
				"4. 회원정보수정\n"+
				"5. 회원정보삭제\n"+
				"6. 이름으로 검색\n"+
				"7. email로 검색\n"+
				"0. 종료\n"+
				"========================\n\n"+
				"처리할 메뉴번호를 입력하세요!!\n");
		if((menuNo==null)||(menuNo.equals(""))) {
			return 0;
		}else {
			return Integer.parseInt(menuNo);
		}
	}
	
	public void mainTextMenu() {
		
		StringBuffer sb=new StringBuffer();
		sb.append("======회원관리 프로그램======\n\n");
		sb.append("1. 신규회원등록\n");
		sb.append("2. 전체회원조회\n");
		sb.append("3. 회원상세조회\n");
		sb.append("4. 회원정보수정\n");
		sb.append("5. 회원정보삭제\n");
		sb.append("6. 이름으로 검색\n");
		sb.append("7. email로 검색\n");
		sb.append("0. 종료\n");
		sb.append("========================\n\n");
		sb.append("처리할 메뉴번호를 입력하세요!!\n");
		System.out.println(sb.toString());
	}
	
	public void mainMemberMenu() {
		
		MemberDAOImpl mbdao=MemberFactory.getInstance();
		
		while(true) {
			
			int menuNo=mainJOptionPanMenu();
			
			switch(menuNo) {
			
			case 1: createMember(mbdao); break;
			case 2: listMember(mbdao);break;
			case 3: viewMember(mbdao); break;
			case 4: updateMemeber(mbdao); break;
			case 5: deleteMember(mbdao); break;
			case 6: findByName(mbdao); break;
			case 7: findByEmail(mbdao); break;
			case 0: System.out.println("프로그램종료!!!"); System.exit(0);
			}
		}
	}

	private void findByEmail(MemberDAOImpl mbdao) {
		String member_email = JOptionPane.showInputDialog("검색할 회원의 이메일을 입력하세요!!");
		
		if((member_email==null) || (member_email.equals(""))) {
			return;
		} else {
			ArrayList<MemberVO> members = mbdao.findByEmailMember(member_email);
			
			String memberList = "=".repeat(10)
					  + "ID|\t\tPW|\t\t회원이름|\t\t성별|\t\t나이|\t\t이메일"
				      + "=".repeat(10) + "\n";

			for(MemberVO member:members) {
				memberList += member.toString() + "\n";
			}
				JOptionPane.showConfirmDialog(null, memberList);				
		}
		
		
	}

	private void findByName(MemberDAOImpl mbdao) {
		
		String member_name = JOptionPane.showInputDialog("검색할 회원의 이름을 입력하세요!!");
		
		if((member_name==null) || (member_name.equals(""))) {
			return;
		} else {
			ArrayList<MemberVO> members = mbdao.findByNameMember(member_name);
			
			String memberList = "=".repeat(10)
					  + "ID|\t\tPW|\t\t회원이름|\t\t성별|\t\t나이|\t\t이메일"
				      + "=".repeat(10) + "\n";

			for(MemberVO member:members) {
				memberList += member.toString() + "\n";
			}
				JOptionPane.showConfirmDialog(null, memberList);				
		}
		
	}

	private void deleteMember(MemberDAOImpl mbdao) {
		String member_id=JOptionPane.showInputDialog("삭제할 회원의 ID를 입력하세요.");
		if((member_id==null) || (member_id.equals(""))) {
			return;
		} else {
			mbdao.deleteMember(Integer.parseInt(member_id));
		}
		
	}

	private void updateMemeber(MemberDAOImpl mbdao) {
		String member_id=JOptionPane.showInputDialog("수정할 회원의 ID를 입력하세요.");
		if((member_id==null) || (member_id.equals(""))) {
			return;
		} else {
			mbdao.updateMember(Integer.parseInt(member_id));
		}
	}

	private void viewMember(MemberDAOImpl mbdao) {
		String member_id=JOptionPane.showInputDialog("조회할 회원의 ID를 입력하세요.");
		
		if(member_id==null||member_id.equals("")) {
			return;
		}else {
			MemberVO member=mbdao.viewMember(Integer.parseInt(member_id));
			
			JOptionPane.showConfirmDialog(null, "회원 ID: "+member.getMember_id()+"\n"
											    +"회원 PW: "+member.getMember_pw()+"\n"
											    +"회원 이름: "+member.getMember_name()+"\n"
											   +"회원 성별: "+member.getMember_gender()+"\n"
											   +"회원 나이:" +member.getMember_age()+"\n"
											   +"회원 이메일:" +member.getMember_email()+"\n");
		}	
	}

	private void listMember(MemberDAOImpl mbdao) {
		ArrayList<MemberVO> members = mbdao.listMember();
		
		System.out.println("=".repeat(60));
		System.out.println("회원ID\t\t회원PW\t\t회원이름\t\t회원성별\t\t회원나이\t\t회원이메일");
		System.out.println("=".repeat(60));
		
		for(MemberVO member:members) {
			System.out.println(member.toString());
		}
		System.out.println("----------- 게시글목록조회 종료 ----------");
		
	}

	private void createMember(MemberDAOImpl mbdao) {
		mbdao.createMember();
		
	}

	
	
	
	
}
