package ex02_try_catch;

public class TryCatchMain1 {

	public static void main(String[] args) {
		//1. 일반예외
		//class.forName(클래스명) 메서드는 해당 클래스가 있다면 객체로 변환
		//즉 new객체생성 연산자와 동일한 기능을 한다.
		//만약 해당 클래스가 없을경우 예외가 발생된다.
		try {
			Class _class=Class.forName("java.lang.StringX");
			System.out.println(_class.getName());
			
		} catch (Exception e) {
			System.out.println("클래스를 찾지 못했습니다.");
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		
		System.out.println("중요한 로직 처리를 해야합니다!");
		
		
	}

}
