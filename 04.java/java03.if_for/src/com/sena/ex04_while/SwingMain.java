package com.sena.ex04_while;

import javax.swing.JOptionPane;

public class SwingMain {
	public static void main(String[] args) {
		//java에 swing은 gui환경으로 인터페이스를 만들어준다.
		
		String num=JOptionPane.showInputDialog("숫자를 입력하세요!");
		//System.out.println("입력된 값= "+num);
		
		//실습.숫자 맞추기 게임
		int answer=77;
		int inputNumber=Integer.parseInt(num);
		
		if(inputNumber==answer) System.out.println("정답입니다! 축하합니다!");
		else System.out.println("정답이 아닙니다! ");
		
		
		System.out.println(JOptionPane.showConfirmDialog(null, num));	// return 값 = yes : 0   no : 1  cancel : 2 
		
		

	}
}	
