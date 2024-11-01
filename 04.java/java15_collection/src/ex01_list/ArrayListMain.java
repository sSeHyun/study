package ex01_list;

import java.util.ArrayList;
import java.util.List;

/*
	컬렉션프레임워크(Collection Framework)
	
	애플리케이션을 개발하다 보면 다수의 객체를 저장해서 필요할 때마다 꺼내서 사용하는 경우가 많다.
	이러한 객체를 효율적으로 추가, 삭제, 검색을 할 경우에 가장 간단한 방법은 배열을 이용하는 것 이다.
	배열은 쉽게 생성하고 사용할 수 있지만 저장객체의 크기가 배열생성시에 고정되기 때무에 불특정 다수
	의 객체를 저장하거나 관리하기에는 문제가 많다.
	
	자바는 배열의 이러한 문제점을 해결하기 위해 자료구조(Data Structure)를 바탕으로 객체를 효율적으로
	추가,삭제,검색할 수 있도록 java.util패키지에 컬렉션과 관련된 인터페이스와 구현클래스를 포함시켜
	놓았다. 이들을 총칭해서 컬렉션프레임워크라고 한다.
	
	컬렉션프레임워크에는 몇 가지 인터페이스를 통해서 다양한 컬렉션을 이용할 수 있도록 하고 있다. 주요
	인터페이스로는 List, Set, Map이 있다.
	
	1. 인터페이스의 분류
	
	   1) Collection계열
	      
	      a. List : 순서가 있다. 중복저장가능, index로 접근(ArrayList, Vector, LinkedList)
	      b. Set  : 순서가 없다. 중북저장불가, 반복자(Iterator)로 접근(HashSet, TreeSet)
	    
	   2) Map계열
	      
	      - Key와 Value을 한쌍(EntrySet)으로 저장, Key는 중복불가, Value는 저장가능
	      - 구현클래스 : HashMap, HashTable, TreeMap, Properties
	      
	2. List Collection
	   
	   List Collection은 객체를 일렬로 늘어 놓은 구조를 가지고 있고 객체를 인덱스로 관리하기 때문에
	   객체를 저장하면 자동으로 인덱스가 부여되고 이 인덱스로 객체를 검색, 삭제할 수 있는 기능을 제공
	   한다. 동일한 객체를 중복 저장할 수 있는데 이 경우에는 동일한 객체를 참조하는 번지가 저장된다.
	   null도 저장이 가능한데 이 경우에는 해당인덱스에는 참조하는 객체가 없기 때문에 검색할 경우에는
	   NullPointException예외가 발생한다.
	   
	   1) ArrayList
	   
	      ArrayList는 List인터페이스의 구현 클래스로 ArrayList에 객체를 추가하면 객체가 인덱스로 관리
	      된다. 일반 배열과 ArrayList는 인덱스로 객체를 관리한다는 점에서는 유사하지만 큰 차이점은 
	      일반배열은 생성시에 크기가 고정되고 사용중에는 크기를 변경할 수 없지만 ArrayList는 저장용량
	      이 초과할 경우에 객체가 추가되면 자동으로 저장용량(크기)이 증가 된다.
	      
	      ArrayList는 객체의 크기를 저장하지 않고 생성하면 기본크기는 10개의 크기를 가진다. 처음부터
	      객체의 크기를 저장할 경우에는 ArrayList<참조타입>(20)의 형태로 크기를 지정하면 된다.
	      
	   2) Vector
	   
	      Vector는 ArrayList와 동일한 내부구조를 가지고 이싸. Vector를 생서하기 위해서는 저장할 객체
	      타입을 타입파라미터로 표기하고 기본생성자를 호출하면 된다.
	      
	      ArrayList와 다른 점은 Vector는 동기화(Synchronized)메서드로 구성되어 있기 때문에 멀티쓰레드
	      환경에서 안전하다. 즉, 다른 쓰레드가 동시에 Vetor에 접근할 수 없고 하나의 쓰레드 작업이 완료
	      가 되어야 다른 쓰레드가 실행할 수 있게 된다. 그래서 멀티쓰레드환경에서 안전하게 객체를 추가
	      삭제를 할 수가 있다.
	   
	   3) LinkedList
	   	
	   	  LinkedList는 List인터페이스의 구현클래스이므로 ArrayList와 사용방법은 동일하지만 내부구조는
	   	  상이하다. ArrayList는 내부 배열에 객체를 저장해서 인덱스로 관리하지만 LinkedList는 인접자료
	   	  의 주소를 링크해서 체인연결처럼 관리한다.
	   	  
	   	  LinkedList에서 특정 인덱스에 위치한 객체를 제거하면 전후의 링크만 변경되고 나머지 링크는 변
	   	  경되지 않는다. 특정 인덱스에 객체를 삽입할 경우에도 동일하게 적용된다.
	   	  
	   	  LinkedList를 생성하기 위해서는 저장할 객체타입을 타입파라미터<E>로 표기하고 기본생성자를 호출
	   	  하면된다. LinkedList는 처음 생성될 때 어떠한 링크도 만들어지지 않기 때문에 내부는 비어 있게 
	   	  된다.
*/
public class ArrayListMain {

