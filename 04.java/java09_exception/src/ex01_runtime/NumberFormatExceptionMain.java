package ex01_runtime;

/*
	NumberFormatException?
	
	프로그램을 개발하다 보면 문자열로 되어 있는 숫자형 데이터를 숫자로 변화하는 경우가
	자주 발생한다. 문자열을 숫자로 변환할 때 해당 문자열이 숫자로 구성된 문자열이 아닐
	경우 즉, 숫자로 변환할 수 없는 문자열일 경우에 발생하느 예외이다.
	
	문자열을 숫자로 변환방법
	
	변환타입 메서드(매개변수)
	-------- ------------------------------ 
	int      Integer.parseInt(String str)
	double   Double.parseDouble(String str)
*/

public class NumberFormatExceptionMain {
	public static void main(String[] args) {
		String data1="100";
		String data2="3.141592";
		
		int val1=Integer.parseInt(data1);
		double val2=Double.parseDouble(data2);
		
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val1+val2);
		System.out.println(data1+data2);	//문자열로 연결됨
		
		System.out.println("-".repeat(20));
		
		String data3="100a";
		//int val3=Integer.parseInt(data3); //10진수 / error - java.lang.NumberFormatException.forInputString
		int val3=Integer.parseInt(data3,16);	//16진수로 변환
		System.out.println("16진수 변환:"+val3);
	}
}
