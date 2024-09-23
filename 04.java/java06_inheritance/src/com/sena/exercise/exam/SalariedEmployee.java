package com.sena.exercise.exam;

public class SalariedEmployee extends Employee{
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
