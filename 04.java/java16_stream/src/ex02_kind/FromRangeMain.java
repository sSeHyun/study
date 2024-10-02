package ex02_kind;

import java.util.stream.IntStream;

public class FromRangeMain {
	//stream에서 사용되는 변수는 static으로 선언해야한다.
	//즉, 클래스 멤버로 선언해야한다.
	static int sum=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream stream=IntStream.range(1, 11);		//1~10까지 ,1<=range<11
		stream.forEach(n->sum+=n);
		System.out.println("1~10까지의 합: "+sum);
		
		sum = 0;
		stream = IntStream.rangeClosed(1, 10);
		stream.forEach(n -> sum += n);
		System.out.println("1~10까지 합 = " + sum);
		
	}

}
