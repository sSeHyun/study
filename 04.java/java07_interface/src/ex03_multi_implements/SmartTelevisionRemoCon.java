package ex03_multi_implements;

import ex02_implements.RemoteControl;

public class SmartTelevisionRemoCon implements RemoteControl,Searchable{
	
	private int volumn;
	
	@Override
	public void powerOn() {
	// TODO Auto-generated method stub
		System.out.println("Smart TV PowerOn");
	}
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("Smart TV PowerOff");
	}
	@Override
	public void setVolumn(int volumn) {
		if(volumn>RemoteControl.MAX_VOLUMN) {
			this.volumn=RemoteControl.MAX_VOLUMN;			
		}
		else if(volumn<RemoteControl.MIN_VOLUMN) {
			this.volumn=RemoteControl.MIN_VOLUMN;
		}else {
			this.volumn=volumn;
		}
		System.out.println("스마트 TV의 현재 볼륨은 "+this.volumn+"입니다.");
	}
	@Override
	public void search(String url) {
		System.out.println(url+"에서 검색기능을 실행합니다.");
		
	}
}
