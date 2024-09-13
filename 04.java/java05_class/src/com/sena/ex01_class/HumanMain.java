package com.sena.ex01_class;

public class HumanMain {
//클래스는 참조타입이다.
	public static void main(String[] args) {
		String name1=new String(); 				//기본생성자 - 생성자를 아무것도 생성하지 않았을때, 기본생성자는 (컴파일러에서)자동으로 생성된다.
		String name2=new String("소향");		//생성자 - 생성자가 하나라도 생성되어있을때, 기본생성자는 자동으로 생성되지않는다.
		
		Human human1=new Human();
		Human human2=new Human("소향");
		Human human3=new Human("소향",43);
		Human human4=new Human(43,"소향");
		Human human5=new Human("소향","F",43,"999999-9999999");
		
		System.out.println("human1.hashCode()="+human1.hashCode());
		System.out.println("human2.hashCode()="+human2.hashCode());
		System.out.println("human3.hashCode()="+human3.hashCode());
		System.out.println("human4.hashCode()="+human4.hashCode());
		System.out.println("human5.hashCode()="+human5.hashCode());
		
		System.out.println("-".repeat(50));
		
		System.out.println("human1.name = " + human1.name);
		System.out.println("human2.name = " + human2.name);
		System.out.println("human3.name = " + human3.name + ", " + human3.age);
		System.out.println("human4.name = " + human4.name + ", " + human4.age);
		System.out.println("human5.name = " + human5.name + ", " + human5.gender
				+ ", " + human5.age + ", " + human5.ssn);
		
	}

}
