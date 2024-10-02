package ex01_intro;

import java.util.*;
import java.util.stream.Stream;

public class StreamMain {

	public static void main(String[] args) {
		
		List<String> list=Arrays.asList("손흥민","이강인","소향");
		
		//1. Iterator
		Iterator<String> names=list.iterator();
		while(names.hasNext()) {
			String name=names.next();
			System.out.print(name+",");
		}
		System.out.println();
		
		//2. Stream
		Stream<String> stream=list.stream();
		stream.forEach(x->System.out.print(x+","));

	}

}
