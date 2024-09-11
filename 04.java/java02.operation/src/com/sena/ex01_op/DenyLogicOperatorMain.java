package com.sena.ex01_op;

public class DenyLogicOperatorMain {

	public static void main(String[] args) {
		// 논리부정연산자(!) 는 true or false를 부정하는 연산자로 boolean타입(연산결과)에만 사용할 수 있다.
		/* 	피연산자가 true이면 false, false이면 true를 리턴한다.
		 * 	논리부정연산자는 조건문과 반복문등에서 사용되어 연산의 결과를 부정하여 실행 흐름을 제어할때 주로 사용
		 	1==1 true;
		 	1==2 false;
		*/
		
		boolean isPlay=true;
		System.out.println("isPlay="+isPlay);
		
		isPlay=!isPlay;
		System.out.println("isPlay="+isPlay);

		isPlay=!isPlay;
		System.out.println("isPlay="+isPlay);
		
	}

}
