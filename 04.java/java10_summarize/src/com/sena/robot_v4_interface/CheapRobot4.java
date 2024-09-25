package com.sena.robot_v4_interface;
import com.sena.robot_v4_interface.inter.InterFly;
import com.sena.robot_v4_interface.inter.InterMissile;
import com.sena.robot_v4_interface.inter.InterSword;

public class CheapRobot4 extends Robot4{
	
	private InterFly fly;
	private InterMissile missile;
	private InterSword sword;
	
	public void setFly(InterFly fly) {
		this.fly=fly;
	}
	
	public void setMissile(InterMissile missile) {
		this.missile = missile;
	}
	public void setSword(InterSword sword) {
		this.sword = sword;
	}



	public CheapRobot4(String name,int qty) {
		super(name,qty);
	}

	@Override
	public void actionFly() {fly.fly();}
	@Override
	public void actionMissile() {missile.missile();}
	@Override
	public void actionSword() {sword.sword();}
	

}
