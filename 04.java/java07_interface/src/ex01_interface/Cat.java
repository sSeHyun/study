package ex01_interface;

public class Cat implements Animal {

	@Override
	public void sound() {
		System.out.println("고양이는 야옹하고 소리를 낸다!");
	}

}
