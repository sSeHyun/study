package exercise.exam;

class Robot{}
class DanceRobot extends Robot{
	void dance() {
		System.out.println("춤을 춥니다.");
	}
}
class SingRobot extends Robot{
	void sing() {
		System.out.println("노래를 합니다.");
	}
}
class DrawRobot extends Robot{
	void draw() {
		System.out.println("그림을 그립니다.");
	}
}

public class Exercise7_18 {
	
	public static void action(Robot robot) {
		if(robot instanceof DanceRobot) {
			DanceRobot danceRobot=(DanceRobot) robot;
			danceRobot.dance();
		}else if(robot instanceof SingRobot) {
			SingRobot singRobot=(SingRobot) robot;
			singRobot.sing();
		}
		else if(robot instanceof DrawRobot) {
			DrawRobot drawRobot=(DrawRobot) robot;
			drawRobot.draw();
		}
	}
	
	public static void main(String[] args) {
		Robot[] arr= {new DanceRobot(),new SingRobot(),new DrawRobot()};
		
		for(int i=0;i<arr.length;i++)
			action(arr[i]);

	}

}
