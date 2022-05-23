package day19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import day14.ConsoleProgram;


public class BoardManager implements ConsoleProgram{
	private Scanner scan;
	private List<Board> list;
	private int exitMenu = 4;
	private Board b;
	
	
	public BoardManager() {
		scan = new Scanner(System.in);
		list = new ArrayList<Board>();
	}
	public BoardManager(Scanner scan) {
		this.scan = scan;
		list = new ArrayList<Board>();
	}
	public BoardManager(Scanner scan, int size) {
		this.scan = scan;
		list = new ArrayList<Board>(size);
	}
	

	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("메뉴");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 확인");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 프로그램 종료");
		System.out.println("메뉴를 선택하세요 : ");
		int menu = scan.nextInt();
		return menu;
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1:
			//게시글 객체를 가져옴
			Board bd = inputBoard();
			//게시글 추가
			insertBoard(bd);
			break;
		case 2:
			printBoard();
			break;
		case 3:
			//객체 검색
			Board modBd = inputSearchBoard();
			//개체가 리스트에 있으면
			int index = list.indexOf(modBd);
			if(index >= 0) {
				inputAdditionBoard(modBd);
				//리스트에 설정
				list.set(index, modBd);
			}//없으면
			else {
				System.out.println("등록된 게시글이 아닙니다. 게시글을 등록해주세요.");
			}
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
			default:
				System.out.println("잘못된 메뉴입니다. 다시 선택하세요.");
		}
	}

	@Override
	public void run() {
		int menu;
		do {
			menu = selectMenu(scan);
			excute(menu);
		}while(menu != exitMenu);
	}
	//게시글을 입력받아 객체를 가져오는 메소드
	private Board inputBoard() {
		System.out.println("일반게시글과 공지를 선택하세요 : ");
		int num = scan.nextInt();
		String type = null;
		if(num == 1) {
			System.out.println("일반 게시글 작성.");
			type = "일반";
			System.out.print("제목 : ");
			String title = scan.next();
			System.out.println("작성자 : ");
			String writer = scan.next();
			System.out.println("내용 : ");
			String content = scan.next();
			return new Board(type, title, content, writer);
		}else if(num == 2) {
			System.out.println("공지 작성 : ");
			type = "공지";
			System.out.print("제목 : ");
			String title = scan.next();
			System.out.print("작성자 : ");
			String writer = scan.next();
			System.out.print("내용 : ");
			String content = scan.next();
			return new Board(type, title, content, writer);
			
		}else {
			System.out.println("잘못된 선택입니다.");
			return null;
		} 
	}
	//게시글을 추가하는 메소드
	private void insertBoard(Board bd) {
		if(bd == null) {
			return;
		}
		list.add(bd);
		list.sort(new Comparator<Board>() {
			@Override
			public int compare(Board o1, Board o2) {
				if(o1.getNum() != o2.getNum()) {
					return o2.getNum() - o1.getNum();
				}
				return 0;
			}
		});
		System.out.println("게시글이 등록되었습니다.");
	}
	//게시글을 출력하는 메소드
	private void printBoard() {
		if(list.size() == 0) {
			System.out.println("작성된 글이 없습니다.");
			return;
		}
		for(Board tmp : list) {
			System.out.println(tmp);
		}
		
		System.out.println("확인할 게시글을 번호를 선택하세요 : ");
		int num = scan.nextInt();
			//게시글 상세확인
		for() {
			//list에서 게시글을 가져옴
			Board tmp = list.get(num-1);
			//조회수 증가
			tmp.updateView();
			//가져온 게시글의 상세 내용을 확인 : detailPrint()를 호출
			tmp.detailPrint();
		}
	}
	//학생정보를 수정하는 메소드
	private Board inputSearchBoard() {
		try {
			printBoard();
			System.out.println("수정할 게시글 번호를 입력하세요 : ");
			int num = scan.nextInt();
			System.out.println("제목 : ");
			String title = scan.next();
			System.out.println("내용 : ");
			String content = scan.next();
			//리스트에서 num-1번지 게시글을 가져옴
			Board tmp = list.get(num-1);
			//가져온 게시글에 modify를 호출하여 게시글을 수정
			tmp.modify(title,  content);
			return new Board();
		}catch(Exception e) {
			System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			scan.nextLine();
			return null;
		}
	}
	//학생정보를 수정 하는 메소드
	private void inputAdditionBoard(Board bd) {
		if(bd == null) {
			System.out.println("게시글이 없습니다.");
			return;
		}
		try {
		System.out.println("수정할 정보를 입력하세요.");
		System.out.println("제목과 내용을 입력하세요 : ");
		String title = scan.next();
		String content = scan.next();
		bd.modify(title, content);
		}catch(Exception e) {
			System.out.println("제목과 내용이 잘못되었습니다. 다시 입력하세요.");
			scan.nextLine();
			return;
		}
	}
}
	


	

