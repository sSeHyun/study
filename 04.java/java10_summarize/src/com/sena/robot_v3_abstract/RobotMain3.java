package com.sena.robot_v3_abstract;

public class RobotMain3 {

	public static void main(String[] args) {
		
		System.out.println("=== Robot V3.0 (추상화) ===");
		System.out.println();	
		
		CheapRobot3 cheapRobot = new CheapRobot3("CheapRobot", 2);
		System.out.println(cheapRobot.toString());
		cheapRobot.shape();
		cheapRobot.actionWalk();
		cheapRobot.actionRun();
		cheapRobot.actionFly();
		cheapRobot.actionMissile();
		cheapRobot.actionSword();
		System.out.println("-".repeat(50));
		
		StandardRobot3 standardRobot = new StandardRobot3("StandardRobot", 6);
		System.out.println(standardRobot.toString());
		standardRobot.shape();
		standardRobot.actionWalk();
		standardRobot.actionRun();
		standardRobot.actionFly();
		standardRobot.actionMissile();
		standardRobot.actionSword();
		System.out.println("-".repeat(50));
		
		SuperRobot3 superRobot = new SuperRobot3("SuperRobot", 2);
		System.out.println(superRobot.toString());
		superRobot.shape();
		superRobot.actionWalk();
		superRobot.actionRun();
		superRobot.actionFly();
		superRobot.actionMissile();
		superRobot.actionSword();
		System.out.println("-".repeat(50));
	}

}
