package day15;

public class Ex3_Exception_NullPointerException {

	public static void main(String[] args) {
		String str1 = "abc";
		System.out.println(str1.charAt(0));
		String str2 = null;
		//System.out.println(str2.charAt(0)); 경고표시, 예외발생
		//예외가 자주 발생하는 경우 1: 메소드를 호출하는 경우 메소드에서 null처리를 안하면
		//charAt(str2, 0); 경고표시x, 예외발생
		//예외가 자주 발생하는 경우 2 : 클래스를 이용하여 배열을 만드는 경우. 각 값에 객체를 생성후 기능 / 멤버변수를 호출해야하는데
		//객체생성을 잊고서 기능/멤버변수를 호출하는 경우
		String arr[] = new String[10];
		for(String tmp : arr) {
			System.out.println(tmp.charAt(0));
		}
	}
	public static void charAt(String str, int index) {
		System.out.println(str.charAt(index));
	}

}
