package com.sena.exercise.exam;

public class ex01_exam {
	public static void main(String[] args) {
		
		//1번답: 3번
		//2번답: 31
		//3번답: 가	
		
		//4번
		int pencils=534;
		int students=30;	
		//학생 한 명이 가지는 연필 수
		int pecilsPerStudent=(pencils/students);
		System.out.println("pecilsPerStudent: "+pecilsPerStudent);
		//남은 연필 수
		int pencilsLeft=(pencils%students);
		System.out.println("pencilsLeft: "+pencilsLeft);
		
		System.out.println("-------------------------");
		
		//5번
		int value=356;
		System.out.println("value: "+(value/100)*100);
		System.out.println("-------------------------");
		
		
		//6번
		int lengthTop=5;
		int lengthBottom=10;
		int height=7;
		double area=(((lengthTop+lengthBottom)*height)/2);
		System.out.println("area: "+area);
		System.out.println("-------------------------");
		
		//7번
		int x=10;
		int y=5;
		
		System.out.println(true); //(x>7)&&(y<=5)
		System.out.println(false);	//(x%3==2)||(y%2 !=1)
		System.out.println("-------------------------");
		
		//8번
		double x1=5.0;
		double y1=0.0;
		
		double z=x1%y1;
		
		if(Double.isNaN(z)) System.out.println("0.0으로 나눌 수 없습니다.");
		else {
			double result=z+10;
			System.out.println("결과:"+result);
		}
		
		
	}	
}
