package com.sena.exercise.answer;

class Employee1{
	public String name;
	
	Employee1(String name){
		this.name=name;
	}
	
}
class Manager extends Employee1{
	
	public Manager(String name) {
		super(name);
	}
	
	public void addTeamMember(Employee1 e) {
		System.out.println(e.name);
	}
}


public class exam6 {
	 public static void main(String[] args) {
		 Manager[] manager=new Manager[3];
		
		 manager[0]=new Manager("홍길동");
		 manager[1]=new Manager("홍길순");
		 manager[2]=new Manager("홍길자");
		 
		 for(Manager i : manager) {
			 i.addTeamMember(i);
		 }
	}
}
