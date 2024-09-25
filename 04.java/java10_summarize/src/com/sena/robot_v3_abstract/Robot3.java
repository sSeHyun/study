package com.sena.robot_v3_abstract;

public abstract class Robot3 {
	public String name;
	public int qty;
	
	public Robot3(String name,int qty) {
		this.name=name;
		this.qty=qty;
	}
	public void shape() { System.out.println(this.name + "입니다!! 팔, 다리, 머리, 몸통이 있습니다.");}
	public void actionWalk() { System.out.println("걸을 수가 있습니다!!"); }
	public void actionRun() { System.out.println("달릴 수가 있습니다!!"); }
	
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionSword();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s] 현재재고= %d개",this.name,this.qty );
	}


}
