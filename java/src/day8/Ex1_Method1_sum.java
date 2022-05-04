package day8;

public class Ex1_Method1_sum {

	public static void main(String[] args) {
		/* 두 정수의 합을 알려주는 메소드를 작성해 보세요
		 * */
		int num1 = 1, num2 = 2;
		int res = sum1(num1, num2);
		System.out.println(res);
		System.out.println(sum1(1,2));
		sum2(1,2);
		sum2(1+2,3);
		
	}
	
	/* 1. 기능 : 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
	 * 2. 메개변수 : 두 정수 => int num1, int num2;
	 * 3. 리턴타입 : 두 정수의 합 => 정수 => int
	 * 4. 메소드명 : sum
	 * */
	public static int sum1(int num1, int num2) {
		int res = num1 + num2;
		return res;
	}
	/* 1. 기능 : 두 정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드
	 * 2. 메개변수 : 두 정수 => int num1, int num2;
	 * 3. 리턴타입 : 없음.
	 * 4. 메소드명 : sum2
	 * */
	public static void sum2(int num1, int num2) {
		int res = num1 + num2;
		System.out.println(res);
	}
}
