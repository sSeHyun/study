package ex05_user;

public class AccountMain {
	public static void main(String[] args) throws LowBalance {
		
		Account account=new Account();
		
		account.depost(100);
		System.out.println("현재잔액="+account.getBalance());
		
		account.withdraw(50);
		System.out.println("현재잔액="+account.getBalance());
		
		account.withdraw(70);
		

	}
}
