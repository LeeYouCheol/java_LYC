package day4;

public class EX4_Break1 {

	public static void main(String[] args) {
		
		for(int i =1; i<=5; i++) {
		System.out.println("Hello");
		if(i==3) {
		break;//브레이클 만나면 만난 위치까지만 작동하고 바로 반복문을 나온다.
		}
	}

}
}