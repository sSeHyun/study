package exercise.exam;

class Unit{
	int x,y;
	public void move(int x,int y) {/*지정된 위치로 이*/};
	public void stop() {/*현재 위치에 정지*/};
	
}

class Marine extends Unit{
	Marine(){
			
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		super.move(x, y);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	} 
	
}
class Tank extends Unit{

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		super.move(x, y);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}
	
}
class Dropship extends Unit{

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		super.move(x, y);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}
	void load() {}
	void unload() {}
	
}



public class Exercise7_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
