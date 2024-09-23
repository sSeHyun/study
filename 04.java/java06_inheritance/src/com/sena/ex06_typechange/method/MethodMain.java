package com.sena.ex06_typechange.method;
/*
 *  1. 상속: 부모 vs 자식(메서드 추가, 메서드 재정의)
 *  	method1 vs method1 재정의, method2를 추가
 *  
 *  2. 형변환
 *   1) 부모로 형변환 후  다시 자식으로 형변환하는 경우
 *   	자식	-> 	부모 형변환 -> 	  자식 형변환
 * 	 			    method1 			method1 
 * 	 			    method2 재정의		method2 재정의?
 * 					method3 삭제		method3 복구?
 * 	 2) 부모에서 직접 자식으로 형변환
 * 		Casting exception이 발생
 * 	3. method의 매개변수로 전달
 * 		methodA(Parent p) <- Child 전달
 * 		methodB(Child c) <- 형변환된 Parent는 OK, 형변환되지 않은(Original) Parent는 예외발생
 **/

public class MethodMain {

	public static void main(String[] args) {
		
		Child child= new Child();
		child.method1();	//부모에서 상속받은 method
		child.method2();	//부모에서 상속받은 method를 재정의한 메서드
		child.method3();	//자식에서 추가된 새로운 메서드
		
		System.out.println("-".repeat(50));
		//Parent parent=new Parent();
		
		//1. 자동 형변환 후에 자식객체에서 부모객체로 형변환 Parent parent =(Parent) child;
		Parent parent =child;	//자동 형변환
		
		//1)method1?? -> 부모객체의 metho1이 호출
		parent.method1();
		//2)method2?? -> 자식객체에서 재정의 된 metho2가 호출됨
		parent.method2();
		//3)method3?? -> 자식 객체에서 새롭게 추가된 method3는 부모 타입으로 형변환시에 삭제됨
		//parent.method3();  -> error
		
		System.out.println("-".repeat(50));
		//2. 부모객체와 자식객체가 동일 타입인 경우에만 형변환 가능
		// 	 따라서, 동일 타입이 아닐 경우 예외가 발생되기에 두 객체가 동일타입여부를 확인해야한다.
		
		 System.out.println("parent==child: "+(parent==child)); //child에서 parent로 형변환되어 true가 도출된다.
		 System.out.println("parent.equals(child): "+(parent.equals(child))); //child에서 parent로 형변환되어 true가 도출된다.
		 System.out.println(parent.getClass().getName()+","+child.getClass().getName());
		 System.out.println(parent.getClass().getSimpleName()+","+child.getClass().getSimpleName());
		
		 System.out.println("-".repeat(50));
		 
		 Parent parent2=new Parent();	//Original Parent
		 System.out.println("parent2==child: "+(parent2==child)); //false
		 System.out.println("parent.equals(child): "+(parent2.equals(child))); //false
		 System.out.println(parent2.getClass().getName()+","+child.getClass().getName());
		 System.out.println(parent2.getClass().getSimpleName()+","+child.getClass().getSimpleName());
		 System.out.println("new Parent()==child: "+(new Parent()==child));
		 
		 System.out.println("-".repeat(50));
		 
		 //3. 자식객체 -> 부모객체 -> 자식객체 : 강제형변환
		 child=(Child)parent; 
		 child.method1();	//부모에서 상속받은 method
		 child.method2();	//부모에서 상속받은 method를 재정의한 메서드
		 child.method3();	//자식에서 추가된 새로운 메서드
		 
		 //4. (Original)부모객체 -> 자식 객체 : error 발생  
		 //child=(Child) parent2; -> java.lang.ClassCastException 예외 발생
			
		 
	}

}
class Parent{
	void method1(){
		System.out.println("Parent.method1이 호출!");
	}
	void method2(){
		System.out.println("Parent.method2이 호출!");
	}
}
class Child extends Parent{

	@Override
	void method2() {
		System.out.println("Child.method2이 호출!");
	}
	void method3() {
		System.out.println("Child.method3이 호출!");
	}
	
}

