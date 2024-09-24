package ex01_class;

public class A {
	//생성자
	public A() {System.out.println("A객체를 생성!");}
	
	//1. 중첩클래스(인스턴스{객체} 멤버)
	// 객체가 생성되어야만 접근할 수 있는 속성
	public class B{
		//1. 필드
		String b_field1;
		static String b_field2;
		public B() {/*생성자*/System.out.println("B객체를 생성!");}
		void b_method1() {/*메소드*/System.out.println("(일반)B.b_method1()를 호출!");}
		static void b_method2() {/*메소드*/System.out.println("(정적)B.b_method2()를 호출!");}
	}
	
	//2. 중첩클래스(클래스멤버 즉, static class)
	//	즉, 객체가 생성되지 않고 클래스명으로 직접 접근가능
	public static class C{
		String c_field1;
		static String c_field2;
		public C() {System.out.println("C객체를 생성!");}
		void c_method1() {/*메소드*/System.out.println("C.c_method1()를 호출!");}	
		static void c_method2() {/*메소드*/System.out.println("C.c_method2()를 호출!");}	
	}
	
	void a_method1()  {
		B.b_field2 = "접근가능";
		B.b_method2();
	}
	//3. 중첩클래스(로컬{지역})
	public void a_method2() {
		//로컬 중첩 클래스는 public으로 선언 불가능 
		// a_method1이 호출된 후 실행이 종료되었을 때 메모리에서 삭제가 되기 때문
		class D{
			String d_field1;
			static String d_field2;
			public D() {System.out.println("D객체 생성!");}
			void d_method1() {/*메소드*/System.out.println("(일반)D.d_method1()를 호출!");}
			static void d_method2() {/*메소드*/System.out.println("(정적)D.d_method2()를 호출!");}
		}
		D d = new D();
		d.d_field1 = "접근가능";
		d.d_field2 = "접근가능";
		d.d_method1();
		d.d_method2();
		
	}
}

