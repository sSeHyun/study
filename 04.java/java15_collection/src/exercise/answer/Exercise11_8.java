package exercise.answer;

import java.util.*;

class Student8 implements Comparable{

	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	int total;
	int schoolRank;
	
	Student8(String name,int ban,int no, int kor, int eng,int math){
		
		this.name=name;
		this.ban=ban;
		this.no=no;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		
		total=kor+eng+math;
	}
	int getTotal() {
		return total;
	}
	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5)/10f;
	}
	
	public String toString() {
		return name +","+ban+","+kor+","+","+eng+","+math+","+getTotal()+","+getAverage()+","+schoolRank;
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Student8) {
			Student8 tmp=(Student8) o;
			return tmp.total=this.total;	
		}else return -1;
	}
}



public class Exercise11_8 {
	public static void calculateSchoolRank(List list) {
		Collections.sort(list);
		
		int prevRank= -1;
		int prevTotal=01;
		int length=list.size();
		
		for(int i=0;i<length;i++) {
			Student8 s=(Student8)list.get(i);
		}
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		list.add(new Student8("이자바",2,1,70,90,70));
		list.add(new Student8("안자바",2,2,60,100,80));
		list.add(new Student8("홍길동",1,3,100,100,100));
		list.add(new Student8("남궁성",1,1,90,70,80));
		list.add(new Student8("김자바",1,2,80,80,90));
		
		calculateSchoolRank(list);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}

