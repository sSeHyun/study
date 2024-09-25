package com.sena.robot_v2_inheritance;

public class CheapRobot1 extends Robot{
	public CheapRobot1(String name, int qty) {
		super(name,qty);
	}
	
	public void actionFly() {System.out.println("날 수 없습니다!");}
	public void actionMissile() {System.out.println("미사일을 쏠 수 없습니다!");}
	public void actionSword() {System.out.println("공격용 검이 없습니다!");}

}
