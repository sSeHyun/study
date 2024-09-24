package com.sena.exercise.exam;

class Person {
	private String name;
	private int age;
	
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
}

class Student extends Person{
	
	private String stdId;
	
	public Student(String name,int age, String stdId) {
		super(name,age);
		this.stdId=stdId;	
	}
	public String getId() {return stdId;}
}

class Teacher extends Person {
	
	private String subject;
	
	public Teacher(String name,int age,String subject) {
		super(name,age);
		this.subject=subject;
	}
	public String getSubject() {return subject;}
}

public class exam5 {

	public static void main(String[] args) {
		System.out.println("-".repeat(10)+"5번"+"-".repeat(10));
		
		Person[] per=new Person[2];
		
		per[0]=new Student("홍길동",999,"1234");
		per[1]=new Teacher("홍길순",9999,"수학");
		
		for(Person i :per) {
			if( i instanceof Student) {
				Student Down_std=(Student) i;
				System.out.println("학번:"+Down_std.getId());
			}else if(i instanceof Teacher) {
				Teacher Down_tea=(Teacher) i;
				System.out.println("과목:"+Down_tea.getSubject());
			}	
		}

	}

}
