package com.sena.exercise.answer;

class Person_{
	private String name;
	public Person_(String name) {
	this.name=name;
	}
	
	public String getName() {return name; }
}

 interface Worker {
	public void doWork();
}
 class Engineer extends Person_ implements Worker {
	 public Engineer(String name) {
		 super(name);
		 }
		@Override
		public void doWork() {System.out.println("do work!");}
}

public class exam10 {
	public static void main(String[] args) {
	System.out.println("-".repeat(10)+"10번"+"-".repeat(10));
		
		Engineer engi=new Engineer("홍길동");
		System.out.println(engi.getName());
		engi.doWork();
		
	}
}
