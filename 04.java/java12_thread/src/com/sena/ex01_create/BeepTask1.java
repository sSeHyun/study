package com.sena.ex01_create;

import java.awt.Toolkit;

public class BeepTask1 implements Runnable{

	@Override
	public void run() {
		//beep sound 5번 Toolkit(스피커를 조정해주는 클래스)
		Toolkit toolkit=Toolkit.getDefaultToolkit();	//pc의 스피커자원을 가져오는 메서드
		for(int i=0;i<5;i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	//1000ms=1sec
		}
		
	}

}
