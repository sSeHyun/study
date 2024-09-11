package com.sena.ex02_variables;

public class VariableScopeMain {

	public static void main(String[] args) {
		//변수의 사용범위
		//local variable vs global variable(지역변수 vs 전역변수)
		
		int var1=10;
		System.out.println("var1: "+var1);
		System.out.println("--------------------------------------------------");
		
		if(true) {
			int var2;	//지역변수 즉, if문 안에서만 선언된 변수
			var1=20;	//전역변수 즉, main에서 선언되어 사용가능
			var2=20;
			System.out.println("var1(if문 안에서 불러옴) :"+var1);
			System.out.println("첫번째 if문의 var2:"+var2);
		}
		System.out.println("--------------------------------------------------");
		//System.out.println("var2:"+var2);	//-error : var2는 if문에서 선언된 지역변수로 사용불가능
		
		if(true) {
			int var3;
			var1=30;
			//var2=30;	-error : var2는 위의 if문에서 선언된 지역변수로 사용불가능 따라서 재 선언이 필요함
			int var2=30;		//var2는 위의 if문과 다른 var2로 이또한 해당 if문 안에서만 사용 가능
			var3=30;
			System.out.println("var1(if문 안에서 불러옴) :"+var1);
			System.out.println("두번째 if문의 var2:"+var2);
			System.out.println("var3:"+var2);
		}
		System.out.println("--------------------------------------------------");
		
		/*		
			System.out.println("var1:"+var1);
			System.out.println("var2:"+var2);
			System.out.println("var3:"+var2);
		*/

		
		
	}

}
