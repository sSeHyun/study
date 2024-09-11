package com.sena.ex01_op;

public class SignOperatorMain {

	public static void main(String[] args) {
		//sign연산자(+,-)
		int var1=-100;
		System.out.println("var1: "+var1);
		
		int result= -var1;
		System.out.println("result: "+ result);
		
		result=-result;
		System.out.println("result: "+ result);
		
		//short는 2byte(MSB,Most Sign Bit)
		short s=100;
		//short result=-s;		//정수타입의 연산-> int 타입으로 연산하게 됨. 따라서 short를 -연산시 int타입으로 연산하게 됨
		int result1=-s;
		System.out.println("result1:"+result);

	}

}
