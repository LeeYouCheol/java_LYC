package day2;

public class Ex4_string {

	public static void main(String[] args) {
		/* 문자열 + 문자열 = 문자열
		 * 문자열 + 정수 = 문자열
		 * 문자열 + 문자 = 문자열
		 * 문자열 + 실수 = 문자열
		 * 문자열 + 논리형 = 문자열
		 */
		String str = "Hello";
		str = str + " world";
		System.out.println(str);
		str = str +'!';
		System.out.println(str);
		str = str + 123;
		System.out.println(str);
		str = str + 3.45;
		System.out.println(str); // 더해진게 아니라 이어서 써진것이다
		str = str + true;
		System.out.println(str); // 마찬가지다.
		

	}

}
