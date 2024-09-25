package com.sena.robot_v7_constructor;

import com.sena.robot_v4_interface.impl.FlyNo;
import com.sena.robot_v4_interface.impl.FlyYes;
import com.sena.robot_v4_interface.impl.MissileICBM;
import com.sena.robot_v4_interface.impl.MissileNuclear;
import com.sena.robot_v4_interface.impl.MissileYes;
import com.sena.robot_v4_interface.impl.SwordLaser;
import com.sena.robot_v4_interface.impl.SwordWood;
import com.sena.robot_v4_interface.impl.UltraJjangSword;

public class RobotMain7 {

	public static void main(String[] args) {
		
		System.out.println("=== Robot V7.0 (constructor(초기화)) ===");
		System.out.println();		
		
		Robot7 robot=null;
		robot=new Robot7("CheapRobot", 2, new FlyYes(), new MissileYes(), new SwordWood());
		robot.makeRobot();
		
		robot = new Robot7("Standard", 6, new FlyYes(), new MissileICBM(), new SwordLaser());
		robot.makeRobot();
		
		robot = new Robot7("Super", 2, new FlyYes(), new MissileNuclear(), new UltraJjangSword());
		robot.makeRobot();
		
		robot = new Robot7("UltraJjang", 2, new FlyNo(), new MissileNuclear(), new UltraJjangSword());
		robot.makeRobot();
		
	}

}
