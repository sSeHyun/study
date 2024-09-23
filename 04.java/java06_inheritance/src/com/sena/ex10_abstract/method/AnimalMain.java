package com.sena.ex10_abstract.method;

public class AnimalMain {

	public static void main(String[] args) {
		
		//Animal animal=new Animal();	추상클래스는 객체생성 불가능
		Animal dog=new Dog();
		dog.breath();
		dog.sound();
		System.out.println("-".repeat(20));
		
		Animal cat=new Cat();
		cat.breath();
		cat.sound();
		System.out.println("-".repeat(20));
		
		Animal bird=new Bird();
		bird.breath();
		bird.sound();
		System.out.println("-".repeat(20));
		
		Animal tiger=new Tiger();
		tiger.breath();
		tiger.sound();
		System.out.println("-".repeat(20));
		
		Animal lion=new Lion();
		lion.breath();
		lion.sound();
		System.out.println("-".repeat(20));
	}

}
