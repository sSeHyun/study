package com.sena.exercise.exam;

public class HourlyEmployee extends Employee {
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
