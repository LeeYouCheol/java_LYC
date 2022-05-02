package day6;

import java.util.Scanner;

public class Ex1_Calculator {

	public static void main(String[] args) {
		/* 문자를 입력받아 입력받은 문자를 출력하는 코드를 작성하세요.
		 * 단, Q가 입력될때까지 계속적으로 받습니다.
		 * 메뉴를 선택하면 정수 2개를 입력받아 입력받은 값에 맞는 산술 연산 결과를 출력하는 코드를 작성하세요.
		 * 
		 * 산술 연산자 메뉴
		 * 1. 더하기
		 * 2. 빼기
		 * 3. 곱하기
		 * 4. 나누기
		 * 5. 나머지
		 * q. 종료
		 * 메뉴를 선택하세요 : 
		 * */
		
		Scanner scan = new Scanner(System.in);
			for( ; ; ) {
				System.out.println("산술 연산자 메뉴");
				System.out.println("1. 더하기");
				System.out.println("2. 빼기");
				System.out.println("3. 곱하기");
				System.out.println("4. 나누기");
				System.out.println("5. 나머지");
				System.out.println("q. 종료");
				System.out.println("메뉴를 선택하세요");
				char ch = scan.next().charAt(0);
				if(ch == 'q') {
					break;
				}
				if(ch < '1' || ch > '5') {
					System.out.println("잘못된 연산자 입니다.");
				}
				System.out.println("두 정수를 입력하세요 : ");
				int num1 = scan.nextInt();
				int num2 = scan.nextInt();
				double res = 0.0;
				switch(ch) {
				case '1':
					res = num1 + num2;
					System.out.println("" + num1 + " + " + num2 + " = " + res);
					break;
				case '2':
					res = num1 - num2;
					System.out.println("" + num1 + " - " + num2 + " = " + res);
					break;
				case '3':
					res = num1 * num2;
					System.out.println("" + num1 + " * " + num2 + " = " + res);
					break;
				case '4':
					res = num1 / num2;
					System.out.println("" + num1 + " / " + num2 + " = " + res);
					break;
				case '5':
					res = num1 % num2;
					System.out.println("" + num1 + " % " + num2 + " = " + res);
					break;
				}
				System.out.println();
			}
			scan.close();
			
	}
}
		/*
		 * 방법2.
		 
		char ch = 'a';
		for( ; ch != 'q' ; ) {
		System.out.print("문자를 입력하세요 : ");
		ch = scan.next().charAt(0);
		System.out.println("입력한 문자는 " + ch + "입니다.");
		*/
		/* 방법3
		 *
		char ch= 'q';
		do {
			System.out.print("문자를 입력하세요 : ");
			ch = scan.next().charAt(0);
			System.out.println("입력한 문자는 " + ch + "입니다.");
		scan.close();
		}while(ch != 'q');
		*/

