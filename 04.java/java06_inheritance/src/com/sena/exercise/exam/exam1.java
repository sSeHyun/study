package com.sena.exercise.exam;

abstract class Shape {
	void calculateArea() {};
}

class Rectangle extends Shape {

	private int width;
	private int height;

	Rectangle(int width, int height) {
		this.width=width;
		this.height=height;
	}

	@Override
	void calculateArea() {
		double result=width*height;
		System.out.println("Rectangle의 넓이:"+result);
	}
}
class Circle extends Shape {
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

public class exam1 {
	public static void main(String[] args) {
		
		System.out.println("-".repeat(10)+"1번"+"-".repeat(10));
		
		Rectangle rectangle=new Rectangle(10,10);
		rectangle.calculateArea();
		
		Circle circle=new Circle(10);
		circle.calculateArea();
	}
}
