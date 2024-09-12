package com.sena.ex02_array;

public class StringArgMain {

	public static void main(String[] args) {
		
		if(args.length<=0) {
			System.out.println(String.format("배열의 크기=%d",args.length));
			System.out.println("전달받은 매개변수가 없습니다.");
			System.out.println("프로그램을 강제종료합니다!");
			System.exit(0);	//관례적으로 0: 강제종료 
		}
		
		int sum=0;
		for(String arg: args) {
			int val=Integer.parseInt(arg);
			sum+=val;
		}
		System.out.println(String.format("args배열의 합계=%,d",sum));
		System.out.println(String.format("args배열의 평균=%,d",sum/args.length));
	}

}
