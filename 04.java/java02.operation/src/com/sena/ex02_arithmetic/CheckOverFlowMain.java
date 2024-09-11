package com.sena.ex02_arithmetic;

public class CheckOverFlowMain {

	public static void main(String[] args) {
		System.out.println("int의 최소값="+Integer.MIN_VALUE +", int의 최댓값:"+ Integer.MAX_VALUE);
		
		System.out.println("214783647+1= "+ (214783647+1)); //문법에러는 아니나 산술(로직) error
		
		try {
			int result=safeAdd(214783647,1);
			System.out.println("214783647+1="+result);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("int타입의 최소/최대값의 범위를 초과해서 연산을 할 수가 없습니다!");
		}
	}

	private static int safeAdd(int x, int y) {
		if(x>0) {
			if(x>(Integer.MAX_VALUE + y)) {
				//연산을 하지 않고 강제로 예외를 발생
				throw new ArithmeticException("int 타입의 최대값을 초과했습니다.");
			}
		}else {
			if(x>(Integer.MIN_VALUE - y)) {
				//연산을 하지 않고 강제로 예외를 발생
				throw new ArithmeticException("int 타입의 최소값을 초과했습니다.");
			}
		}
			
		return x+y;
	}

}
