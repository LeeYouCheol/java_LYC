package day14;

import java.util.Scanner;

//이 클래스는 운영체제임. 어카운트매니저가 실행프로그램.
public class Ex1_AccountBookMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountBookManager accountBookManager = new AccountBookManager(scan);
		accountBookManager.run();
		scan.close();
	}

}
