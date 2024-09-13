package com.sena.ex04_class;

public class HumanMain {
	public static void main(String[] args) {
		
		//메서드 오버라이딩
		
		Adam adam=new Adam();
		System.out.println("Adam="+ adam.name + "," + adam.gender +"," + adam.age );

		Eve eve=new Eve();
		System.out.println("Eve="+ eve.name + "," + eve.gender +"," + eve.age );
		
		
		adam.speak();
		String message=adam.move();
		System.out.println(message);
		System.out.println(adam.toString());
		
		eve.speak();
		eve.move();
		eve.makeBaby();
		System.out.println(eve.toString());
	}
}
