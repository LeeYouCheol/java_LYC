package day3;

import java.util.Scanner;

public class Ex3_Scanner3 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 출력하는 코드를 작성하세요.
		 * */
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.println("입력한 정수는 " + num1 + "입니다.");
		
		System.out.println("정수를 입력하세요 : ");
		int num2 = scan.nextInt();
		System.out.println("입력한 정수는 " + num2 + "입니다.");
		
		System.out.println("연산자를 입력하세요 : ");
		char ch = scan.next().charAt(0);
		System.out.println("입력한 연산자는 " + ch + "입니다.");
		System.out.println("입력할 정수와 연산자는 " + num1 + ch + num2 + " 입니다.");
		scan.close();		
	}

}
