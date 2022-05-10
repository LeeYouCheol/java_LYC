package day11;

import java.util.Scanner;

public class Ex1_Class_Student {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student st = new Student("", 1, 1, 1);
		
		int menu = -1;
		for( ; menu != 3; ) {
			System.out.println("메뉴");
			System.out.println("1. 학생정보 입력");
			System.out.println("2. 학생정보 출력");
			System.out.println("3. 프로그램 종료");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("학생 정보 입력 : ");
				int grade = scan.nextInt();
				int classNumber = scan.nextInt();
				int number = scan.nextInt();
				String name = scan.next();
				st = new Student(name, grade, classNumber, number);
				break;
			case 2:
				st.print();
				break;
			case 3:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못된 메뉴 입니다.");
			}
		}
		scan.close();
	}

}
class Student{
	String name;
	int grade;
	int classNumber;
	int number;
	
	void print() {
		System.out.println(grade + "학년 " + classNumber + "반 " + number + "번 " + name);
	}

	public Student(String name, int grade, int classNumber, int number) {
		this.name = name;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
	}
	
}