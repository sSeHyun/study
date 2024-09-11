package self_study;

public class variable_ex01 {

	public static void main(String[] args) {

		System.out.println("1. 값 저장");
		int value; 
		//int result=value+10;	--변수 value를 초기화해주지 않아 error발생
		value=30;
		int result=value+10;
		System.out.println(result);
		System.out.println("-----------------------------------");		
		
		System.out.println("2. 변수 사용");
		int hour=3;
		int minute=5;
		System.out.println(hour+"시간"+minute+"분");
		
		int totalMinute=(hour*60)+minute;
		System.out.println("총"+totalMinute+"분");
		System.out.println("-----------------------------------");
		 
		System.out.println("3. 변수값 교환");
		
		int x=3;
		int y=5;
		System.out.println("x:"+x+", y:"+y);
		
		int temp=x;
		x=y;
		y=temp;
		System.out.println("x:"+x+", y:"+y);
		System.out.println("-----------------------------------");
		
		System.out.println("4. 변수의 사용 범위");
		int v1=15;
		if(v1>10) {
			int v2;
			v2=v1-10;
		}
		//int v3=v1+v2+5; 지역변수 v2로 인해 error 발생
		System.out.println("-----------------------------------");
	}

}
