package exercise.exam.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			case '2': mbdao.deleteMember(); break;
			case '3': mbdao.viewMember(); break;
			case '4': mbdao.updateMember();; break;
			case '5': mbdao.deleteMember(); break;
			case '6': mbdao.findByNameMember(); break;
			case '7': mbdao.findByEmailMember(); break;
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
			case 2: listMember();break;
			case 3: viewMember(); break;
			case 4: updateMemeber(); break;
			case 5: deleteMember(); break;
			case 6: findByName(); break;
			case 7: findByEmail(); break;
			case 0: System.out.println("프로그램종료!!!"); System.exit(0);
			}
		}
	}

	private void findByEmail() {
		// TODO Auto-generated method stub
		
	}

	private void findByName() {
		// TODO Auto-generated method stub
		
	}

	private void deleteMember() {
		// TODO Auto-generated method stub
		
	}

	private void updateMemeber() {
		// TODO Auto-generated method stub
		
	}

	private void viewMember() {
		// TODO Auto-generated method stub
		
	}

	private void listMember() {
		// TODO Auto-generated method stub
		
	}

	private void createMember(MemberDAOImpl mbdao) {
		mbdao.createMember();
		
	}

	
	
	
	
}
