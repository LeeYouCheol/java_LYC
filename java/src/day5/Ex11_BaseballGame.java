package day5;

import java.util.Scanner;

public class Ex11_BaseballGame {

	public static void main(String[] args) {
		/* 숫자 야구 게임을 작성하세요.
		 * 중복되지 않은 1~9사이의 세 정수를 입력받아 맞추는 게임
		 * 
		 * 입력 : 1 2 3
		 * 자릿수는 맞지 않지만 숫자 하나가 맞았다 = 1ball
		 * 입력 : 4 5 6
		 * 일치하는 수 없음 = o
		 * 입력 : 7 8 9
		 * 숫자와 자릿수 두개가 맞았다 = 2s
		 * 입력 : 8 3 9
		 * 하나는 자리가 같고 두개는 숫자는 같지만 위치가 다르다 = 1s 2ball
		 * 입력 : 3 8 9
		 * 3s
		 * 프로그램 종료
		 * 
		 * 반복횟수 : s가 3보다 작을때까지 반복
		 * 규칙성 : 정수 3개를 입력받음
		 * 			s와 b를 각각 0으로 초기화
		 * 			com1과 user1이 같으면 s를 1증가
		 * 			com2과 user2이 같으면 s를 1증가
		 * 			com3과 user3이 같으면 s를 1증가
		 * 			com1과 user2이 같거나 com1과 user3이 같으면 b를 1증가
		 * 			com2과 user1이 같거나 com2과 user3이 같으면 b를 1증가
		 * 			com3과 user1이 같거나 com3과 user2이 같으면 b를 1증가
		 * 			s가 0이 아니면 s의 갯수와 s를 출력
		 * 			b가 0이 아니면 b의 갯수와 b를 출력
		 * 			S가 0이고 b가 0이면 o를 출력
		 * */
		Scanner scan = new Scanner(System.in);
		
		int com1 = 3, com2 = 8, com3 = 9;
		int user1, user2, user3;
		int s = 0, b = 0;
			while(s<3) {
				System.out.println("정수를 입력하세요 : ");
				user1 =  scan.nextInt();
				user2 =  scan.nextInt();
				user3 =  scan.nextInt();
				//s와 b를 각각 0으로 초기화
				s = 0;
				b = 0;
				if(com1 == user1) {
					s++;
				}if(com2 == user2) {
					s++;
				}if(com3 == user3) {
					s++;
				}if(com1 == user2 || com1 == user3) {
					b++;
				}if(com2 == user1 || com2 == user3) {
					b++;
				}if(com3 == user1 || com3 == user2) {
					b++;
				}if(s != 0) {
					System.out.println(s + "S");
				}if(b != 0) {
					System.out.println(b + "B");
				}if(s ==0 && b == 0) {
					System.out.println("O");
				}
				System.out.println();
			}scan.close();
	}
}