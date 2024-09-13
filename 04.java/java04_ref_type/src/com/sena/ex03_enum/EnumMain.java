package com.sena.ex03_enum;

import java.util.Calendar;

// enum은 '열거형(enumerated type)'이라고 하며 연관된 상수들의 집합이다
// JAVA에서는 final로 지정된 변수를 상수라고 하는데 enum은 상수로
// 계절(봄/여름/가을/겨울), 성별(남/여), 요일(월/화/수/목/금/토/일) 등과 같이 한전된 값을 가지는 데이터 타입을 말한다.
public class EnumMain {

	public static void main(String[] args) {
		
		// enum은 객체생성연산자를 사용해서 객체를 생성할 수 없다.
		// Week today = new Week()로 객체(인스턴스)화 할 수 없다.
		// Week 열거타입을 선언했다면 열거 타입을 정의해서 사용할 수 있다.
		// 열거타입은 하나의 데이터타입(참조타입, 사용자가 새롭게 정의한 데이터타입)이기 때문에 변수로 선언할 때 '열거타입 변수로'선언하고 사용해야 한다.
		// 열거타입으로 변수를 선언했다면 열거 상수(값)를 저장하거나 사용할 수 있다.
		// 열거상수(값)는 단독으로 사용할 수 없고 "열거타입.열거상수(값)" 형태로 사용해야 한다.
		
		//Week today = new Week();	 -error) 열거타입은 객체화 할 수 없다.
		
		Week today=null;
		System.out.println("today: "+today.FRIDAY);
		System.out.println("today: "+Week.FRIDAY);
		
		// 현재요일을 확인하기
		// Calender를 이용해서 날짜를 제어할 수 있다
		// Calender는 String, System처럼 기본 클래스이다. 
		// 즉 객체를 생성하지 않고 클래스를 바로 사용할 수있다.
		Calendar cal=Calendar.getInstance();
		System.out.println("현재일자="+cal.toString());
		System.out.println("현재일자="+cal.get(Calendar.DAY_OF_WEEK)); //DAY_OF_WEEK : 1=일 ....7=토	
		
		int today_week=cal.get(Calendar.DAY_OF_WEEK);
		switch(today_week) {
		case 1: today=Week.SUNDAY; break;
		case 2: today=Week.MONDAY; break;
		case 3: today=Week.TUESDAY; break;
		case 4: today=Week.WENDNESDAY; break;
		case 5: today=Week.THURSDAY; break;
		case 6: today=Week.FRIDAY; break;
		case 7: today=Week.SATURDAY;
		}
		System.out.println(String.format("오늘의 현재 요일은 %s 입니다",today));
		
		//사원테이블에서 주민번호의 7번쨰로 남,여를 구분
		int gender=1;	//테이블에서 가져왔다고 가정
		
		if(gender==1 || gender==3) System.out.println("이 사원은"+Gender.남자+"입니다.");
		else System.out.println("이 사원은"+Gender.여자+"입니다.");
		

	}

}
