package day6;

import java.util.Scanner;

public class Ex5_Arry5_2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
			int max = 10;
			int score[] = new int[max];
			System.out.println("학생수를 입력하세요 : ");
			int count = scan.nextInt();
			if(count > 10) {
				System.out.println("최대 10명까지 입니다.");
			}else if(count <= 0) {
				System.out.println("최소 1명부터 입니다.");
			}else {
				int sum = 0;
				double avg = 0.0;
				for(int i = 1; i<count; i++) {
					System.out.println(i+1+"번째 학생 : ");
					score[i] = scan.nextInt();
					sum += score[i];
				}
				avg = (double)sum/ count;
				System.out.println("총점 : " + sum +"점, 평균 : " + avg +"점");
			}
	}

}
