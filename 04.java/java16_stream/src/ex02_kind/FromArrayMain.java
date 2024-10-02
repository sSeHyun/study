package ex02_kind;

import java.util.Arrays;
import java.util.stream.*;
import java.util.*;
public class FromArrayMain {

	public static void main(String[] args) {
		// 2. Array로부터 Stream을 얻기
		
		String[] names= {"손흥민","이강인","소향","김민재","홍길동"};
		
		Stream<String> stream=Arrays.stream(names);
		stream.forEach(System.out::println);
		System.out.println();
		
		int[] nums= {1,2,3,4,5,6,7,8,9,10};
		IntStream intStream=Arrays.stream(nums);
		intStream.forEach(System.out::print);
		System.out.println();
		
		double[] d_nums = {1,2,3,4,5,6,7,8,9,10};
		DoubleStream ds = Arrays.stream(d_nums);
		ds.forEach(n -> System.out.print(n + ", "));
		System.out.println();
		
		long[] l_nums = {1,2,3,4,5,6,7,8,9,10};
		LongStream ls = Arrays.stream(l_nums);
		ls.forEach(n -> System.out.print(n + ", "));
		System.out.println();
		
		//실습. intStream에서 1~10까지 합계 출력
		
		intStream=Arrays.stream(nums);
		int result=intStream.sum();
		System.out.println("1~10까지의 합계: "+result);
		
		

	}

}
