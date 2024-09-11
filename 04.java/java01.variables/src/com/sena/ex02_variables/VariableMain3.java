package com.sena.ex02_variables;

public class VariableMain3 {

	public static void main(String[] args) {

		//literal은 직접 표현된 값을 의미한다.
		
		//1. 10진수
		int var1=10;		//10은 literal, var1는 변수
		System.out.println("10진수(var1): "+var1);
		
		//2. 8진수
		int var2=010;		// 맨 앞의 0은 8진수라는 의미 즉 var2의 값은 8
		System.out.println("8진수(var2): "+var2);
		
		//3. 16진수
		int var3=0x10;		// 맨 앞의 0x은 16진수라는 의미 즉 var3의 값은 16
		System.out.println("16진수(var3): "+var3);

		//4. 2진수
		int var4=0b10;		// 맨 앞의 0b은 2진수라는 의미 즉 var4의 값은 2
		System.out.println("2진수(var4): "+var4);
		
		
		//B. 서로 다른 데이터타입의 연산
		//char타입은 작은따옴표('')선언(한개의 문자)한다.
		// 큰 따옴표("")는 문자열 char타입(2byte)은 문자가 아니라 정수이다. 즉 정수값이 저장된다.
		char c1='A';	
		System.out.println("c1: "+c1);
		int i1=c1;
		System.out.println("i1: "+i1);		//아스키코드값 65가 나옴
		
		c1=65;
		System.out.println("c1: "+c1);
		
		//대문자
		for(int i=65;i<65+26;i++) {
			c1=(char)i;
			System.out.print(c1+",");
		}
		System.out.println();
		
		//소문자
		for(int i=97;i<97+26;i++) {
			c1=(char)i;
			System.out.print(c1+",");
		}
		System.out.println();
		
		//숫자
		for(int i=48;i<58;i++) {
			c1=(char)i;
			System.out.print(c1+",");
		}
		System.out.println();
		
		i1='가';
		System.out.println("i1=" + i1);
		
		c1='A';
		i1=10;
		
		//자바에서는 기본적으로 서로 다른 타입의 연산을 불가능하다
		//자바에서 정수타입의 연산은 기본적으로 int로 연산이된다.
		//자바에서 작은 타입과 큰 타입과 연산시에는 작은 타입이 큰타입으로 자동 변환 후 연산된다.
		
		
		//1. 자동 형 변환
		i1=i1+c1;	//c1-> int타입으로 변환(자동)후 정수 더하기 연산이 된다.
		System.out.println("i1=i1+(자동 형 변환)c1->"+i1);
		System.out.println("i1=i1+c1->(char)"+(char)i1);
		
		//2.명시적 형변환
		i1=i1+(int)c1;
		System.out.println("i1=i1+(int)c1->"+i1);		
		
		//3. 기본적으로 작은 크기의 타입과 큰 크키의 타입을 연산결과는
		// 큰 타입으로 변환후에 연산이 된다.
		// 따라서, 연산의 결과값을 저장할 변수의 데이터타입은 는 큰 타입으로 선언해야한다.
		
		double d1=10.0;
		int result=10+(int)3.141592; //강제 형변환
		System.out.println("result:"+result);
		
		int resutl2=(int)(10+3.141592); //10-> 10.0변환후에 + 3.141592 -> int로 형 변환
		System.out.println("result2:"+resutl2);
		
		double result3=10+3.141592;
		System.out.println("result3:"+ result3); //10-> 10.0변환후에 + 3.141592 
		
		float result4=10+3.141592f; //강제 형변환(f)
		System.out.println("result4:"+ result4); //10-> 10.0변환후에 + 3.141592 
		
		
	}

}
