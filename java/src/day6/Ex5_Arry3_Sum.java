package day6;

import java.util.Scanner;

public class Ex5_Arry3_Sum {

	public static void main(String[] args) {
		/* 학생 3명의 국어 성적을 입력받고 총점과 평균을 구하는 코드를 작성하세요.
		 * 단, 총점과 평균을 출력한 후, 학생 3명의 성적을 출력하세요.
		 * score[0] = 입력;
		 * score[1] = 입력;
		 * score[2] = 입력;
		 * score[3] = 입력;
		 * */
		//배열선언 : 몇개짜리?
		int []score = new int[3];
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		double avg = 0;
		//반복문 : 몇번?
			//학생의 점수를 입력
		for(int i = 0; i<score.length; i++) {
			System.out.print(i + 1 + "번째 학생 성적 : ");
			score[i] = scan.nextInt();
		}
		//반복문을 이용하여 총점을 계산
		for(int i = 0; i<score.length; i++) {
			sum += score[i];
		}
		//총점을 이용하여 평균을 계산
		avg = sum / (double)score.length;
		System.out.println("학생 3명의 총점은 " + sum + "점이고, 평균은 " + avg + "점 입니다.");
		//반복문을 이용하여 학생 점수를 출력	
		for(int i = 0; i<score.length; i++) {
			System.out.println(i+1+"번째 학생 성정 : " + score[i]);
		}
	}

}
