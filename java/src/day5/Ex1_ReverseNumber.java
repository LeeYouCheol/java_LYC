package day5;

import java.util.Scanner;

public class Ex1_ReverseNumber {

	public static void main(String[] args) {
		/* 양의정수를 입력받아 입력받은 정수를 역으로 출력하는 코드를 작성하세요.
		 * 1230 => 0을 출력, 1230 => 123
		 * 123 => 3을 출력, 123 => 12
		 * 12 => 2를 출력, 12 => 1
		 * 1 => 1을 출력, 1 => 0
		 * 
		 * 반복횟수 : num가 0이 아닐때까지
		 * 규착성 : num의 일의 자리를 출력 한 후 num 10으로 나눈 몫을 num에 저장 (규칙성이 입력문이라면, 반복문 전에 입력해야한다.)
		 * */
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int reverseNum = 0;
		int tmpNum = num;
		while(num!=0) {
			//num - num/10*10
			System.out.print(num % 10);
			reverseNum = 10*reverseNum + num % 10;
			num = num / 10; //123을 10으로 나누면 12.3이 아니라 12가 나온다.
	}
			System.out.println(tmpNum + "를 거꾸로한 정수 : " + reverseNum);
			scan.close();
}
}