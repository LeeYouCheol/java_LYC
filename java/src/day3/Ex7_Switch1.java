package day3;

public class Ex7_Switch1 {

	public static void main(String[] args) {
		/* 홀수 짝수 판별 예제
		 * num가 2로 나누었을때 나머지가 0과 같으면 짝수라고 출력하고
		 * 아니면 홀수라고 출력한다
		 * */
		int num = 3;
		if(num % 2 == 0) {
			System.out.println(num + "는 짝수");
}
		else {
			System.out.println(num + "는 홀수");
		}
		switch(num % 2) {
		case 0:
			System.out.println(num + "는 짝수");
			break;
		case 1:
			System.out.println(num + "는 홀수");
		}
}
}
