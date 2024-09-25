package com.sena.robot_v4_interface.impl;

import com.sena.robot_v4_interface.inter.InterMissile;

public class MissileNo implements InterMissile {
	@Override
	public void missile() {
		System.out.println("미사일을 쏠 수가 없습니다!");
	}
}
