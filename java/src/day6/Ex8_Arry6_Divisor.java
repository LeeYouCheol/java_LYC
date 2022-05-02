package day6;

public class Ex8_Arry6_Divisor {

	public static void main(String[] args) {
		/* 정수 num의 약수를 배열에 저장 한 후, 출력하는 코드를 작성하세요
		 * 약수는 최대 10개만 저장
		 * */
		
		int num = 1144000;
		int max = 10;
		int div[] = new int[max];
		int index = 0;
		for(int i = 1; i<=num; i++) {
			if(num % i == 0) {
				if(index < max) {
					div[index] = i;
					index++;
				}
			}
		}
		for(int i = 0; i<index; i++) {
			System.out.println(div[i] + " ");
		}
	}

}
