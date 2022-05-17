package day16;

public class Ex10_String_Split {

	public static void main(String[] args) {
		/*  - 문자열.split(정규표현식) : 문자열에 정규표현식과 일치하는 것들이 있으면 잘라서 배열로 만듬
		 *  - String arr[] = "abc,def,fgh".Split(',')를 하면
		 *  	String arr[] = {"abc", "def", "fgh"};가 저장된거와 같다.
		 * */
		String hobby = "독서, 음악감상, 영화보기, 운동";
		String hobbies[] = hobby.split(",");
		System.out.print("취미 : ");
		if(hobbies != null) {
			for(String tmp : hobbies) {
				System.out.print(tmp + " ");
			}
			System.out.println();
		}else {
			System.out.println("없음");
		}
		String num = String.valueOf(1); //.valueOf()는 숫자를 출력하지만 문자로 출력한다.
		System.out.println(num);
		num = "" + 1; //valueOf()와 같다. 표현이 다를뿐이다.
		System.out.println(num);

	}

}
