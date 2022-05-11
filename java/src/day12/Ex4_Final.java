package day12;

public class Ex4_Final {

	public static void main(String[] args) {
		FinalTest ft = new FinalTest();
		ft.print();

	}

}
// String은 final 클래스이기 때문에 상속이 불가능
//class KoreanString extnds String{}

class FinalTest{
	private final int max = 30;
	public void print() {
		//max = 20; //max 는 fianl이 붙어있어서 수정할수 없다.
		System.out.println(max);
	}
}
class FinalTestChild extends FinalTest{
	//print를 오버라이드 할 수 없다 => print()에 final이 붙어있기 때문
	//public final void print() {}
}