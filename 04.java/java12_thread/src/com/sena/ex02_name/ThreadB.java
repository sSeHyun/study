package com.sena.ex02_name;

public class ThreadB extends Thread{
	
	//쓰레드 이름 자동 부여
	@Override
	public void run() {
		for(int i=0;i<2;i++) {
			System.out.println(super.getName()+"가 출력한 내용!");
			}
	}
}
