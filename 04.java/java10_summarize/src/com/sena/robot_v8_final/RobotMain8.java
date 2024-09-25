package com.sena.robot_v8_final;

import com.sena.robot_v8_final.impl.*;


public class RobotMain8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=== Robot V8.0 (최종) ===");
		System.out.println();
		
		Robot8 robot = null;
		
		robot = new Robot8("Cheap", 2, new FlyYes(), new MissileYes(), new SwordWood());
		robot.makeRobot();
		
		robot = new Robot8("Standard", 6, new FlyYes(), new MissileICBM(), new SwordLaser());
		robot.makeRobot();
		
		robot = new Robot8("Super", 2, new FlyYes(), new MissileNuclear(), new UltraJjangSword());
		robot.makeRobot();
		
		robot = new Robot8("UltraJjang", 2, new FlyNo(), new MissileNuclear(), new UltraJjangSword());
		robot.makeRobot();
	}

}
