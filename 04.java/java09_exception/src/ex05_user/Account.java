package ex05_user;

public class Account {
	private int balance;
	
	public int getBalance() {
		return this.balance;
	}
	void depost(int money) {
		//예금
		this.balance+=money;
	}
//	void withdraw(int money) {
//		//출금
//		if(balance<money) {
//			System.out.println("잔액이 부족합니다!");
//		}
//		else {
//			this.balance-=money;
//		}
//	}
	void withdraw(int money) throws LowBalance {
		if(balance<money) {
			throw new LowBalance("잔액이 부족합니다! 현재 잔액: "+this.balance
								+"이고 부족한 금액은"+(this.balance-=money)+"입니다." );
		}else {
			this.balance-=money;			
		}
	}
}
