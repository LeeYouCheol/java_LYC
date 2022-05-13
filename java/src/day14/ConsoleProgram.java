package day14;

import java.util.Scanner;

public interface ConsoleProgram {
	//메뉴를 출력후 선택하는 기능
	int selectMenu(Scanner scan);
	
	void excute(int menu);
	
	void run();
}
