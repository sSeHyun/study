package com.sena.robot_v7_constructor;

import com.sena.robot_v4_interface.inter.InterFly;
import com.sena.robot_v4_interface.inter.InterMissile;
import com.sena.robot_v4_interface.inter.InterSword;

public class Robot7  {
	private InterFly fly;
	private InterMissile missile;
	private InterSword sword;
	
	public String name;
	public int qty;
	
	// 생성자 - 속성을 초기화
	public Robot7(String name, int qty, InterFly fly, InterMissile missile
			, InterSword sword) {
		this.name = name;
		this.qty = qty;
		this.fly = fly;
		this.missile = missile;
		this.sword = sword;
	}
	
	// 공통기능
	public void shape() { System.out.println(this.name + "입니다!! 팔, 다리, 머리, 몸통이 있습니다.");}
	public void actionWalk() { System.out.println("걸을 수가 있습니다!!"); }
	public void actionRun() { System.out.println("달릴 수가 있습니다!!"); }
	
	// 개별기능
	public void actionFly() { fly.fly();}
    public void actionMissile() { missile.missile(); }
	public void actionSword() { sword.sword();}
	
	@Override
	public String toString() {
		return String.format("[%s] 현재재고 = %d 개", this.name, this.qty);
	}	
	void makeRobot() {
		System.out.println(this.toString());
		this.shape();
		actionWalk();
		actionRun();
		actionFly();
		actionMissile();
		actionSword();
		
	}
	
}
