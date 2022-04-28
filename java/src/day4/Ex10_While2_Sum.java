package day4;

public class Ex10_While2_Sum {

	public static void main(String[] args) {
		/* 1부터 5까지의 합을 구하는 코드를 While문을 이용하여 작성하세요.
		 * */
		int i = 1;
		int sum=0;
		while(i <= 5) {
			sum +=i;
			i++;
		}
		System.out.println(sum); //출력은 반복문 종료후.
				
	}

}
