package day6;

import java.util.Scanner;

public class Ex7_Arry5_Score2 {

	public static void main(String[] args) {
		/* 최대 10명 학생의 성적을 저장하기 위한 배열을 선언하고
		 * 입력할 학생수를 입력을 받아 입력받은 학생수만큼 성적을 입력받고 총점과 평균을 출력하는 코드를 작성하세요
		 * 예시1
		 * 학생수를 입력하세요 : 3
		 * 1번학생 : 90
		 * 2번학생 : 80
		 * 3번학생 : 70
		 * 총점 : 240점, 평균 : 80점
		 * 
		 * 예시2
		 * 학생수를 입력하세요 : 11
		 * 최대 10명까지입니다.
		 * 
		 * 예3
		 * 학생수를 입력하세요 : 0
		 * 최소 1명부터 입니다.
		 * */
		Scanner scan = new Scanner(System.in);
			//배열선언
			int score[] = new int[10];
			//스캔선언
			System.out.println("학생수를 입력하세요 : ");
			//학생수 입력
			int num = scan.nextInt();
				if(num>10) {
					System.out.println("최대 10명까지 입니다.");
				}else if(num<1) {
					System.out.println("최소 1명부터 입니다.");
				}else {
			int sum = 0;
			double avg = 0;
			for(int i = 0; i<num; i++) {
				System.out.println(i + 1 +"번째 학생의 성적 : ");
				score[i] = scan.nextInt();
			}
			for(int i = 0; i<num; i++) {
				sum +=score[i];
			}
			avg= sum / (double)num;
				System.out.println("총점은 " + sum + "점이고, 평균은 " + avg + "점 입니다.");
			}
}
}