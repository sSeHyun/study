package com.sena.ex10_abstract.method;

public abstract class Animal {
	
	void breath(){
		System.out.println("숨을 쉰다.");
	}
	//abstract(추상화)로 선언시 반드시 자식클래스에서 구현해야함.
	//또한 추상메서드를 정의한 클래스는 반드시 추상클래스로 선언해야한다.
	abstract void sound();	
								
}	
class Dog extends Animal{
	@Override
	void sound() {
		System.out.println("멍멍하고 소리를 낸다.");
	}
}
class Cat extends Animal{
	@Override
	void sound() {
		System.out.println("야옹하고 소리를 낸다.");
	}
}
class Bird extends Animal{
	@Override
	void sound() {
		System.out.println("짹짹하고 소리를 낸다.");
	}
}
class Tiger extends Animal{
	@Override
	void sound() {
		System.out.println("어흥하고 소리를 낸다.");
	}
}
class Lion extends Animal{
	@Override
	void sound() {
		System.out.println("어흥!하고 소리를 낸다.");
		
	}
}