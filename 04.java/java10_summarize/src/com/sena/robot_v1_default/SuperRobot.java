package com.sena.robot_v1_default;

public class SuperRobot {
	public int qty;
	public SuperRobot(int qty) {
		this.qty=qty;
	}
	public void shape() {System.out.println("SuperRobot입니다! 팔,다리,머리,몸통이 있습니다.");}
	public void actionWalk() {System.out.println("걸을 수 있습니다!");}
	public void actionRun() {System.out.println("달릴 수 있습니다!");}
	public void actionFly() {System.out.println("날 수 있습니다!");}
	public void actionMissile() {System.out.println("미사일을 쏠 수 있습니다!");}
	public void actionSword() {System.out.println("공격용 광선검이 있습니다!");}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "현재재고="+this.qty+"개";
	}

}