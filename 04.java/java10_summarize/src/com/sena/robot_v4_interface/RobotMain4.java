package com.sena.robot_v4_interface;

import com.sena.robot_v4_interface.impl.*;

public class RobotMain4 {

	public static void main(String[] args) {

		System.out.println("=== Robot V4.0 (interface) ===");
		System.out.println("");
		
		CheapRobot4 cheapRobot = new CheapRobot4("CheapRobot", 2);
		System.out.println(cheapRobot.toString());
		
		cheapRobot.shape();
		cheapRobot.actionWalk();
		cheapRobot.actionRun();
		cheapRobot.setFly(new FlyNo());
		cheapRobot.actionFly();
		cheapRobot.setMissile(new MissileNo());
		cheapRobot.actionMissile();
		cheapRobot.setSword(new SwordNo());
		cheapRobot.actionSword();
		System.out.println("-".repeat(50)); 
		
		StandardRobot4 standardRobot = new StandardRobot4("standardRobot", 6);
		System.out.println(standardRobot.toString());
		standardRobot.shape();
		standardRobot.actionWalk();
		standardRobot.actionRun();
		standardRobot.setFly(new FlyNo());
		standardRobot.actionFly();
		standardRobot.setMissile(new MissileYes());
		standardRobot.actionMissile();
		standardRobot.setSword(new SwordWood());
		standardRobot.actionSword();
		System.out.println("-".repeat(50));
		
		SuperRobot4 superRobot = new SuperRobot4("superRobot", 2);
		System.out.println(superRobot.toString());
		superRobot.shape();
		superRobot.actionWalk();
		superRobot.actionRun();
		superRobot.setFly(new FlyYes());
		superRobot.actionFly();
		superRobot.setMissile(new MissileYes());
		superRobot.actionMissile();
		superRobot.setSword(new SwordLaser());
		superRobot.actionSword();
		System.out.println("-".repeat(50));
	}

}
