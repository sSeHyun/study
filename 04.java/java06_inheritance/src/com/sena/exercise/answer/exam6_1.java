package com.sena.exercise.answer;
class Employee6{
	private String name;
	
	public Employee6(String name) {
		this.name=name;
	}
}
class Manager6 extends Employee6{
	private String name;	
	
	public Manager6(String name) {
		super(name);
		this.name=name;
	}
	public void addTeamMember(Employee6 e) {
		System.out.println(name);
	}
}
public class exam6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Manager6[] manager=new Manager6[3];
		
		manager[0]=new Manager6("홍길동");
		manager[1]=new Manager6("홍길자");
		manager[2]=new Manager6("홍길순");
		
		for(int i=0;i<3;i++) {
			manager[i].addTeamMember(manager[i]);
		}
		
		

		
	}

}
