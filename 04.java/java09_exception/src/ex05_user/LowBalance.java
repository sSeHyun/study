package ex05_user;

public class LowBalance extends Exception {
	
	public LowBalance() {}
	
	public LowBalance(String message) {
		super(message);
	}
}
