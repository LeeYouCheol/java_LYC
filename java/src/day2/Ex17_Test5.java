package day2;

public class Ex17_Test5 {

	public static void main(String[] args) {
		/* num가 2의 배수이면 2의 배수라고 출력하고
		 * num가 3의 배수이면 2의 배수라고 출력하고
		 * num가 6의 배수이면 6의 배수라고 출력하고
		 * num가 2,3,6의 배수가 아니면 2,3,6의 배수가 아니라고 출력하는 코드를 작성하세요
		 * n의 배수 : num을  n으로 나누었을 때 나머지가 0과 같다.
		 * 단, num가 6이면 6의 배수라고 출력해야 합니다. 2의배수, 3의배수 출력이 나오면 안됩니다.
		 * 힌트1 : 6의 배수를 먼저 체크
		 * 힌트2 : 2의 배수를 확인할 때 3의 배수가 아닌 숫자를 확인
		 * */
		int num = 6;
		if(num % 6 == 0) {
			System.out.println(num + "은(는) 6의배수");
		}
		else if(num % 3 == 0) {
			System.out.println(num + "은(는) 3의배수");
		}
		else if(num % 2 == 0) {
			System.out.println(num + "은(는) 2의배수");
		}
		else {
			System.out.println(num + "은(는) 2, 3, 6의 배수가 아닙니다.");
		}
		/* if(num % 2 == 0 && num % 3 != 0) {
		 * sysout}
		 * else if(num % 3 == 0 && num % 2 != 0)
		 * */
	}

}
