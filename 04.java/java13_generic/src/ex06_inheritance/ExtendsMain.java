package ex06_inheritance;
/*
	제네릭타입의 상속(extends)과 구현(implement)
	
	제네릭타입도 다른 타입과 마찬가지로 부모클래스가 될 수 있다. 부모클래스에서
	상속받은 자식클래스는 부모클래스에 정의된 타입을 정의해야 한다.
	
	또한, 자식클래스는 타입파마미터를 추가할 수 있으며 제네릭 인터페이스를 구현한
	클래스에서도 제네릭타입으로 정의되어야 한다.

*/
public class ExtendsMain {

	public static void main(String[] args) {
		// 1. class
		ChildProduct<TV, String, String> tv=new ChildProduct<TV, String, String>();
		tv.setKind(new TV());		//부모의 제네릭타입 즉,Product의 kind
		tv.setModel("Smart Tv");	//부모의 제네릭타입 즉,Product의 model
		tv.setColor("white");		//자식의 제네릭타입 즉,ChildProduct의 color
		
		System.out.println(tv.toString());
		
		ChildProduct<Car, String, String> car=new ChildProduct<Car, String, String>();
		car.setKind(new Car());
		car.setModel("포르쉐 카이엔");
		car.setColor("gray");
		System.out.println(car.toString());
		
		
		
		//2. interface
		Storage<TV> 티비창고=new StorageImpl<TV>(100);
		티비창고.add(new TV(), 10);
		티비창고.get(10);
		System.out.println(티비창고.getClass().getName());
		
		Storage<Car> 자동차창고=new StorageImpl<Car>(10);
		자동차창고.add(new Car(), 2);
	}

}
