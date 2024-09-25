package com.sena.robot_v3_abstract;

public class CheapRobot3 extends Robot3{

	public CheapRobot3(String name, int qty) {
		super(name, qty);
	}

	@Override
	public void actionFly() {System.out.println("날 수 없습니다!");	}

	@Override
	public void actionMissile() {System.out.println("미사일을 쏠 수 없습니다!");}

	@Override
	public void actionSword() { System.out.println("공격용 검이 없습니다!");}
	
}
