package com.sena.robot_v5_extends;

import com.sena.robot_v4_interface.impl.FlyNo;
import com.sena.robot_v4_interface.impl.FlyYes;
import com.sena.robot_v4_interface.impl.MissileICBM;
import com.sena.robot_v4_interface.impl.MissileYes;
import com.sena.robot_v4_interface.impl.SwordLaser;
import com.sena.robot_v4_interface.impl.SwordWood;
import com.sena.robot_v4_interface.impl.UltraJjangSword;

public class RobotMain5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=== Robot V5.0 (interface, extends, casting) ===");
		System.out.println();	
		
		Robot5 robot = null;
		
		robot = new CheapRobot5("CheapRobot", 2);
		System.out.println(robot.toString());
		robot.shape();
		robot.actionWalk();
		robot.actionRun();
		robot.setFly(new FlyYes());
		robot.actionFly();
		robot.setMissile(new MissileYes());
		robot.actionMissile();
		robot.setSword(new SwordWood());
		robot.actionSword();
		System.out.println("-".repeat(50));	
		
		robot = new SuperRobot5("SuperRobot", 6);
		System.out.println(robot.toString());
		robot.shape();
		robot.actionWalk();
		robot.actionRun();
		robot.setFly(new FlyYes());
		robot.actionFly();
		robot.setMissile(new MissileYes());
		robot.actionMissile();
		robot.setSword(new SwordLaser());
		robot.actionSword();
		System.out.println("-".repeat(50));		
		
		robot = new SuperRobot5("SuperRobot", 6);
		System.out.println(robot.toString());
		robot.shape();
		robot.actionWalk();
		robot.actionRun();
		robot.setFly(new FlyYes());
		robot.actionFly();
		robot.setMissile(new MissileICBM());
		robot.actionMissile();
		robot.setSword(new UltraJjangSword());
		robot.actionSword();
		System.out.println("-".repeat(50));		
		
		robot = new UltraJjangRobot5("UltraJjangRobot", 10);
		System.out.println(robot.toString());
		robot.shape();
		robot.actionWalk();
		robot.actionRun();
		robot.setFly(new FlyNo());
		robot.actionFly();
		robot.setMissile(new MissileICBM());
		robot.actionMissile();
		robot.setSword(new UltraJjangSword());
		robot.actionSword();
		System.out.println("-".repeat(50));		
		
		
		
		
	}

}
