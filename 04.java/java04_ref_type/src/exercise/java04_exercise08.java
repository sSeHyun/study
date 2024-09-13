package exercise;

public class java04_exercise08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 주어진 배열의 전체 항목의 합과 평균값을 구하기.(중첩 for문을 이용) 
		int[][] array ={
	               {95, 86},
	               {83, 92, 96},
	               {78, 83, 93, 87, 88}
	              }; 
		
		int sum=0;
		int avg=0;
		int count=0;
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				sum=sum+array[i][j];
			}
			count+=array[i].length;
		}
		System.out.println("배열의 수:"+count);
		System.out.println("전체 항목의 합: "+sum);
		System.out.println("평균값: "+sum/count);
	
	}

}
