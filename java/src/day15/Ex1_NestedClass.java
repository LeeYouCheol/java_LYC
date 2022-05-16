package day15;

public class Ex1_NestedClass {

	public static void main(String[] args) {
		// a.num = 10; 이건 안된다. - 인스턴스 변수이어서 클래스를 통해 호출할 수 없다.
		A a = new A(); // A생성자 호출
		A.B b = a.new B(); // B생성자 호출
		
		A.num2 = 10; //static이 붙어서 바로 호출 가능.
		A.C c = new A.C(); // static이 붙어서 A객체 없이 호출가능.
		
		a.method(1);

	}

}

class A{
	public int num = 1;
	public static int num2;
	
	B b1 = new B();
	C c1 = new C();
	//static B b2 = new B;  인스턴스 클래스라 static을 붙일수 없다.
	static C c2 = new C();
	
	//인스턴스(객체) 멤버 클래스
	class B{
		int num = 2;
		public B() {
			System.out.println("B생성자");
			System.out.println(this.num);//B객체의 num를 호출
			System.out.println(A.this.num);//바깥 클래스 A 객체의 num를 호출
			}
	}
	//정적(클래스) 멤버 클래스
	static class C{
		public C() {
			System.out.println("C생성자");}
		}
	public void method(int num) {
		char ch ='a';
		//로컬 클래스에서 메소드의 매개변수와 지역변수를 사용할 수 있는데
		//이때 자동으로 final이 붙는다. 그래서 매개변수와 지역변수를 로컬클래스에서
		//수정할 수 없다.
		class D{
			public D() {
				System.out.println("D생성자");
				//ch = 'b'; 수정 불가
				//num = 2; 수정불가.
				}
			}
		D d = new D();
		ch = 'c'; // 로컬클래스 내에서만 final이 붙고 그렇지 않으면 수정가능.
	}
	public A() {
		System.out.println("A생성자");}
}