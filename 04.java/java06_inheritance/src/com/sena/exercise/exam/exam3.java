package com.sena.exercise.exam;

abstract class Vehicle {
	 abstract void move();
}

class Car extends Vehicle {
	@Override
	void move() {
		System.out.println("Car is Moving!");		
	}
}
class Bike extends Vehicle{
	@Override
	void move() {
		System.out.println("Bike is Moving");
	}
}


public class exam3 {

	public static void main(String[] args) {
		System.out.println("-".repeat(10)+"3번"+"-".repeat(10));
		
		// Vehicle 타입의 객체로 Car 객체를 생성한 후, 이를 Car로 다운캐스팅하고 move()를 호출
		Vehicle vehicle=new Car();
		
		if(vehicle instanceof Car) {
		 Car Down_car=(Car) vehicle;
		 Down_car.move();		
		}
		

	}

}
