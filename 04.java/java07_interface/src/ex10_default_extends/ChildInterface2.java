package ex10_default_extends;

public interface ChildInterface2 extends ParentInterface {
	//2. method2를 재정의 한 경우
	void method3();
	
	@Override
	default void method2() {
		/*실행블럭
		부모의 method2(default)를 재정의 */
		System.out.println("ParentInterface.method2(default) 재정의 한 ChildInterface2.method2() 호출!");
	}
}
