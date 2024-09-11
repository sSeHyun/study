package com.sena.ex03_datatype;

public class FloatDoubleMain {

	public static void main(String[] args) {
		// 실수의 기본타입(double)
		double d1=3.141592;
		double d2=3.141592d;
		double d3=3.141592D;
		
		//float f1=3.141592;  -error
		float f1=3.141592f;  //명시적 선언 필수 -> 강제 형변환 (실수의 기본타입은 double)
		float f2=3.141592F;  
		float f3=(float)3.141592;	
		
		//실수(float)는 정밀도의 문제가 있다. 
		//이진법으로 연산되어 발생된다.
		float f4=0.1234567890123456789f;
		double d4=0.1234567890123456789;
		System.out.println("f4:"+f4);
		System.out.println("d4:"+d4);
		
		//실수 0.1을 표현할 때는 정확하게 표현이 불가하다.
		//즉, 정확한 값이 아니라 0.1에 근사한 값으로 리턴된다.
		System.out.println("1.0-0.9="+(1.0-0.9));	//정밀도 문제가 발생
		System.out.println("1.0f-0.9f= = "+(1.0f-0.9f));
		System.out.println("1.0d-0.9d= = "+(1.0d-0.9d));
		
		System.out.println("(1.0*10-0.9*10)/10 = "+(1.0*10-0.9*10)/10);
		System.out.println("(1.0*10-0.9*10)*0.1 = "+(1.0*10-0.9*10)*0.1);
		
		

	}

}
