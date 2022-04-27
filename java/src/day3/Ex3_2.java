package day3;

import java.util.Scanner;

public class Ex3_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//다른방법
		System.out.println("정수와 산술연산자를 입력하세요 : ");
		int num1 = scan.nextInt();
		char op = scan.next().charAt(0);
		int num2 = scan.nextInt();
		System.out.println(""+num1 + op + num2);
		scan.close();
		

	}

}
