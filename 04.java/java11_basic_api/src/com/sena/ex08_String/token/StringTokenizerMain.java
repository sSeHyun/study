package com.sena.ex08_String.token;

import java.util.StringTokenizer;

public class StringTokenizerMain {

	public static void main(String[] args) {
		
		String names = "홍길동/홍길순/홍길상/홍길준/홍길녀/홍길자"; // 구분자가 없을 경우 공란을 기준
		StringTokenizer st = new StringTokenizer(names, "/");
		System.out.println("현재 남아있는 토큰 수 = " + st.countTokens());
		System.out.println("토큰이 남아있는지 여부 = " + st.hasMoreTokens());
		System.out.println();
		
		String str = st.nextToken();
		System.out.println("꺼내온 token = " + str);
		System.out.println("현재 남아있는 토큰 수 = " + st.countTokens());
		System.out.println("토큰이 남아있는지 여부 = " + st.hasMoreTokens());
		System.out.println();
		
		str = st.nextToken();
		System.out.println("꺼내온 token = " + str);
		System.out.println("현재 남아있는 토큰 수 = " + st.countTokens());
		System.out.println("토큰이 남아있는지 여부 = " + st.hasMoreTokens());
		System.out.println();
		
		//1. for
		st=new StringTokenizer(names,"/");
		int count=st.countTokens();
		System.out.println("현재 남아있는 토큰 수 = " + st.countTokens());
		
		for(int i=0;i<count;i++) {
			String token=st.nextToken();
			System.out.print(token+",");
		}
		System.out.println("현재 남아있는 토큰 수 = " + st.countTokens());
		System.out.println("토큰이 남아있는지 여부 = " + st.hasMoreTokens());
		
		System.out.println();
		
		//2. while
		st=new StringTokenizer(names,"/");
		while(st.hasMoreElements()) {
			System.out.print(st.nextToken()+",");
		}
		System.out.println("\n현재 남아있는 토큰 수 = " + st.countTokens());
		System.out.println("토큰이 남아있는지 여부 = " + st.hasMoreTokens());

	}

}
