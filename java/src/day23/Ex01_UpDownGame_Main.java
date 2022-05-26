package day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_UpDownGame_Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Record> list = new ArrayList<Record>();
		list.add(new Record(1, "일길동"));
		list.add(new Record(7, "이길동"));
		list.add(new Record(8, "삼길동"));
		list.add(new Record(9, "사길동"));
		list.add(new Record(10, "오길동"));
		
		int min = 1;
		int max = 100;
		int num;
		int menu;
		do {
			System.out.println("-----------------------------");
			System.out.println("메뉴");
			System.out.println("1. 플레이");
			System.out.println("2. 기록확인");
			System.out.println("3. 종료");
			System.out.println("-----------------------------");
			System.out.println("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				int r = (int) (Math.random() * (max - min +1) + min);
				System.out.println("랜덤한 수 : " + r);
				int count = 0;
				do {
					System.out.println("1~100사이의 정수를 입력하세요 : ");
					num = scan.nextInt();
					count++;
					if(num < 1 || num > 100) {
						System.out.println("범위를 벗어났습니다");
						continue;
					}if(num > r) {
						System.out.println("DOWN");
					}else if(num < r) {
						System.out.println("UP");
					}
				}while(num != r);
				System.out.println("정답입니다.");
				
				int i;
				for(i = 0; i<list.size(); i++) {
					if(list.get(i).getCount() > count) {
						break;
					}
				}
				//list.size() < 5 : 저장된 기록이 5개 미만
				//i < list.size() : 저장된 기록이 5개 이상 중에 지금 플레이한 횟수가
				//					등수에 포함될때
				//					위에서 break가 동작하면 i는 list.size()보다 작고
				//					break가 동작 안하면 i는 list.size()
				if(list.size() < 5 || i < list.size()) {
					System.out.println("새로운 기록이 달성돼었습니다. 기록을 저장하세요.");
					System.out.println("이름");
					list.add(i, new Record(count, scan.next()));
					if(list.size() > 5) {
						list.remove(5);
					}
				}
					break;
			case 2:
				for(int j = 0; j < list.size(); j++) {
					System.out.println(j + 1 + ". " + list.get(j));
				}
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				break;
			}
		}while(menu != 3);
		
	}

}
class Record{
	private int count;
	String name;
	
	public Record(int count, String name) {
		this.count = count;
		this.name = name;
	}

	public int getCount() {//게터 쎄터는 비교할때 필요함
		return count;
	}

	@Override
	public String toString() {
		return "[ " + name + " : " + count + "]";
	}
	
	
}