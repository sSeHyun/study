package exercise;

import java.util.Scanner;

public class java04_exercise09 {

	public static void main(String[] args) {
		/*
		 	Exercise09.java :    
		   키보드로부터 학생 수와 각 학생들의 점수를 입력받아서 최고 점수 및 평균 점수를 구하기
		   (참고: Scanner의 nextlnt() 메소드이용)

		   System.out.println("---------------------------------------------");
		   System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		   System.out.println("---------------------------------------------");
		   System.out.print("선택> ");   
		   
		   JOptionPan.showInputDialog() 이용해도 상관없음        
		  */
		boolean run=true;
		int studentNum=0;
		int[] scores=null;
		Scanner scanner=new Scanner(System.in);
		
		while(run) {
			System.out.println("-".repeat(50));
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-".repeat(50));
			System.out.print("선택> ");   
			
			int selectNo=Integer.parseInt(scanner.nextLine());
			
			if(selectNo==1) {
				System.out.print("학생수> ");  
				studentNum=scanner.nextInt();
				scores=new int[studentNum];
			}
			else if(selectNo==2) {
				for(int i=0;i<studentNum;i++) {
					scores[i]=scanner.nextInt();
					System.out.println("scores["+i+"]"+scores[i]);
				}
			}
			else if(selectNo==3) {
				for(int i=0;i<studentNum;i++) {
					System.out.println(scores[i]+",");
				}
			}
			else if(selectNo==4) {
				int sum=0;
				int count=0;
				for(int i=0;i<studentNum;i++) {
					sum=sum+scores[i];
					count=scores.length;
				}
				System.out.println(sum);
				System.out.println(sum/count);
			}
			else if(selectNo==5) {
				run=false;
			}
			System.out.println("프로그램 종료");
		}
		
		
	}

}
