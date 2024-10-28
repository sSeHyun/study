package com.lec.member.vo;

import java.util.Objects;

public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private int age;
	private String gender;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + "]";
	}
	
	public boolean equals(Object obj) {
		if(this==obj)return true;
		if(obj==null) return false;
		if(getClass()!=obj.getClass())return false;
		MemberVO other = (MemberVO) obj;
		return id==other.id && 
				pw==other.pw && 
				name==other.name && 
				age == other.age && 
				gender == other.gender && 
				email==other.email;
	}
	
	
	
	

}
