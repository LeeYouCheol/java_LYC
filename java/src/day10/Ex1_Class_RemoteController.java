package day10;

import java.util.Scanner;

public class Ex1_Class_RemoteController {

	public static void main(String[] args) {
		/* 메뉴를 출력 후 메뉴에 맞는 기능을 동작하도록 코드를 작성하세요
		 * 메뉴
		 * 1. 채널 Up
		 * 2. 채널 Down
		 * 3. 채널 변경
		 * 4. 볼륨 Up
		 * 5. 볼륨 Down
		 * 6. 전원
		 * 7. 종료
		 * 메뉴를 선택하세요 : 
		 * */
		Scanner scan = new Scanner(System.in);
		RemoteController rm = new RemoteController();
		int menu = -1;
		while(true) {
			System.out.println("메뉴");
			System.out.println("1. 채널 Up");
			System.out.println("2. 채널 Down");
			System.out.println("3. 채널 변경");
			System.out.println("4. 볼륨 Up");
			System.out.println("5. 볼륨 Down");
			System.out.println("6. 전원");
			System.out.println("7. 종료");
			System.out.print("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
			if(menu == 7) {
				break;
			}if(menu == 1) {
				rm.channelUp();
			}if(menu == 2) {
				rm.channelDown();
			}if(menu == 3) {
				System.out.println("채널을 입력하세요 : ");
				int num = scan.nextInt();
				rm.channel(num);
			}if(menu == 4) {
				rm.volumeUp();
			}if(menu == 5) {
				rm.volumeDown();
			}if(menu == 6) {
				rm.turn();
			}
		}
		scan.close();
	}
}
/* TV 리모컨 클래스를 생성하고, 객체를 생성 후 기능들을 테스트 해보세요.*/
class RemoteController{
	//전원 , 채널, 볼륨
	boolean power;
	int channel;
	int volume;
	int minVolume = 0;
	int maxVolume = 32;
	int minChannel = 1;
	int maxChannel = 999;
	/* 기능 : TV를 켜는 메소드
	 * 매개변수 : 없음. 키기만 하면 되기때문.
	 * 리턴타입 : 없음. 키기만 하면 되기때문.
	 * 메소드명 : turnOn
	 * */
	void turnOn() {
		power = true;
		System.out.println("Tv를 켰습니다.");
	}
	/* 기능 : TV를 끄는 메소드
	 * 매개변수 : 없음. 끄기만 하면 되기때문.
	 * 리턴타입 : 없음. 끄기만 하면 되기때문.
	 * 메소드명 : turnOff
	 * */
	void turnOff() {
		power = false;
		System.out.println("Tv를 껐습니다.");
	}
	/* 기능 : Tv를 키거나 끄는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 메소드명 : turn
	 * */
	void turn() {
		power = !power;
		if(power) {
			System.out.println("Tv를 켰습니다.");
		}else {
			System.out.println("Tv를 껐습니다.");
		}
	}
	/* 기능 : 소리를 한칸 올리는 기능
	 * 매개변수 : 그냥 버튼을 누르면 한칸씩만 오르면 되기때문에 없다.
	 * 리턴타입 : 없다.(없는 경우는 필드 값을 바꾸고 끝나는 경우다.)
	 * 메소드명 : volumUp 
	 * */
	void volumeUp() {
		//전원이 켜져있고, 소리가 최대치가 아니면
		if(power) {
			if(volume < maxVolume) {
				volume++;
			}
		}
		System.out.println("소리 : " + volume);
	}
	/* 기능 : 소리를 한칸 내리는는 기능
	 * 매개변수 : 그냥 버튼을 누르면 한칸씩만 내리면 되기때문에 없다.
	 * 리턴타입 : 없다.(없는 경우는 필드 값을 바꾸고 끝나는 경우다.)
	 * 메소드명 : volumUp 
	 * */
	void volumeDown() {
		//전원이 켜져있고, 소리가 최대치가 아니면
		if(power) {
			if(volume > minVolume) {
				volume--;
			}
		}
		System.out.println("소리 : " + volume);
	}
	/* 기능 : 채널을 1씩 증가하는 메소스
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 매개변수 : channerlUp
	 * */
	void channelUp() {
		if(power) {
			if(channel < maxChannel) {
				channel++;
			}
			System.out.println("채널 : " + channel);
		}
	}
	/* 기능 : 채널을 1씩 감소하는 메소스
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 메소드명 : channerlDown
	 * */
	void channelDown() {
		if(power) {
			if(channel > minChannel) {
				channel--;
			}
			System.out.println("채널 : " + channel);
		}
	}
	/* 기능 : 입력한 채널로 이동하는 메소드
	 * 매개변수 : 이동할 채널 = int ch
	 * 리턴타입 : void
	 * 메소드명 : channel
	 * */
	void channel (int ch) {
		if(power) {
			if(ch < minChannel) {
				channel = minChannel;
			}
			else if(ch > maxChannel) {
				channel = maxChannel;
			}else {
				channel = ch;
			}
			System.out.println("채널 : " + channel);
		}
	}
	public RemoteController() {
		channel = minChannel;
		volume = minVolume;
	} 
		
		
	public RemoteController(int ch, int v) {
		if(ch >= minChannel && ch <= maxChannel) {
			channel = ch;
		}else {
			channel=minChannel;
		}
		if(v > minVolume && v <= maxVolume) {
			volume = v;
		}
		else {
			volume = minVolume;
		}
	}
}

	

