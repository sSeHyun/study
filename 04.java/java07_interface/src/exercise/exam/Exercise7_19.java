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
		//가진돈과 물건의 가격을 비교해서 가진돈이 적으면 메서드를 종료한다.
		//가진돈이 충분하면 제품의 가젹을 가진돈에서 뺴고
		//장바구니에 구입한 물건을 담느다.(add메서드호출)
	}
	void add(Product19 p) {
		//작성해야함
	}
	void summary() {
		//작성해야함
		
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

