package com.sena.robot_v2_inheritance;

import com.sena.robot_v1_default.SuperRobot;

public class RobotMain2 {

	public static void main(String[] args) {
		System.out.println("===Robot V_2.0(기본)===");
		System.out.println("");
		
		CheapRobot1 cheapRobot1=new CheapRobot1("CheapRobot",2);
		System.out.println(cheapRobot1.toString());
		cheapRobot1.shape();
		cheapRobot1.actionWalk();
		cheapRobot1.actionRun();
		cheapRobot1.actionFly();
		cheapRobot1.actionMissile();
		cheapRobot1.actionSword();
		System.out.println("-".repeat(50));
		
		SuperRobot2 superRobot1=new SuperRobot2("SuperRobot1",6);
		System.out.println(superRobot1.toString());
		superRobot1.shape();
		superRobot1.actionWalk();
		superRobot1.actionRun();
		superRobot1.actionFly();
		superRobot1.actionMissile();
		superRobot1.actionSword();
		System.out.println("-".repeat(50));
		
		
	}
}
