package com.sena.robot_v8_final;

import com.sena.robot_v8_final.inter.*;
import com.sena.robot_v8_final.impl.*;

public class Robot8 {

	private InterFly fly;
	private InterMissile missile;
	private InterSword sword;
	public String name;
	public int qty;
	
	// 생성자 - 속성을 초기화
	public Robot8(String name, int qty, InterFly fly, InterMissile missile
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
		return String.format("[%sRobot] 현재재고 = %d 개", this.name, this.qty);
	}	
	
	void makeRobot() {
		System.out.println(this.toString());
		this.shape();
		actionWalk();
		actionRun();
		actionFly();
		actionMissile();
		actionSword();
		System.out.println("-".repeat(50));	
	}
}
