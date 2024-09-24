package ex03_interface;
import ex03_interface.Button.OnClickListner;

public class Naver implements OnClickListner {
	@Override
	public void OnClick() {
		System.out.println("네이버로 검색을 합니다!");
	}
}
