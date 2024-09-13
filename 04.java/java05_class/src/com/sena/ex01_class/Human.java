package com.sena.ex01_class;
/*
	클래스
	
	1. 클래스의 명명규칙
	
	   1) 하나 이상의 문자로 이루어 져야 한다. 단, 첫 글자는 대문자로 시작해야 하고
	      한글이름도 가능하지만 관례적으로 영문이름으로 정의한다.
	   2) 첫 번째는 숫자가 올 수 없다.
	   3) $, _이외의 특수문자는 사용할 수 없다.
	   4) Java에약어(for, if...)는 사용할 수 없다.
	   
	2. 클래스를 선언하는 키워드 class는 반드시 소문자로 작성해야 한다.
	3. 일반적으로 소스파일 하나당 한 개의 클래스를 정의한다. 하지만 여러개의 클래스도
	   선언이 가능하다. 다만 클래스당 한 개의 ~.class파일 각각 생성된다.
	   다만, public(접근제한자)은 소스파일명과 동일한 클래스에만 선언할 수 있다.
	4. 소스파일명과 class명은 동일해야 한다.
	5. 클래스의 역할
	 1) 객체를 생성하는 역할 즉, 생성자를 이용해서 객체(인스턴스)를 생성한다.
	 2) 객체를 생성하기 위한 설계도 역할을 한다.
*/
public class Human {
	//글래스 멤버
	//1. 필드 속성
	String name;
	String gender;
	int age;
	String ssn;
	
	
	//2. 생성자(객체생성할 때 호출)
	// 생성자는 클래스 이름과 동일해야하며 리턴타입이 없다.
	// 생성자는 시그니처가 다르면 여러개 선언할 수 있다.
	// 시그니처가 다르다는 것은 매개변수의 데이터타입, 순서, 갯수가 다른 경우를 말한다.
	
	Human(){}
	Human(String name){
		System.out.println("human2="+ name);
		this.name=name;
	}
	Human(int age){
		this.age=age;
	}
	Human(String name,int age){
		this.name=name;
		this.age=age;
	}
	Human(int age,String name){
		this.age=age;
		this.name=name;
	}
	Human(String name, String gender, int age, String ssn){
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.ssn=ssn;
	}
	
	//3. 메서드
	// 문법 : 리턴타입 메서드명(매개변수){}
	// 메서드는 객체의 기능을 정의한다.
	// void로 정의하였을 땐 return값이 없다.
	// 정의한 형태로 return해줘야함.		 ex) String think(){return string값}
	void think() {}
	void eat() {}
	void speak() {}
	void move() {}

}

class 클래스 {}
class Adam {}
class Eve {}
class Kain {}


