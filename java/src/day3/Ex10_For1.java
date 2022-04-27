package day3;

public class Ex10_For1 {

	public static void main(String[] args) {
		/* 콘솔에 Hello를 5번 출력력하세요.
		 * Hello	i=1 Hello
		 * Hello	i=2 Hello
		 * Hello	i=3 Hello
		 * Hello	i=4 Hello
		 * Hello	i=5 Hello
		 * 
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성(실행문) : Hello를 출력
		 * */
		int i;
		for(i=1; i<=5; i++) {// i=1 이건 1부터 i<=5 5번까지만 반복한다는 말. i++은 증감, 하나를 증가시킴
			System.out.println("hello");
		}
	}

}
