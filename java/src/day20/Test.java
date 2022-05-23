package day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		int menu = -1;
		String fileName;
		while(menu != 4) {
			System.out.println("-------------------------");
			System.out.println("1. 파일저장");
			System.out.println("2. 파일확인");
			System.out.println("3. 파일검색");
			System.out.println("4. 프로그램 종료");
			System.out.println("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
			System.out.println("-------------------------");
			
			switch(menu) {
			case 1:
				System.out.println("파일명 : ");
				fileName = scan.next();
				list.add(fileName);
				System.out.println("파일 저장이 완료되었습니다.");
				break;
			case 2:
				System.out.println(list);
				break;
			case 3:
				System.out.println("검색어 : ");
				String str = scan.next();
				int index = list.indexOf(str);
				for(String tmp : list) {
					if(tmp.contains(str)) {//list.contains는 문자열이 완전히 일치해야 한다.
						System.out.println(tmp);
					}
				}
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		}

	}
}
