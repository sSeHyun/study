package com.sena.ex01_object.ex01_equals;

/* 
	객체비교(객체.equals(Object object))
	
	 equals메서드는 매개타입인 Object인데 이 것은 모든 객체가 매개값을 대입될 수
	 있다는 것이다. 그 이유는 Object가 최상위 클래스이므로 모든 객체는 Objec타입
	 으로 자동형변환 될 수 있기 때문이다.
	 
	 Java에서는 두 객체를 비교할 때 동등연산자(==)가 아니라 equals()메서드를 사용
	 한다. 두 객체를 비교해서 논리적으로 동등하면 true, 아니면 false를 리턴한다.
	 
	 equals메서드를 재정의할 때 매개값(비교객체)이 기준 객체와 동일한 타입의 객체
	 인지를 먼저 확인해야 한다. Object타입의 매개변수는 모든 객체가 매개값으로 사
	 용될 수 있기 때문이다.
*/

public class MemberMain {
	public static void main(String[] args) {
		Member member1 = new Member("hong");
		Member member2 = new Member("hong");
		Member member3 = new Member("kim");
		
		System.out.println("member1 = " + member1.hashCode() + ", toString() = " + member1.toString());
		System.out.println("member2 = " + member2.hashCode() + ", toString() = " + member2.toString());
		System.out.println("member3 = " + member3.hashCode() + ", toString() = " + member3.toString());
		System.out.println();
		
		// 1. id가 동일하다면 동일객체라고 간주
		System.out.println("member1 == member2 : " + (member1 == member2)); // true를 기대하지만 false
		System.out.println("member1 == member3 : " + (member1 == member3)); // true를 기대하지만 false
		
		// 2. 객체의 비교(equals())
		System.out.println("member1.equals(member2) : " + (member1.equals(member2))); // true를 기대하지만 false
		System.out.println("member1.equals(member3) : " + (member1.equals(member3))); // true를 기대하지만 false
		System.out.println();
		
		if(member1.equals(member3)) {
			System.out.println("동일객체입니다!!");
		} else {
			System.out.println("다른객체입니다!!");			
		}
	}
}
