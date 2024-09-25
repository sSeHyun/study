package com.sena.robot_v2_inheritance;

public class SuperRobot2 extends Robot{
	public SuperRobot2(String name, int qty) {
		super(name,qty);
	}	
	public void actionFly() {System.out.println("날 수 있습니다!");}
	public void actionMissile() {System.out.println("미사일을 쏠 수 있습니다!");}
	public void actionSword() {System.out.println("공격용 광선검이 있습니다!");}
	
}
