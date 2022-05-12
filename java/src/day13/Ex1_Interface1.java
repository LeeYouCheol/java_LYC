package day13;

public class Ex1_Interface1 {

	public static void main(String[] args) {
		//Controller con = new Contrller(); 에러발생. 인터페이스로 객체를 생성할수 없다.
		RemoteController rc = new RemoteController(); //인터페이스를 이용해 객체를 만들때 자동 형변환
		rc.print();
		rc.run();
		rc.print();
		rc.stop();
		rc.print();
		
		Controller rc2= new Controller() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void stop() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void print() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}

