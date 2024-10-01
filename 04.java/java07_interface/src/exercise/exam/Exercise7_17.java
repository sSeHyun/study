package exercise.exam;

abstract class Unit{
	int x,y;
	abstract void move(int x,int y);
	abstract void stop();
	
}

class Marine extends Unit{
	@Override
	public void move(int x, int y) {}

	@Override
	public void stop() {} 
	
	void stimPack() {/*스팀팩을 사용한다.*/}
	
}
class Tank extends Unit{

	@Override
	public void move(int x, int y) {}

	@Override
	public void stop() {}
	
	void changeMode() {/*공격모드를 변환한다.*/}
	
}
class Dropship extends Unit{

	@Override
	public void move(int x, int y) {}
	@Override
	public void stop() {}
	void load() {}
	void unload() {}
	
}



public class Exercise7_17 {

	public static void main(String[] args) {
		

	}

}
