package com.sena.robot_v9_exercise;

public class Robot9 {
	// 실습. V9_실습 : System.out.println("=== Robot V9.0 (실습. 메서드로 초기화) ===");
	// v8에서 
	// 1. Interface속성을 삭제 InterFly InterMissile, InterSword;
	// 2. Robot(String name, int qty)
	// 3. actionFly(InterFly fly) { fly.fly();}
    //    actionMissile(InterMissile missile) { missile.missile(); }
	//    actionSword(InterSword sword) { sword.sword(); }
	
	public String name;
	public int qty;
	
	public Robot9(String name, int qty) {
		this.name=name;
		this.qty=qty;
	}
	
	
	public void shape() { System.out.println(this.name + "입니다!! 팔, 다리, 머리, 몸통이 있습니다.");}
	public void actionWalk() { System.out.println("걸을 수가 있습니다!!"); }
	public void actionRun() { System.out.println("달릴 수가 있습니다!!"); }
	
	//public void actionFly(InterFly fly) { fly.fly();}
    //public void actionMissile(InterMissile missile) { missile.missile(); }
	//public void actionSword(InterSword sword) { sword.sword();}
	
	void makeRobot() {
		System.out.println(this.toString());
		this.shape();
		actionWalk();
		actionRun();
//		actionFly();
//		actionMissile();
//		actionSword();
		System.out.println("-".repeat(50));	
	}
	
}
