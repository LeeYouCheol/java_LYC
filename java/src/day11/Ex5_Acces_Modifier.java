package day11;

import day11_1.Ex5_B;

public class Ex5_Acces_Modifier {

	public static void main(String[] args) {
		Ex5_A t1 = new Ex5_A();
		//public은 모두 사용 가능
		System.out.println(t1.num1);
		//default는 같은 패키지 내에서 사용가능
		System.out.println(t1.num2);
		//private는 내 클래스 내에서만 사용 가능
		//System.out.println(t1.num3); //에레 발생
		
		Ex5_B t2 = new Ex5_B();
		//public은 모두 사용가능
		System.out.println(t2.num1);
		//default는 같은 패키지 내에서 사용가능
		//System.out.println(t2.num2);//에러발생
		//private는 내 클래스 에서만 사용가능
		//System.out.println(t2.num3);//에러 발생
		//public int num =2; //지역변수에 접근제한자를 붙일수 없다.

	}
	
}
