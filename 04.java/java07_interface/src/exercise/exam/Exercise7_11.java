package exercise.exam;

class MyTv3{
	int channel;
	int prevChannel;
	
	public void setChannel(int channel) {
		prevChannel=this.channel;
		this.channel=channel;
	}

	public int getChannel() {
		return channel;
	}
	
	public void gotoPrevChannel() {
		setChannel(prevChannel);
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
