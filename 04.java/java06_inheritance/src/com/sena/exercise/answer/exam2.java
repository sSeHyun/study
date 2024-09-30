package com.sena.exercise.answer;

class Animal {
	void Check_Animal(Animal animal) {
		animal.makeSound();
		
		if(animal instanceof Dog) {
			Dog dog=(Dog) animal;
			System.out.println("This is a dog");
		}
	}
	void makeSound() {}	
}
class Dog extends Animal {
	@Override
	void makeSound() {
		System.out.println("Bark!");
	}
}


class Cat extends Animal {

	@Override
	void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Meow!");
	}
}


public class exam2 {

	public static void main(String[] args) {
		System.out.println("-".repeat(10)+"2번"+"-".repeat(10));
		
		Animal[] animal = new Animal[2];
		
		animal[0]=new Dog();
		animal[1]=new Cat();
		
		for(Animal animals : animal) {
			animals.Check_Animal(animals);
		}

	}

}
