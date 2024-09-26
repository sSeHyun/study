package com.sena.ex08_String.token;

public class StringSplitMain {

	public static void main(String[] args) {
		String str="1,2,3,4,5,6,7,8,9,10";
		String[] nums=str.split(",");
		System.out.println("nums.length:"+nums.length);
		for(String num:nums) {
			System.out.println(num+"");
		}
		System.out.println();
		
		String text = "홍길동/홍길순/홍길상/홍길준/홍길녀/홍길자";
		String[] names = text.split("/|,|@|&|-");
		System.out.println("names.length="+names.length);
		for(String name:names) {
			System.out.print(name+"");
		}
	}

}
