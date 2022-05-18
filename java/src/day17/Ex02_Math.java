package day17;

public class Ex02_Math {

	public static void main(String[] args) {
		/* 주어진 정수를 소수점 둘째자리에서 반올림하는 코드를 작성하세요.
		 * */
		double pi = 3.141592;
		double pi2 = pi*10; //10을 곱해서 31.41592로 만듬
		double pi3 = Math.round(pi2) / Math.pow(10, 1); //반올림 한것을 10으로 나눔
		
		System.out.println(pi3);
	}
}
