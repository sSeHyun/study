package ex02_implements;

public class AudioRemoCon implements RemoteControl {
	
	private int volumn;
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("TV PowerOn");
	}
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("TV PowerOff");
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
		System.out.println("Audio의 현재 볼륨은 "+this.volumn+"입니다.");
	}
}
