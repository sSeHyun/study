package ex04_anonymous;

import ex02_implements.RemoteControl;
import ex02_implements.TVRemoCon;

public class RemoteControlMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.인터페이스는 객체 생성불가
		//RemoteControl rc=new RemoteControl();	

		
		//2. 익명 구현 객체
		RemoteControl rc;
	    int volumn;
		
		//1) TV RemoCon
	    	rc = new RemoteControl() {
			
			private int volumn;
			
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
				System.out.println("TV의 현재 볼륨은 "+this.volumn+"입니다.");
			}
			
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
		};
		
		rc.powerOn();
		rc.setMute(false);
		rc.setVolumn(5);
		rc.powerOff();
		System.out.println();	
		
		
		//2) Audio RemoCon
		rc=new RemoteControl() {
			

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
					volumn=RemoteControl.MAX_VOLUMN;			
				}
				else if(volumn<RemoteControl.MIN_VOLUMN) {
					volumn=RemoteControl.MIN_VOLUMN;
				}else {
					volumn=volumn;
				}
				System.out.println("Audio의 현재 볼륨은 "+volumn+"입니다.");
			}
			
		};
		
		rc.powerOn();
		rc.setMute(false);
		rc.setVolumn(5);
		rc.powerOff();
		System.out.println();	
		
		// 3. Radio RemoCon
		rc = new RemoteControl() {
			// 라디오기능을 구현
			public void setVolumn(int volumn) {}
			public void powerOn() {}
			public void powerOff() {}
		};
		
		// 4. Wireless Speaker RemoCon
		rc = new RemoteControl() {
			// 무선스피커기능을 구현
			public void setVolumn(int volumn) { /* 무선스피커 기능을 정의 */}
			public void powerOn() {}
			public void powerOff() {}
		};
		
		// 기타등등 RemoCon....
		

	}

}
