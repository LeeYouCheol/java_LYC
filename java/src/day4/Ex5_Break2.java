package day4;

import java.util.Scanner;

public class Ex5_Break2 {

	public static void main(String[] args) {
		/* 양의정수를 5번 입력학고, 입력한 정수를 콘솔에 출력하는 코드를 작성하세요.
		 * 입력받은 정수가 음수이면 반복문을 빠져나오게 한다
		 * */
		Scanner scan = new Scanner(System.in);
		int i, num;
		//무한번 입력하고 싶으면  'i<=5'를 지우면 된다. 또한 'scan.close();'를 지운다.
		for(i=1; i<=5; i++) {
			System.out.println("양의 정수 입력 : ");
			num = scan.nextInt();
			if(num < 0) {
				break;
			}
			System.out.println(num);
		}
		scan.close();
	}

}

