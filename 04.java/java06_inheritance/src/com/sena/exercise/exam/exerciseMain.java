package com.sena.exercise.exam;



public class exerciseMain {

	public static void main(String[] args) {
		System.out.println("-".repeat(10)+"1번"+"-".repeat(10));
		
		Rectangle rectangle=new Rectangle(10,10);
		rectangle.calculateArea();
		
		Circle circle=new Circle(10);
		circle.calculateArea();
		
		System.out.println("-".repeat(10)+"2번"+"-".repeat(10));
		
		Animal animal = new Animal();
		
		animal.Check_Animal(new Dog());
		animal.Check_Animal(new Cat());

		System.out.println("-".repeat(10)+"3번"+"-".repeat(10));
		
		// Vehicle 타입의 객체로 Car 객체를 생성한 후, 이를 Car로 다운캐스팅하고 move()를 호출
		Vehicle car=new Car();
		car.move();
		
		System.out.println("-".repeat(10)+"4번"+"-".repeat(10));
		
		SalariedEmployee salariedEmp=new SalariedEmployee(30000000);
		HourlyEmployee hourlyEmp=new HourlyEmployee(10000,8);
		
		salariedEmp.calculateSalary();
		hourlyEmp.calculateSalary();
		
	
		
	}


}
