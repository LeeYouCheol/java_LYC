package day3;

import java.util.Scanner;

public class Ex4_1 {

	public static void main(String[] args) {
		//다른방법
		Scanner scan = new Scanner(System.in);
				System.out.println("정수와 산술연산자를 입력하세요 : ");
				int num1 = scan.nextInt();
				char op = scan.next().charAt(0);
				int num2 = scan.nextInt();
				
				if(op == '+') {
				System.out.println(""+num1 + op + num2+"="+(num1+num2));
				}
				else if(op == '-') {
					System.out.println(""+num1 + op + num2+"="+(num1-num2));
				}
				else if(op=='*') {
					System.out.println(""+num1 + op + num2+"="+(num1*num2));
				}
				else if(op=='/') {
					System.out.println(""+num1 + op + num2+"="+((double)num1/(double)num2));
				}
				else if(op=='%') {
					System.out.println(""+num1 + op + num2+"="+(num1%num2));
				}
				else {
					System.out.println(op+"는 산술연산자가 아닙니다.");
				}

}
}