	public static void main(String[] args) {
		// 1. ArrayList
		
		// 1) non-generic
		List list1 = new ArrayList();
		
		// a. add
		list1.add("문자열");
		list1.add(1);  // 1 -> Integer.valueof(1) 즉, 기본타입이 아니라 객체타입으로 저장
		list1.add(new Apple());
		list1.add(new Hammer());
		list1.add(new Car());
		
		// b. get
		String val1 = (String) list1.get(0);
		Integer val2 = (Integer) list1.get(1);
		Apple val3 = (Apple) list1.get(2);
		Hammer val4 = (Hammer) list1.get(3);
		Car val5 = (Car) list1.get(4);
		System.out.println("list1의 갯수 = " + list1.size());
		
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);
		System.out.println(val4);
		System.out.println(val5);
		System.out.println();
		
		// c. remove
		// index로 삭제
		list1.remove(0);  
		System.out.println("list1의 갯수 = " + list1.size());
		
		// 객체로 삭제
		list1.remove(val4); 
		System.out.println("list1의 갯수 = " + list1.size());
		
		// 전체삭제(1)
		list1.removeAll(list1);
		System.out.println("list1의 갯수 = " + list1.size());
		
		list1.add(new Apple());
		list1.add(new Hammer());
		list1.add(new Car());
		System.out.println("list1의 갯수 = " + list1.size());
		
		// 전체삭제(2)
		list1.clear();
		System.out.println("list1의 갯수 = " + list1.size());
		System.out.println();
		
		// d. 중복가능
		list1.add("손흥민");
		list1.add("손흥민");
		list1.add("손흥민");
		System.out.println("list1의 갯수 = " + list1.size());
		System.out.println("-".repeat(50));
		
		// non-generic타입이기 때문에 문법에러 발생
//		for(String list:list1) {
//			System.out.println(list);
//		}
		
		// 2) generic
		List<String> list2 = new ArrayList<>();
//		list2.add(1);
//		list2.add(new Apple());
//		list2.add(new Hammer());
//		list2.add(new Car());
		list2.add("Java");
		list2.add("JDBC");
		list2.add("JSP");
		list2.add("Java");
		list2.add("Spring");
		list2.add("Servlet");
		list2.add("Python");
		list2.add("R");
		System.out.println("list2의 갯수="+list2.size());
		
		// generic타입이기 때문에 문법에러 발생하지 않음
		for(String list:list2) {
			System.out.println(list);
		}		
		//강제형변환 필요없음
		
		String v1=list2.get(0);
		String v2=list2.get(4);
		System.out.println(v1+","+v2);
		
		//중복된 JAVA삭제
		list2.remove(0);
		list2.remove("Java");
		System.out.println("list2의 갯수="+list2.size());
		for(String list:list2) {
			System.out.println(list);
		}		
		
		
		
		
	}

}

class Apple {}
class Hammer {}
class Car {
	@Override
	public String toString() {
		return "나는 사과입니다!";
	}
}



















