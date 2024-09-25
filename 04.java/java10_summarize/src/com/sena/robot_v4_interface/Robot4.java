package com.sena.robot_v4_interface;

public abstract class Robot4 {
	public String name;
	public int qty;
	
	public Robot4(String name, int qty) {
		this.name = name;
		this.qty = qty;
	}

	public void shape() { System.out.println(this.name + "입니다!! 팔, 다리, 머리, 몸통이 있습니다.");}
	public void actionWalk() { System.out.println("걸을 수가 있습니다!!"); }
	public void actionRun() { System.out.println("달릴 수가 있습니다!!"); }
	
	// 추상메서드
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionSword();
	
	// 재정의
	@Override
	public String toString() {
		return String.format("[%s] 현재재고 = %d 개", this.name, this.qty);
	}	
}
