package exercise.exam;

class MyTv2{
	boolean isPowerOn;
	int channel;
	int volume;
	
	final int MAX_VOLUME=100;
	final int MIN_VOLUME=0;
	final int MAX_CHANNEL=100;
	final int MIN_CHANNEL=0;
	
	public void setChannel(int channelNum) {
		if(channel > MAX_CHANNEL || channel < MIN_CHANNEL) return;
		this.channel=channelNum;
	}
	public void setVolume(int volume) {
		if(volume > MAX_VOLUME || volume < MIN_VOLUME) return;
		this.volume=volume;
	}
	
	public int getChannel() {
		return channel;
	}
	public int getVolume() {
		return volume;
	}
	
}



public class Exercise7_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTv2 t=new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:"+t.getVolume());

	}

}
