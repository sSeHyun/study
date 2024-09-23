package com.sena.ex10_abstract;

public class SmartPhone extends Phone {
	public SmartPhone(String owner) {
		super(owner);
	}
	public void search(String url) {
		System.out.println( url+"에서 검색을 합니다.");
	}
}
