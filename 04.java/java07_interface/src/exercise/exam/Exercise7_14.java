package exercise.exam;

class SutdaCard2{
	final int num;
	final boolean isKwang;
	
	SutdaCard2(){
		this(1,true);
	}
	SutdaCard2(int num,boolean isKwang){
		this.num=num;
		this.isKwang=isKwang;
	}
	public String toString() {
		return num + (isKwang ? "K":"");
	}
}


public class Exercise7_14 {

	public static void main(String[] args) {
		SutdaCard2 card=new SutdaCard2(1,true);

	}

}
