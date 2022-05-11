package day12;

public class Ex3_Override1 {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.bark();
		Dog d = new Dog();
		d.bark();
		Cat c = new Cat();
		c.bark();

	}

}
class Animal{
	public void bark() {
		System.out.println("짖다");
	}
}
class Dog extends Animal{
	public void bark() {
		super.bark();
		System.out.println("멍멍");
	}
}
class Cat extends Animal{
	public void bark() {
		System.out.println("--------------------");
		//super.메소드()는 첫번째줄이 아니어도 된다.
		super.bark();
		System.out.println("아옹");
		System.out.println("--------------------");
	}
}