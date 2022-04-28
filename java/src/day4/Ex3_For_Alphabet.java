package day4;

public class Ex3_For_Alphabet {

	public static void main(String[] args) {
		/* 반복문을 이용하여 a~z까지 출력하는 코드를 작성하세요.
		 * 
		 * 반복횟수 : 26
		 * 			i는 0부터 26보다 작을때까지 1씩 증가
		 * 실행문 : (char)('a'+i)를 출력
		 * 반복문 종료 후 : 없음
		 * */
		int i;
		
		for(i=0; i<26; i++) {
			System.out.print((char)('a'+i));//여기서 i는 int 타입이라 자동 타입변환이 되지않는다.
		}
		/* 다른방법
		 * 반복횟수 : i='a'부터 1씩증가
		 * 			i는 'a'부터 'z'까지 1씩증가
		 * 실행문 : i를 출력
		 * 반복문 종료 후 : 없음
		 * */
		System.out.println();
		char j;
		
		for(j='a'; j<='z'; j++) {
			System.out.print(j);
		}
	}

}
