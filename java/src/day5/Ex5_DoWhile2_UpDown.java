package day5;

import java.util.Scanner;

public class Ex5_DoWhile2_UpDown {

	public static void main(String[] args) {
		
		int min = 1, max = 100;
		int r = (int)(Math.random() * (max-min+1) + min);
		Scanner scan = new Scanner(System.in);
		int num;
		
		System.out.println("랜덤으로 생성한 수(1~100) : " + r);
		
		do {
			//정수를 입력받고,
			System.out.print("1~100사이의 정수를 입력하세요 : ");
			num = scan.nextInt(); 
			
			//1미만 100초과인 경우 스킵
			if(num < 1 || num > 100) {
				continue;
			}
			//입력받은 정수 num가 랜덤한수 r보다 크면 DOWN이라고 출력하고,
			if(num > r) {
				System.out.println("DOWN");
			}
			//입력받은 정수 num가 랜덤한수 r보다 작으면 UP이라고 출력 
			else if(num < r){
				System.out.println("UP");
			}
		}while(num != r);
		System.out.println("정답입니다.");
		scan.close();
	}

}
