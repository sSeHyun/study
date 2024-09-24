package exercise.exam;

class Product{
	int price;
	int bonusPoint;
	
	Product(int price){
		this.price=price;
		bonusPoint=(int)((int)price/10.0);
	}
}
class Tv extends Product{
	
	Tv(int price) {
		super(price);
	}
	
	public String toString() {
		return "TV";
	}
}

public class Exercise7_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv t=new Tv(9999999);
		System.out.println(t.toString());
	}

}
