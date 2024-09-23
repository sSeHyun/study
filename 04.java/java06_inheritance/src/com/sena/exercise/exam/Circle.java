package com.sena.exercise.exam;

public class Circle extends Shape {
	private int radius;
	
	public Circle(int radius) {
		this.radius=radius;
	}
	
	@Override
	void calculateArea() {
		double result=Math.PI*radius*radius;
		System.out.println("Circle의 넓이: "+ result);
	}
}
