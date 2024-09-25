package com.sena.robot_v3_abstract;

public class StandardRobot3 extends Robot3{

	public StandardRobot3(String name, int qty) {
		super(name, qty);
	}

	@Override
	public void actionFly() {System.out.println("날 수 없습니다!");}

	@Override
	public void actionMissile() {System.out.println("미사일을 쏠 수 없습니다!");}

	@Override
	public void actionSword() {System.out.println("공격용 목검이 있습니다!");}
	
}
