package com.sena.ex02_array;

public class MultiArrayMain {

	public static void main(String[] args) {
		// 자바에서는 다차원배열을 선언할 수 있다.
		// 다차원배열은 정방형과 비정방형의 배열을 선언할 수 있다.	


		//1. 2차원배열 - 2행 3열 배열 선언
		//  		0,0    0,1     0,2
		//			1,0	   1,1     1,2
		int[][] mathScores=new int[2][3];	//선언만 되어있고 초기화는 하지 않음
												
		//1) 배열의 크기 확인
		System.out.println("1차원배열의 크기="+ mathScores.length);
		System.out.println("2차원배열의 1st크기="+ mathScores[0].length);
		System.out.println("2차원배열의 2nd크기="+ mathScores[1].length);
		System.out.println("-------------------------------");
		
		//2) 정방형배열과 for문
		for(int i=0;i<mathScores.length;i++) {
			//행
			for(int j=0;j<mathScores.length;j++) {//열
				System.out.println(String.format("mathScores[%d][%d]", i,j));
			}
		}
		System.out.println("-------------------------------");
		
		//2. 비정방형 2차원배열 - 3행 ?열의 배열
		int [][] engScores=new int[3][];
		
		//1) 배열의 크기 확인
		System.out.println("1차원배열의 크기="+ engScores.length);
		//System.out.println("2차원배열의 1st크기="+ engScores[0].length);	--error 배열의 크기를 선언해주지 않았음 Cannot read the array length
		//System.out.println("2차원배열의 2nd크기="+ engScores[1].length);
		System.out.println("-------------------------------");
		
		//2) 2차원 각각의 배열의 크기를 정의하기
		engScores[0]=new int[2];  		//0,0  0,1
		engScores[1]=new int[5];		//1,0  1,1	 1,2	 1,3	 1,4
		engScores[2]=new int[1];		//2,0
		
		System.out.println("1차원배열의 크기="+ engScores.length);
		System.out.println("2차원배열의 1st크기="+ engScores[0].length);
		System.out.println("2차원배열의 2nd크기="+ engScores[1].length);
		System.out.println("2차원배열의 2nd크기="+ engScores[2].length);
		System.out.println("-------------------------------");
		
		//3) 비정방형배열과 for문
		for(int i=0;i<engScores.length;i++) {
			//행
			for(int j=0;j<engScores[i].length;j++) {//열
				System.out.println(String.format("engScores[%d][%d]", i,j));
			}
		}
		
		
		
	}

}
