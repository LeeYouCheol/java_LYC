package day16;

public class Ex12_StringBuilder {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder();//빈 문자열
		System.out.println(sb1);
		StringBuilder sb2 = new StringBuilder("Hello world");
		System.out.println(sb2);
		sb2.append("!");
		System.out.println(sb2);
		sb2.insert(0, "Hi. "); //0번지에 문자열 추가
		System.out.println(sb2);
		sb2.insert(sb2.length(), "?"); //insert를 이용하며 append 기능 구현
		System.out.println(sb2);
		sb2.delete(0, 2);//0번지부터 2번지 전까지 삭제
		System.out.println(sb2);
		sb2.replace(0, 0, "Hello"); //replace를 이용하여 0번지에 insert한 기능 구현
		System.out.println(sb2);
		System.out.println(sb2.reverse());
	}

}
