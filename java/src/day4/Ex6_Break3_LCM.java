package day4;

import java.util.Scanner;

public class Ex6_Break3_LCM {

	public static void main(String[] args) {
		/* 두 정수의 최소 공배수를 구하는 예제를 작성하세요
		 * 공배수 : 두정수의 공통으로 있는 배수
		 * 최소 공배수 : 두 정소의 공배수중 최소값
		 * 10의 배수 : 10 20 30 40 50 60
		 * 15의 배수 : 15 30 45 60 75 90
		 * 10과 15의 공배수 : 30 60 90
		 * 10과 15의 최소 공배수 : 30
		 * */
		
		int num1 = 10;
		int num2 = 15;
		int i;
		for(i=1; i<=num1*num2; i++) {
			if(i % num1 == 0 && i % num2 == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}