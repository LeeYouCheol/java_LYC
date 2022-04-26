package day2;

public class Ex12_If2 {

	public static void main(String[] args) {
		/* num가 짝수이면 짝수 라고 출력하고
		 * 짝수가 아니면 홀수라고 출력하는 코드를 If문을 이용하여 작성하세요.
		 * */
		int num = 5;
		// if문을 두번쓴 예제는 num가 홀수/짝수에 상관없이 무조건 2번 비교를 한다.
		if(num % 2 == 0) {
			System.out.println(num + "은 짝수");
		}
		if(num % 2 != 0) {
			System.out.println(num + "는 홀수");
		}
		// if else문을 이용한 예제는 num가 짝수이면 1번비교하고, 홀수이면 2번 비교한다.
		if(num % 2 == 0) {
			System.out.println(num + "은 짝수");
		}
		else {
			System.out.println(num + "는 홀수");
	}

	}
	
	}
