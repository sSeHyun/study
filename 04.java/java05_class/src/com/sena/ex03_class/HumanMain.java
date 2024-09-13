package com.sena.ex03_class;

public class HumanMain {

	public static void main(String[] args) {
		
		// 메서드 오버로딩
		Human human1=new Human("소향");
		human1.speak();
		human1.speak(45,"한국어");
		human1.speak("한국어",45);
		
		System.out.println("-".repeat(50));
		
		Human human2=new Human("스티브");
		human2.speak();
		human2.speak("영어");
		human2.speak(23,"영어");
		human2.speak("영어",23);
		
		
		
		

	}

}
