package ex04_tree.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer,String> students=new TreeMap<>();
		students.put(87,"홍길동");
		students.put(98,"손흥민");
		students.put(75,"이강인");
		students.put(95,"김민재");
		students.put(80,"소향");
		
		Map.Entry<Integer,String> student=null;
		
		student=students.firstEntry();
		System.out.println("[가장낮은점수]"+student.getValue()+"의 점수="+student.getKey());
		student=students.lastEntry();
		System.out.println("[가장낮은점수]"+student.getValue()+"의 점수="+student.getKey());
		student=students.lowerEntry(95);
		System.out.println("[95점 바로 아래 점수]"+student.getValue()+"의 점수="+student.getKey());
		student=students.higherEntry(95);
		System.out.println("[95점 바로 위 점수]"+student.getValue()+"의 점수="+student.getKey());
		student = students.floorEntry(94);
		System.out.println("[94이거나 바로 아래 점수] " + student.getValue() + "의 점수 = " + student.getKey());
		student = students.ceilingEntry(94);
		System.out.println("[94이거나 바로 위 점수] " + student.getValue() + "의 점수 = " + student.getKey());
		
		while(!students.isEmpty()) {
			//student=students.pollFirstEntry();
			student=students.pollLastEntry();
			System.out.println(student.getValue()+"의 점수="+student.getKey()+", 남은 갯수"+students.size());
		}

	}

}
