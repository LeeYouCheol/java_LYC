package day5;

import java.util.Scanner;

public class Ex3_UpDown {

	public static void main(String[] args) {
		/* 랜점으로 생성한 수(1~100)를 맞추는 게임을 작성하세요
		 * 정수를 입력했 때 입력한 정수보다 랭덤으로 생선된 수가 크면 up, 작으면 Down을 표시하고
		 * 맞으면 맞췄습니다. 라고 표시
		 * 랜덤으로 생성한 수 : 40
		 * 입력 : 100
		 * Down
		 * 입력 : 50
		 * Down
		 * 입력 : 25
		 * Up
		 * 입력 : 40
		 * 정답니다.
		 * 
		 * 반복횟수 : 무한대
		 * 규칙성 : 정수를 입력받고, 입력받은 정수가 랜던한 수 r과 같으면 정답입니다. 라고 출력한후 반복문을 나온다
		 * 			입력받은 정수가 랜덤한수 r과 같지 않고 r보다 크면 down이라고 출력
		 * 			입력받은 정수가 랜덤한수 r과 같거나 크지 않으면 up이라고 출력
		 * */
		
		int min = 1, max = 100;
		int r = (int)(Math.random() * (max-min+1) + min);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("랜덤으로 생성한 수 : " + r);
		
		for(int i= 1; i<= 100; i++) {
			System.out.print("정수를 입력하세요 : ");
			int num = scan.nextInt();
			//1미만 100초과인 경우는 스킵.
			if(num < 1 || num >100) {
				continue;
			}
			if(num < r) {
				System.out.println("Up");
				
			}else if(num > r) {
				System.out.println("Down");
				
			}else {
				System.out.println("정답니다.");
				break;
			}//else가 끝난후 이 위치로 오게되는데 이곳에 코드가 없다. 따라서 다시 조건식으로 올라가게 된다. 때문에 break를 입력해야한다.
				
	}
			scan.close();
}
}