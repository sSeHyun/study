package com.sena.ex02_array;

public class ArrayCopyMain2 {
	/*
	   배열의 복사
	   
	   참조타입인 배열인 경우, 배열복사가 되면 복사되는 값이 객체의 메모리주소이기 때문에
	   새 배열의 항목은 이전 배열이 참조하는 객체의 메모리주소와 동일하다.
	   
	   이 것을 얕은 복사(shallow copy)라고 한다. 반대로 깊은 복사(deep copy)는 참조하는 
	   객페를 별도로 생성해서 복사하는 것을 말한다.
	   
	   Array복사
	   
	   자바에서는 배열을 한번 생성하면 크기를 변경할 수 없기 때문에 더 많은 요소를 저장하려면
	   보다 큰 배열을 새로 만들고 이전 배열에서 항목값들을 복사해야 한다.
	   배열간 항목을 복사하려면 for문을 이용하거나 System.arrayCopy(), Arrays.copyOf()메서드를
	   사용해서 깊은 복사를 하게 한다.
	*/

	public static void main(String[] args) {
		//3. 배열의 복사 -깊은 복사
		
		//1) 얕은 복사
		String[][] names1= {{"거미", "나얼"}, {"소향", "손흥민", "이강인"}};
		String[][] names2= names1;
		System.out.println("names1.hashCode="+names1.hashCode());
		System.out.println("names2.hashCode="+names2.hashCode());
		System.out.println("--------------------------");
		
		//2) 깊은 복사 - for문
		String[] old1= {"거미", "나얼","소향"};
		String[] new1= new String[3];
		System.out.println("old1.hashCode="+old1.hashCode());
		System.out.println("new1.hashCode="+new1.hashCode());
		System.out.println("old1[0].hashCode="+old1[0].hashCode());
		System.out.println("--------------------------");
		
		for(int i=0;i<old1.length;i++) {
			new1[i]=old1[i];
		}
		
		old1[0]="손흥민";
		System.out.print("old1{");
		for(String old:old1) {
			System.out.print(old+"("+old.hashCode()+")"+",");
		}
		System.out.println("}");
		
		
		System.out.print("new1{");
		for(String n:new1) {
			System.out.print(n+"("+n.hashCode()+")"+",");
		}
		System.out.println("}");
		
		
		//3) 깊은 복사 - System.arraycopy(old,시작,new,new시작,old크기)
		//4) 깊은 복사 - Arrays.copyOf(src,new.lenght)
		//5) 깊은 복사 - Arrays.copyOf(src,start.end-1);
		
		
	}

}
