package com.sena.ex01_object.ex01_equals;

public class Member {
public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return this.id.equals(member.id);			
		}else 
			return false;
	}
}
