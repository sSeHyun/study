package com.sena.ex03_for;

public class forNesteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//실습. 구구단 출력해보기
		for(int i=2; i<=9;i++) {
			System.out.println("-----"+i+"단------");
			for(int j=1;j<=9;j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
		}

	}

}
