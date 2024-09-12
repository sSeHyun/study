package com.sena.ex01_if;

public class ifDiceMain {
	public static void main(String[] args) {
		//	실습. 주사위 던지기 
		//	"random"번 주사위가 나왔습니다..를 출력하는 로직
		
		int dice=(int)(Math.random()*6)+1;
		System.out.println(dice);
		if(dice==1) System.out.println("1번 주사위가 나왔습니다.");
		else if(dice==2) System.out.println("2번 주사위가 나왔습니다.");
		else if(dice==3) System.out.println("3번 주사위가 나왔습니다.");
		else if(dice==4) System.out.println("4번 주사위가 나왔습니다.");
		else if(dice==5) System.out.println("5번 주사위가 나왔습니다.");
		else System.out.println("6번 주사위가 나왔습니다.");
	}
}
