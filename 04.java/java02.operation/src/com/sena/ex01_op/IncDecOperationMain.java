package com.sena.ex01_op;

public class IncDecOperationMain {
	/*
	   증감연산자(++, --)
	   
	   증감연산자는 변수의 값을 1씩증가(++), 1씩감소(--)를 시키는 연산자를 말한다.
	   boolean타입을 제외한 모든 기본데이터타입의 피연산자에 사용할 수 있다.
	   증감연산자는 선언위치에 따라 후위, 전위 증감연산자로 구분이 도니다. 변수 앞에
	   정의된 것을 전위증감연산자, 변수 뒤에 정의된 것을 후위증감연산자라고 한다.
	   
	   주의할 점은 다른 연산자와 함께 사용되는 연산식에서는 증감연산자의 위치에 따라
	   연산결과가 다르게 나오므로 주의해야 한다.
	   
	   전위연산자는 연산전에 증감을 시키고 후위연산자는 연산을 한 후에 증감을 시킨다.
	*/
	
	public static void main(String[] args) {
		int x=10;
		int y=10;
		int z;
		
		x++;	//x=x+1;		실행 후 증가(후위연산자)
		System.out.println("x="+x);
		++x;	//x=x+1;		실행 전 증가(전위연산자)
		System.out.println("x="+x);
		
		y--;
		--y;
		System.out.println("y="+y);
		
		z=x++; 	//먼저 x(12)를 먼저 z에 대입후 x증가(x=13, z=12)
		System.out.println("z="+z);
		System.out.println("--------------------------------");
		
		z=++x;	//먼저 x(14)를 먼저 증가후에  z에 대입
		System.out.println("z="+z);
		

	}

}
