package com.sena.ex04_class;

public class Adam {
	String name="아담";
	String gender="남자";
	int age=10000;
	
	void speak() {
		System.out.println("말을 합니다!");
	}
	
//	void move() {
//		System.out.println("사냥을 합니다!");
//	}
	
	String move() {
		return "사냥을 합니다!";
	}
	
	@Override
	public String toString() {
		return "Adam [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
}
