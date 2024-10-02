package ex01_intro;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.*;

public class LamdaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list=Arrays.asList(
				new Student("홍길동",95),
				new Student("홍길순",91),
				new Student("홍길자",98),
				new Student("홍길상",92));
		
		//1. list vs stream
		System.out.println("현재 객체의 총 갯수(list) ="+list.size());		//외부반복자
		
		Stream<Student> stream=list.stream();
		System.out.println("현재 객체의 총 갯수(stream) ="+stream.count());	//내부반복자
		
		//다시 list or stream 자료를 읽을 경우
		System.out.println("re. 현재 객체의 총 갯수(list) ="+list.size());		//list의 속성
		//System.out.println("re. 현재 객체의 총 갯수(stream) ="+stream.count());	//반복자 ->  java.lang.IllegalStateException error 발생
		//에러 발생 원인 : 반복자(내부)이기 때문에 더이상 꺼내올 자료가 없어 에러 발생
		//				   따라서 stream을 다시 사용하려면 stream값을 다시 대입한 후에 사용할 수 있다.
		stream=list.stream();
		System.out.println("re. 현재 객체의 총 갯수(stream) ="+stream.count());
		
		//2. 객체 사용 - 학생이름과 점수를 출력
		// forEach() - 최종처리메서드
		stream=list.stream();
		stream.forEach(std->System.out.print(std.getName()+"의 점수="+std.getScore()+" / "));
		System.out.println();
		
		stream=list.stream();
		stream.forEach(std->{
			String name=std.getName();
			int score= std.getScore();
			System.out.print(name+"의 점수="+score+" / ");
			
		});
		

	}

}
class Student{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
