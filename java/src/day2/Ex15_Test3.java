package day2;

public class Ex15_Test3 {

	public static void main(String[] args) {
		/* month가 주어졌을때 해당 달의 마지막 일을 출력하는 코드를 if문으로 작성하세요.
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * 그 외의 달은 잘못된 월 입니다 라고 출력.
		 * */
		int month = 4;
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println(month + "월은 31일 까지 입니다.");
		}
		else if(month == 4 || month == 6 || month ==9 || month == 11) {
			System.out.println(month + "월은 30일 까지 입니다.");
		}
		else if(month == 2) {
			System.out.println(month + "월은 28일 까지 입니다.");
		}
		else {
			System.out.println(month + "은 잘못된 월 입니다.");
		}

	}
}