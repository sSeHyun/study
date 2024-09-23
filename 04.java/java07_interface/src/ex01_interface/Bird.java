package ex01_interface;

public class Bird implements Animal {

	@Override
	public void sound() {
		System.out.println("새는 짹짹하고 소리를 낸다!");
	}
	public void breath() {
		System.out.println("새가 숨을 쉽니다.");
	}

}
