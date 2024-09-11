package com.sena.ex03_datatype;

public class StringMain {

	public static void main(String[] args) {
		//참조타입 - class, array, interface,enum
		//문자열타입인 String은 class이기 때문에 참조타입(class)이다.
		//즉, String(문자열)은 Reference타입이다. 문자열을 String이라는 class이다.
		//Java에서 class로 선언된 모든것은 참조타입이다.
		//문자열을 표현할 때는 큰따옴표로 선언한다.
		//작은 따옴표('')는 char타입을 선언할때 사용한다.
		
		char c1='A';
		//char c2="A"; -- error ,char은 작은 따옴표로 선언
		//char c3='AA' --error , char는 하나의 문자만 사용가능
		
		String s1="A";
		String s2="AAAAAAAAAAAAAAAAA";
		System.out.println("s2의 클래스 이름="+s2.getClass().getName());
		
		//참조타입은 객체가 저장되어 있는 주소를 참조한다는 의미
		System.out.println("s1의 값="+s1+" ,s2의 값="+s2);
		
		//1. hashcode() 객체가 저장되어있는 메모리 주소를 int로 리턴하는 메서드
		//문자열  A or AAAAA...가 저장되어있는 주소를 리턴
		System.out.println("s1이 참조하는 메모리 주소 ="+s1.hashCode()+" ,s2가 참조하는 메모리 주소= "+s2.hashCode());
		
		//참조타입은 3개의 멤버가 있는데 필드(속성), 생성자, 메서드
		//속성=length, 여러개의 String(), 여러개의 메서드 replace()...
		
		//2. toString(): String으로 생성된 객체는 저장되어 있는 값을 리턴
		System.out.println("s1.toString()="+s1.toString());
		System.out.println("s2.toString()="+s2.toString());
		
		//3. literal vs constant
		//공통점은 값을 변경할 수 없다.
		//다른점은 다른 객체에서 공용으로 사용가능여부
		//JAVA에서 상수의 변수명을 관례로 모두 대문자로 선언하고 
		//단어마다 언더바(_)로 연결해서 명명한다
		//JAVA에서 상수는 final로 선언된 변수를 의미하고 상수는 
		//초기값을 정의해야하고 변경할 수 없다.
		
		final int min_value=0; 	//에러는 아니지만 관례에 어긋남.
		final int MIN_VALUE=0;	//관례에 따른 명명 방법
		
		// 상수 즉, final로 선언된 변수 값을 변경할 수 없다.
		//min_value=100;	//상수는 재선언 불가하다. 
		//MIN_VALUE=100; --ERROR
		
		final int MAX_VALUE; 	//선언만 되고 초기화 하지 않은 경우
		MAX_VALUE=1000; 		//값의 변경이 아닌 초기화
		//MAX_VALUE=9999;			초기화 이후 값의 변경 할 경우 발생된 ERROR
		
		final double PI=3.141592; 	//값의 변경이 일어나지 않는 변수의 경우 final사용
	}

}
