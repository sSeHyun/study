package ex03_map.hashtable;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class HashtableMain {

	public static void main(String[] args) {
		Map<String,String> map =new Hashtable<String, String>();
		
		//로그인 정보
		map.put("hong", "12345");
		map.put("sonny", "6789");
		map.put("sohyang", "abcde");
		map.put("kangin", "fghij");

		//1. containsKey() - 키 존재 여부 리턴
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("id와 pw를 입력하세요.  >");
			System.out.println("ID  >");
			String id=scanner.nextLine();
			System.out.println("PW  >");
			String pw=scanner.nextLine();
			
			if(map.containsKey(id)) {
				if(map.get(id).endsWith(pw)){
					System.out.println("로그인 성공!");
				}else {
					System.out.println("로그인 실패!");
				}
			}else {
				System.out.println("ID를 찾지못했습니다. 다시 입력하세요.");
				break;
			}
		}
		
		System.out.println("프로그램 종료");
		 
	}

}
