package com.sena.robot_v2_inheritance;

public class Robot {
	public String name;
	public int qty;
	
	public Robot(String name,int qty) {
		this.name=name;
		this.qty=qty;
	}
	public void shape() {System.out.println(this.name+"입니다! 팔,다리,머리,몸통이 있습니다.");}
	public void actionWalk() {System.out.println("걸을 수 있습니다!");}
	public void actionRun() {System.out.println("달릴 수 있습니다!");}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s] 현재재고= %d개",this.name,this.qty );
	}

}
