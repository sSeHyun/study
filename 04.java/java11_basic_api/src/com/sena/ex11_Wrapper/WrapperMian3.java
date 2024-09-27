package com.sena.ex11_Wrapper;
public class WrapperMian3 {

	public static void main(String[] args) {
		// 포장객체의 값을 파싱하기
		
		// 1. boxing
		int val1 = Integer.valueOf("100");
		
		// 2. parsing
		int val2 = Integer.parseInt("100");
		Double val3 = Double.parseDouble("3.141592");
		Double val4 = Double.parseDouble("3.141592d");
		Float val5 = Float.parseFloat("3.141592d");

	}

}
