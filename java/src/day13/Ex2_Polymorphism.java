package day13;

public class Ex2_Polymorphism {

	public static void main(String[] args) {
		Controller controller[] = new Controller[3];
		controller[0] = new TvController();
		controller[1] = new RadioController();
		controller[2] = new TvController();
		
		controller[1].run();
		for(int i = 0; i<900; i++) {
			if(controller[1] instanceof RadioController) {
				RadioController tmp = (RadioController)controller[1];
				tmp.frequencyUp();
			}
			if(controller[i] instanceof TvController) {
				TvController tmp = (TvController)controller[1];
				tmp.channelUp();
			}
		}
		System.out.println("-------------------------");
		for(Controller tmp : controller) {
			printController(tmp);
			System.out.println("-------------------------");
		}
	}
public static void printController(Controller con) {
	con.print();
}
}
