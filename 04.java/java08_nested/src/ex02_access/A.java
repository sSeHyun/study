package ex02_access;

public class A {
	String a_field1;
	static String a_field2;
	void a_method1() {}
	static void a_method2() {}
	
	//1. A의 인스턴스 멤버
	class B{
		void b_method1() {
			a_field1="접근가능";
			a_field2="접근가능";
			a_method1();
			a_method2();
		}
	}
	
	//2. A의 정적(static)멤버 - 정적멤버만 접근 가능
	static class C{
		void c_method1() {
			//a_field1="접근불가능"; -> static member가 아님.
			a_field2="접근가능";
			//a_method1(); -> 접근불가능
			a_method2(); //접근가능
		}
	}
	
}
