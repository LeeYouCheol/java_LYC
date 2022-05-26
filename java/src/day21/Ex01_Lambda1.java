package day21;

public class Ex01_Lambda1 {

	public static void main(String[] args) {
		// 람다식을 안쓰고 쓰레드 생성후 테스트
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("안녕ㅎ");
				
			}
		});
		
		//람다식을 이용하여 쓰레드 생성후 테스트
		th1.start();
		
		Thread th2 = new Thread(() -> System.out.println("Hi"));
		th2.start();
		
		Thread th3 = new Thread(() ->{
			System.out.println("Hello");
			});
		th3.start();
	}

}
