package com.sena.exercise.answer;

public class ex01_answer {
	public static void main(String[] args) {
		
		/*
		  
		  1. JDK와 JRE의 차이점을 설명한 것 중 틀린 것은 무엇입니까?  (4번)
		  	 1.JDK는 JRE와 컴파일러 등의 개발 도구가 포함된다  
		    2.자바 프로그램을 개발하려면 JDK가 반드시 필요하다.  
		    3.자바 프로그램을 실행만 하려면 JRE를 설치해도 상관없다.  
		    4.JRE에는 컴파일러 (javac.exe)가 포함되어 있다.  
		    
		 2. JVM에 대한 설명으로 틀린 것은 무엇입니까?  (3번)
		  	1.JVM은 java.exe 명령어에 의해 구동된다.  
		  	2.JVM은 바이트 코드를 기계어로 변환시키고 실행한다.  
		  	3.JVM은 운영체제에 독립적이다(운영체제별로 동일한 .JVM이 사용된다 ).  
		  	4. 바이트 코드는 JVM에 독립적이지만. .JVM은 운영체제에 종속적이다. 
		  	 
		 3. 자바 프로그램 개발 과정을 순서대로 나열하세요  ( 3 -> 1 -> 2 -> 4)
		 	1. javac.exe로 바이트 코드 파일(~.class)을 생성한다.  
		 	2. java.exe로IVM을 구동시킨다.  
		 	3. 자바 소스 파일(~.java)을 작성한다.  
		 	4. JVM은 main() 메소드를 찾아 메소드 블록을 실행시킨다.
 
		 4. 자바 소스 파일을 작성할 때 틀린 것은 무엇입니까?  
			1. 자바 소스 파일명과 클래스 이름은 대소문자가 동일해야 한다.  
			2. 클래스 블록과 메소드 블록은 반드시 중괄호 {}로 감싸야 한다.  
			3. 실행문 뒤에는 반드시 세미콜론(;)을 붙여야 한다. 
			4. 주석은 문자열 안에도 작성할 수 있다.  
			
		5. 자바 주석문의 종류가 아닌 것은 무엇입니까?  (4번)
			1. 행주석
			2. 범위 주석
			3. API 도큐먼트 주석
			4. 범위 주석
			
		6. 이클립스에 대한 설명으로 플린 것은 무엇입니까?  (4번)
			1. 이클립스는 JDK (JRE)를 설치해야만 실행할 수 있다. 
			2. 이클립스에서 소스 파일을 저장하면 지동 컴파일되어 바이트 코트 파일이 생성된다 
			3. 워크스페이스는 프로젝트들이 생성되는 기본 디렉토리를 말한다. 
			4.metadata는 프로젝트의 소스 파일들이 저장되는 디렉토리이다.
			
			
			
			
			
			1. 자바에서 변수에 대한 설명 중 틀린 것은 무엇입니까? (4번)
				1. 변수는 하나의 값만 저장할 수 있다. 
				2. 변수는 선언 시에 사용한 타입의 값만 저장할 수 있다. 
				3. 변수는 변수가 선언된 중괄호(|) 안에서만 사용 가능하다. 
				4. 변수는 초기값이 저장되지 않은 상태에서 읽을 수 있다.
				
 			2. 변수 이름으로 사용 가능한 것을 모두 선택하세요(1,5번)
				1. modelName
				2. class 
				3. 6hour 
				4. $value
				5. _age
				6. int

			3. 타음 표의 빈칸에 자바의 기본 타입(Primitive Type) 8개를 적어보세요 
				크기/타입 		1byte 		2byte 		4byte 		8byte
				정수타입		 byte     short/char	int 		 long
				실수타입								float		double
				논리타입 	    boolean
				
			4. 다음 코드에서 타입. 변수 이름. 리터럴에 해당하는 것을 적어 보세요
					int age;
					age =10; 
					double price=3.14;
					
			타입: int , double
			변수 이름: age , price
			리터럴: 10, 3.14
			
			5. 자동 타입 변환에 대한 내용입니다. 컴파일 에러가 발생하는 것은 무엇입니까?  (4번)
						byte byteValue = 10;  
						char charValue ="A";  
						
				1. int intValue = bytevalue:  
				2. int intValue = charValue;    
				3. short shortValue =charValue;  
				4. double doubleValue = bytevalue;  
				
			6. 강제 타입 변환(Casting)에 대한 내용입니다. 컴파일 에러가 발생하는 것은 무엇입니까?  (4번)
						int intvalue =10;  
						char charValue ='A;  
						double doubleValue = 5.7;  
						String strValue = "A";
						  
				1. double var = (double) intValue; 
				2. byte  var  (byte) intValue;  
				3. int var = (int) doublevalue;  
				4. char var = (char) strValue;  
				
			7. 변수를 잘못 초기화한 것은 무엇입니까?  (3번)
				1. int var1 = 10;  
				2. long var2 =10000000000L;  
				3. char var3 ="; //작은 따음표 두 개가 붙어 있음  
				4. double var4 = 10; 
				5. float vars =10;  
		

			8. 연산식에서의 타입 변환 내용입니다. 컴파일 에러가 생기는 것은 무엇입니까? (1번)
						byte byteValue = 10;  
						float floatvalue = 2.5F;  
						double doubleValue = 2.5;  
						
				1. byte result = byteValue + byteValue;  
				2. int result = 5 +byteValue;  0
				3. float result =5 + floatValue:  0
				4. double result=5 + doubleValue:  0

		*/
	
	}
}
