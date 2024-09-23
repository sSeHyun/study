package ex03_multi_implements;

import ex02_implements.RemoteControl;

public class SmartTelevisionMain {

	public static void main(String[] args) {	
		
		RemoteControl rc=new SmartTelevisionRemoCon();	//자동형변환
		
		rc.powerOn();
		rc.setVolumn(5);
		rc.setMute(true);
		rc.powerOff();
		
		//rc.search("http://www.google.com"); -> 자식객체에서 부모객체로 자동형변환되어 사용 불가능
		System.out.println("-".repeat(20));
		
		SmartTelevisionRemoCon stvrc=new SmartTelevisionRemoCon();
		stvrc.powerOn();
		stvrc.setVolumn(5);
		stvrc.setMute(false);
		stvrc.search("http://www.google.com");
		stvrc.powerOff();
		System.out.println("-".repeat(20));
		
		Searchable rc1=stvrc;	//자동형변환
//		rc1.powerOn();
//		rc1.setVolumn(5);
//		rc1.setMute(false);
		rc1.search("http://www.google.com");
//		rc1.powerOff();
		
		RemoteControl.changeBattery();
	}

}
