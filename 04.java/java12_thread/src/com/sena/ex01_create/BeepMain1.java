package com.sena.ex01_create;

import java.awt.Toolkit;

public class BeepMain1 {

	public static void main(String[] args) throws InterruptedException {
		/*싱글스레드*/
		
		//beep sound 5번 Toolkit(스피커를 조정해주는 클래스)
		Toolkit toolkit=Toolkit.getDefaultToolkit();	//pc의 스피커자원을 가져오는 메서드
		for(int i=0;i<5;i++) {
			toolkit.beep();
			Thread.sleep(1000);	//1000ms=1sec
		}
		
		//beep print 5번
		for(int i=0;i<5;i++) {
			System.out.println("띵~");
			Thread.sleep(1000);
		}

	}

}
