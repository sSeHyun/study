package exercise.exam;
public class Exercise7_19 {
	public static void main(String[] args) {
		Buyer b=new Buyer();
		b.buy(new Tv19());
		b.buy(new Computer());
		b.buy(new Tv19());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	}
}
class Buyer{
	int money=1000;
	Product19[] cart=new Product19[3];
	int i=0;
	
	void buy(Product19 p) {
		if(this.money<p.price) {
			System.out.println("잔액이 부족하여" + p +"를 구매 할 수 없습니다.");
			return;
		}
		else{
			money-=p.price;
			add(p);
		}
	
	}
	void add(Product19 p) {
		
	}
	void summary() {
		
		
	}
}
class Product19{
	int price;
	
	Product19(int price){
		this.price=price;
	}
}
class Tv19 extends Product19{
	Tv19(){super(100);}
	public String toString() {return "Tv";}
}
class Computer extends Product19{
	Computer() {super(200);}
	public String toString() {return"Computer";}
}
class Audio extends Product19{
	Audio(){super(50);}
	public String toString() {return "Audio";}
}

