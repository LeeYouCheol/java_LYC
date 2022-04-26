package day1;

public class Ex6_char {

	public static void main(String[] args) {
		/*문자는 ''안에 들어가는 한 글자
		 * 예외 : P.34
		 */
		char ch1 = '\t'; //Tab키 만큼 공백
		char ch2 = '\n'; //엔터
		char ch3 = '\r'; //커서를 앞으로 이동
		char ch4 = '\"'; //"문자
		char ch5 = '\''; //'문자
		char ch6 = '\\'; //\문자
		char ch7 = '\u0000'; //유니코드에 0에 해당하는 문자
		char ch8 = 'A'; //일반적인 경우
		
		int num = 65;
		char ch9 = (char)num;
		System.out.println(ch9); //유니코드 표에서 65는 A이다. 따라서 결과값이 A로 나온다.
		ch9 = (char)(num+1);
		System.out.println(ch9); //유니코드 표에서 66은 B이다. 따라서 결과값이 B로 나온다.
	}

}
