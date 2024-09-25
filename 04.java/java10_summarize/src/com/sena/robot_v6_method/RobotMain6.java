package com.sena.robot_v6_method;

import com.sena.robot_v4_interface.impl.*;
import com.sena.robot_v4_interface.inter.*;
import com.sena.robot_v5_extends.Robot5;

public class RobotMain6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=== Robot V6.0 method ===");
		System.out.println();
		
		makeRobot(new Robot5("CheapRobot", 2), new FlyYes(), new MissileYes(), new SwordWood());
		makeRobot(new Robot5("StandardRobot", 6), new FlyYes(), new MissileYes(), new SwordLaser());
		makeRobot(new Robot5("SuperRobot", 2), new FlyYes(), new MissileNuclear(), new SwordLaser());
		makeRobot(new Robot5("UltraJjangRobot", 10), new FlyYes(), new MissileNuclear(), new UltraJjangSword());
		
	}
	private static void makeRobot(Robot5 robot, InterFly fly, InterMissile missile,InterSword sword) {
		System.out.println(robot.getClass());
		System.out.println(robot.toString());
		robot.shape();
		robot.actionWalk();
		robot.actionRun();
		robot.setFly(fly);
		robot.actionFly();
		robot.setMissile(missile);
		robot.actionMissile();
		robot.setSword(sword);
		robot.actionSword();
		System.out.println("-".repeat(50));		
	}

}
