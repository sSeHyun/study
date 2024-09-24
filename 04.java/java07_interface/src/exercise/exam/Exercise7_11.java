package exercise.exam;

class MyTv3{
	int channel;
	int prevChannel;
	
	public void setChannel(int channelNum) {
		this.channel=channelNum;
		this.prevChannel=channel;
	}

	public int getChannel() {
		return channel;
	}
	
	public int gotoPrevChannel() {
		int swap=0;
		prevChannel= swap;
		channel = prevChannel;
		swap = prevChannel;
		
		return swap;
	}
	
	
	
}

public class Exercise7_11 {

	public static void main(String[] args) {
		MyTv3 t=new MyTv3();
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		

	}

}
