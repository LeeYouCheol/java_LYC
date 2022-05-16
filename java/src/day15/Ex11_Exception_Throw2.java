package day15;

public class Ex11_Exception_Throw2 {

	public static void main(String[] args) {
		

	}
	public static void throwException() throws Exception {
		/* 예외(Exception)클래스는 런타임예외 클래스의 부모 클래스이지 자식 클래스가 아니기 때문에
		 * 런타임 예외 클래스가 아니다. 
		 * => 예외는 런타임예외가 아니*/
		throw new Exception();
	}
	public static void throwException2() {
		/* 런타임 예외이기 때문에 throws를 적어도 되고 안적어도 된다. */
		throw new RuntimeException();
	}
}
