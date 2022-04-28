package day4;

public class Ex9_Wile1_Hello {

	public static void main(String[] args) {
		/* Hello를 다섯번 출력하는 예제
		 * */
		int i = 1;
		while(i<=5) {
			System.out.println("Hello");
			i++;
		}
		i = 5; //5부터 하나씩 줄여서 5 4 3 2 1 순으로 진행 하고 종료.
		while(i-- > 0){
			System.out.println("Hi");
		}
	}

}
