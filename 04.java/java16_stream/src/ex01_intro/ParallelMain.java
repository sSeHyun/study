package ex01_intro;

import java.util.*;
import java.util.stream.Stream;

public class ParallelMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list=Arrays.asList("손흥민","이강인","소향","홍길동","홍길순");
		Stream<String> stream=null;	//반복자이기 때문에 다 읽은 후 다시 읽을 경우 다시 만들어줘야함. js의 foreach 느낌이랄까나~
	
		
		//1. 직렬(순차)처리 : stream()
		stream=list.stream();
		stream.forEach(n->System.out.print(n+","));
		System.out.println();
		//stream.forEach(n->System.out.print(n+","));	//반복자이기 때문에 다 읽은 후 다시 읽을 경우 다시 만들어줘야함.
		
		System.out.println("-".repeat(10)+"재생성 및 출력"+"-".repeat(10));
		stream=list.stream();
		stream.forEach(n->System.out.print(n+","));
		System.out.println();
		System.out.println("-".repeat(35));

		
		stream = list.stream();
		stream.forEach(n -> ParallelMain.print(n));
		System.out.println();
		
		stream = list.stream();
		stream.forEach(ParallelMain :: print);		
		System.out.println();
		
		//2. 병렬처리 : parallelStream()

		stream = list.parallelStream();
		stream.forEach(ParallelMain::print);
		
		

	}
	public static void print(String name) {
		System.out.println(name+":"+Thread.currentThread().getName());
	}

}
