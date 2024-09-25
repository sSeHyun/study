package com.sena.ex03_toString;

public class SmartPhoneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj1=new Object();
		System.out.println("obj1.toString()->"+obj1.toString());
		
		SmartPhone sp1=new SmartPhone("애플","아이폰16");
		SmartPhone sp2=new SmartPhone("삼성","갤럭시24");
		
		System.out.println("sp1.toString() -> " + sp1.toString() );
		System.out.println("sp2.toString() -> " + sp2.toString() );
		

	}

}
