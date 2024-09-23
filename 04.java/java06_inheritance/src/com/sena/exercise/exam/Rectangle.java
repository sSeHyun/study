package com.sena.exercise.exam;

public class Rectangle extends Shape {
	//1. 필드
	private int width;
	private int height;
	
	//2. 생성자
	public Rectangle(int width, int height) {
		this.width=width;
		this.height=height;
	}
	//3.메서드
	@Override
	void calculateArea() {
		double result=width*height;
		System.out.println("Rectangle의 넓이:"+result);
	}
}
