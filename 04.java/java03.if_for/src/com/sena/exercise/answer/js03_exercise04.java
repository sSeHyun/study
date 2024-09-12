package com.sena.exercise.answer;

public class js03_exercise04{

	public static void main(String[] args) {
		
		int dice1=0;
		int dice2=0;
		while(dice1+dice2!=5) {
			dice1=(int)(Math.random()*6)+1;
			dice2=(int)(Math.random()*6)+1;
			System.out.println("("+dice1+","+dice2+")");
		}
		if(dice1+dice2==5) 
			System.out.println("눈의 합이 5가 되는 조합"+"("+dice1+","+dice2+")"+
								"의 발생으로 종료합니다.");
	
	}
}

