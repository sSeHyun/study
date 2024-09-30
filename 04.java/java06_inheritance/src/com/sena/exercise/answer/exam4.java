package com.sena.exercise.answer;

abstract class Employee {
	public abstract void calculateSalary(); 
}

class SalariedEmployee extends Employee{
	
	private int salary;
	
	public SalariedEmployee(int salary) {
		this.salary=salary;
	}
	
	@Override
	public void calculateSalary() {
		double result=salary/12;
		System.out.println("급여:"+result);
	}
}

class HourlyEmployee extends Employee {
	
	private int hour_sal;
	private int working_hour;
	
	public HourlyEmployee(int hour_sal,int working_hour) {
		this.hour_sal=hour_sal;
		this.working_hour=working_hour;
	}
	
	@Override
	public void calculateSalary() {
		double result=hour_sal*working_hour;
		System.out.println("급여:"+result);
		
	}
}

public class exam4 {

	public static void main(String[] args) {
		System.out.println("-".repeat(10)+"4번"+"-".repeat(10));
		
		Employee[] emp=new Employee[2];
		
		emp[0]=new SalariedEmployee(30000000);
		emp[1]=new HourlyEmployee(10000,8);
		
		for(Employee i :emp) {
			i.calculateSalary();
		}
		

	}

}
