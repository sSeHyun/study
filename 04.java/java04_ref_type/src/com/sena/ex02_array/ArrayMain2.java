package com.sena.ex02_array;

public class ArrayMain2 {

	public static void main(String[] args) {
		// 2.배열의 선언과 초기화 - new연산자
		
		//int[] scores= {90,95,88,90,89,100,99,78,66,65,88,99};
		int scores[]; //선언만 되어있고, 크기와 값은 초기화 해주지않음
		//System.out.println(scores[0]);	-error: The local variable scores may not have been initialized
		
		scores=new int[] {90,95,88,90,89,100,99,78,66,65,88,99};
		
		int sum=0;
		for(int score:scores) {
			sum+=score;
		}
		System.out.println(String.format("scores배열의 합계=%,d",sum));
		System.out.println(String.format("scores배열의 평균=%,d",sum/scores.length));
		
		System.out.println("-------------------------------------------");
		
		//3. 메서드를 이용한 배열처리
		int total= total(scores);
		System.out.println(String.format("메서드를 이용한 scores배열의 합계=%,d",total));
		System.out.println(String.format("메서드를 이용한 scores배열의 평균=%,d",total/scores.length));
		System.out.println("-------------------------------------------");
	}

	private static int total(int[] scores) {
		int sum=0;
		for(int score:scores) {
			sum+=score;
		}
		return sum;
	}

}
