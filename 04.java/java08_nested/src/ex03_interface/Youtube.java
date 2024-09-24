package ex03_interface;

public class Youtube implements Button.OnClickListner {
	@Override
	public void OnClick() {
		System.out.println("유튜브로 동영상을 시청합니다!");
	}
}
