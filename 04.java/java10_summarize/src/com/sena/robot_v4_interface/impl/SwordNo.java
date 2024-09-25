package com.sena.robot_v4_interface.impl;

import com.sena.robot_v4_interface.inter.InterSword;

public class SwordNo implements InterSword {

	@Override
	public void sword() {
		System.out.println("공격용 검이 없습니다!!");
	}

}
