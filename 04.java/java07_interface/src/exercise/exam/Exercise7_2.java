package exercise.exam;

class SutdaDeck1{
	final int CARD_NUM=20;
	SutdaCard1[] cards=new SutdaCard1[CARD_NUM];
	
	SutdaDeck1(){	
		for(int i=0;i<CARD_NUM;i++) 
		{
			if(i==0||i==2||i==7)
			cards[i]=new SutdaCard1(i+1,true);
			else cards[i]=new SutdaCard1(i%10+1,false);
		}
	}

	
	void shuffle (){
		int card_position;
		SutdaCard1 temp=new SutdaCard1();

		for(int i=0;i<CARD_NUM;i++) {
		
			card_position=(int)(Math.random()*CARD_NUM);
			
			cards[i] = temp;
			cards[card_position] = cards[i];
			temp = cards[card_position];
			
		}
			
	}
		
//		a=b
//		b=temp
//		temp=a

		
	SutdaCard1 pick(int index){
		return cards[index];
	}

	SutdaCard1 pick(){
		int card_position=(int)(Math.random()*CARD_NUM);
		return cards[card_position];
	}
	
	
	
}
class SutdaCard1{
	int num;
	boolean isKwang;
	
	SutdaCard1(){
		this(1,true);
	}
	SutdaCard1(int num,boolean isKwang){
		this.num=num;
		this.isKwang=isKwang;
	}
	
	public String toString() {
		return num+(isKwang?"K":"");
	}
}

public class Exercise7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		SutdaDeck1 deck=new SutdaDeck1();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		
		for(int i=0; i<deck.cards.length;i++) {
			System.out.print(deck.cards[i]+",");
		}
		
		System.out.println();
		System.out.println(deck.pick(0));

	}

}
