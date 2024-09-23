package ex01_interface;

public class AnimalMain {
	public static void main(String[] args) {
		//Interface는 추상클래스처럼 객체 생성 불가
		//Animal animal=new Animal();
		
		//1. interface
		Animal dog=new Dog();
		Animal cat=new Cat();
		Animal bird=new Bird();

		dog.sound();
		dog.breath();
		
		cat.sound();	
		cat.breath(); 
		
		bird.sound();
		bird.breath();
		
		System.out.println("-".repeat(10)+"타입변환(자동형변환)"+"-".repeat(10));

		//2. 타입변환(자동형변환)
		animalSound(new Dog());
		animalSound(new Cat());
		animalSound(new Bird());
		animalSound(new Tiger());
		animalSound(new Lion());
		
	}
	
	public static void animalSound(Animal animal) {
		animal.sound();
		animal.breath();
	}
}
