package ex09_default_method;

public interface MyInterface {
	void method1();
	//void method2();	//1년뒤에 업무변경으로 추가된 로직
	default void method2() {
		System.out.println("1년뒤에 모든 클래스에 적용되기 위한 공통기능이 추가");
	}; 
	default void method3() {
		System.out.println("3년뒤에 모든 클래스에 적용되기 위한 공통기능이 추가");
	}
}
