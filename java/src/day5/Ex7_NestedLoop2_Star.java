package day5;

public class Ex7_NestedLoop2_Star {

	public static void main(String[] args) {
		/* 아래와같이 출력되도록 코드를 작성하세요.
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 * */
		int num = 5;
		for(int i = 1; i<=num; i++) {
			for(int j = 1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		/* 아래와같이 출력되도록 코드를 작성하세요
		 *      * 
		 *     **
		 *    ***
		 *   ****
		 *  *****
		 * */
		
		for(int i = 1; i<=num; i++) { //총 출력 줄수
			for(int j = 1; j<=num-i; j++) {
				//공백 출력
				System.out.print(" ");
			}for(int j = 1; j<=i; j++) {
				//* 출력 : i개 출력
				System.out.print("*");
			}	//엔터 출력
				System.out.println();	
		}
		//다른방법
		for(int i = 1; i<=num; i++) { //총 출력 줄수
			for(int j = 1; j<=num; j++) {
					if(num - i >= j) {
						System.out.print(" ");
					}else {
						System.out.print("*");
					}
				}//엔터 출력
			System.out.println();
			}		
		
		/*      *
		 *     ***
		 *    *****
		 *   *******
		 *  *********
		 * */
		for(int i = 1; i <= num; i++) { //총 출력 줄수
			for(int j = 1; j <= num-i; j++) {
				//공백 출력
				System.out.print(" ");
			}for(int j = 1; j <= 2*i; j++) {
				//* 출력 : i개 출력
				System.out.print("*");
			}
			System.out.println();
		}
		/*      *		=1
		 *     ** *		=3
		 *    *** **		=5
		 *   **** ***	=7
		 *  ***** ****	=9
		 * */
				for(int i = 1; i <= num; i++) { //총 출력 줄수
					for(int j = 1; j <= num-i; j++) {
						//공백 출력
						System.out.print(" ");
					}for(int j = 1; j <= i; j++) {
						//* 출력 : i개 출력
						System.out.print("*");
					}	for(int j = 1; j<=i-1; j++) {
						//* 출력 : i개 출력
						System.out.print("*");
				}//엔터 출력
					System.out.println();	
	}
}
}


