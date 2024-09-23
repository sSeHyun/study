package com.sena.exercise.exam;

public class Animal {
	void Check_Animal(Animal animal) {
		animal.makeSound();
		
		if(animal instanceof Dog) {
			Dog dog=(Dog) animal;
			System.out.println("This is a dog");
		}
	}
	void makeSound() {}
	
}
