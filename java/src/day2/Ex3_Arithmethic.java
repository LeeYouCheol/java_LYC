package day2;

public class Ex3_Arithmethic {

	public static void main(String[] args) {
		/* 산술 연산자 주의 사항1 : 나누기 할때 소수점 사라지는 현상 조심
		 * 
		 * 정수 연산자 정수 > 정수
		 * 5 + 2 = 7
		 * 5 - 2 = 3
		 * 5 * 2 = 10
		 * 5 % 2 = 1
		 * 5 / 2 = 2 > 정수이기 때문에 2.5가 아니라 2가 나온다. 더블 을 써야한다.
		 * 정수 연산자 실수 => 실수
		 * 실수 연산자 실수 => 실수
		 * 결과값이 어떤 수
		 */
		System.out.println(5 + 2);
		System.out.println(5 - 2);
		System.out.println(5 * 2);
		System.out.println(5 % 2);
		System.out.println(5 / 2);
		System.out.println(5 / 2.0);
		System.out.println(5 / (double)2);
		//산술 연산자 주의 사항2 : 0으로 나눈 경우 예외가 발생할 수 있다.(정수 / 0인 경우)
		// 이건 안됨 System.out.println(5 / 0);
		System.out.println(5 / 0.0); // .0을 붙이면 무한대가 나온다.
		//나머지 연산자도 마찬가지 System.out.println(5 % 0);
		System.out.println(5 % 0.0); //NaN이 나온다.
	}

}
