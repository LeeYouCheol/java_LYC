package day8;

public class Ex3_Method3_GCD_LCM {

	public static void main(String[] args) {
		int num1 = 6, num2 = 12;
		int gcd = gcd(num1, num2);
		System.out.println(num1+"과 " + num2 + "의 최대 공약수 : " + gcd);

		int lcm = lcm(num1, num2);
		System.out.println(num1 + "과 " + num2 + "의 최소 공배수 : " + lcm);
	}
	/* 기능 : 두 정수가 주어지면 두 정수의 최대 공약수를 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 :	gcd
	 * 메소드명 : gcd
	 * */
	public static int gcd(int num1, int num2) {
		int gcd = 1;
		for(int i = 1; i <= num1; i++) {
			if(num1 % i == 0 && num2 % i == 0) {
				gcd=i;
			}
		}
		return gcd;
	}
	/* 기능 : 두정수의 최소 공배수를 알려주는 메소드
	 * 매개변수 : 두 정수 int num3, int num4
	 * 리턴타입 : lcm
	 * 메소드명 : lcm
	 * */
	public static int lcm(int num1, int num2) {
		int lcm = 1;
		for(int i = 1; i <= num1*num1; i++) {
			if(i % num1 == 0 && i % num2 == 0) {
				lcm=i;
				break;
			}
		}
		return lcm;
	}
}
