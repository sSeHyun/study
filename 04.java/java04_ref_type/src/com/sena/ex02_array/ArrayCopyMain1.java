package com.sena.ex02_array;

public class ArrayCopyMain1 {

	public static void main(String[] args) {
		// 배열의 복사
		// 1. 참조타입인 배열 
		String[][] names1= {{"거미", "나얼"}, {"소향", "손흥민", "이강인"}};

		for(int i=0;i<names1.length;i++) {
			//행
			for(int j=0;j<names1[i].length;j++) {//열
				System.out.println(String.format("names1[%d][%d]=%s", i,j,names1[i][j]));
			}
		}
		System.out.println("--------------------------");
		
		//2. 배열의 복사 - 얕은 복사
		String[][] names2=names1;	//names1의 주소만 복사되었음
		for(int i=0;i<names2.length;i++) {
			//행
			for(int j=0;j<names2[i].length;j++) {//열
				System.out.println(String.format("names2[%d][%d]=%s", i,j,names2[i][j]));
			}
		}
		
		System.out.println("--------------------------");

		names1[0][0]="박정현";		//names1: 거미 -> 박정현
		names2[1][2]="김민재";		//names2: 이강인 -> 김민재
		
		for(int i=0;i<names1.length;i++) {
			//행
			for(int j=0;j<names1[i].length;j++) {//열
				System.out.println(String.format("names1[%d][%d]=%s", i,j,names1[i][j]));
			}
		}
		System.out.println("--------------------------");
		
		for(int i=0;i<names2.length;i++) {
			//행
			for(int j=0;j<names2[i].length;j++) {//열
				System.out.println(String.format("names2[%d][%d]=%s", i,j,names2[i][j]));
			}
		}
			
		
	}

}
