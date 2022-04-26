package day2;

public class EX11_If1 {

	public static void main(String[] args) {
		if(true) {
			System.out.println("참입니다.");
		}
		/* 조건문이 거짓이기 떼문에 실향이 되질 않는다.
		if(false) {
			System.out.println("참입니다.");
		}*/
		/* num가 짝수이면 짝수라고 출력하는 코드를 if문을 이용하여 작서하세요.
		 * ~하ㅓ면 ~한다.
		 */
		int num = 2;
		if(num % 2 == 0) {
			System.out.println(num + "는" + " 짝수");
		}
		/* score가 90점이상이고, 100점이하이면 A학점이라고 출력하는 코드를 if문을 이용하요 작성하세요*/
		int score = 95;
		if(score >= 90 && score <= 100) {
			System.out.println("A학점");
		}
		int score1 = 95;
		if(score1 >= 90 && score1 <= 100) {
			System.out.println(score1 + "은 A학점");
		}
	}

}
