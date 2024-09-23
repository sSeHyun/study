package ex02_implements;

public class RemoteControlMain {

	public static void main(String[] args) {
		
		//TVRemoCon tvRemoCon=new TVRemoCon();
		
		RemoteControl rc;
		rc=new TVRemoCon();	//TV button click
		rc.powerOn();
		rc.setMute(false);
		rc.setVolumn(5);
		RemoteControl.changeBattery();	//static method
		rc.powerOff();
		System.out.println("-".repeat(20));
		
		rc=new AudioRemoCon();	//Audio button click
		rc.powerOn();
		rc.setMute(false);
		rc.setVolumn(5);
		RemoteControl.changeBattery(); //static method
		rc.powerOff();
		System.out.println("-".repeat(20));
		
	
	}

}
