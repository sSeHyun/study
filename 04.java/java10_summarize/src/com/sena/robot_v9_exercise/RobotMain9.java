package com.sena.robot_v9_exercise;

import com.sena.robot_v8_final.Robot8;

public class RobotMain9 {

	public static void main(String[] args) {
		// 실습. V9_실습 : System.out.println("=== Robot V9.0 (실습. 메서드로 초기화) ===");
		// v8에서 
		// 1. Interface속성을 삭제 InterFly InterMissile, InterSword;
		// 2. Robot(String name, int qty)
		// 3. actionFly(InterFly fly) { fly.fly();}
	    //    actionMissile(InterMissile missile) { missile.missile(); }
		//    actionSword(InterSword sword) { sword.sword(); }
		
		
		 System.out.println("=== Robot V9.0 (실습. 메서드로 초기화) ===");
		 
		 Robot9 robot = null;
		 robot = new Robot9("Cheap", 2);
		 robot.makeRobot();
		 
		 

	}

}
