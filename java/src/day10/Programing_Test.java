package day10;

import java.util.Scanner;

public class Programing_Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student str = new Student("name", 0, 0, 0);
		
		int menu = -1;
			while(true){
				System.out.println("메뉴");
				System.out.println("1. 학생 정보 입력");
				System.out.println("2. 학생 정보 출력");
				System.out.println("3. 프로그램 종료");
				menu = scan.nextInt();
				if(menu == 3) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}if(menu == 1) {
					System.out.print("이름 : ");
					String name = scan.next();
					System.out.println("학년 : ");
					int grade = scan.nextInt();
					System.out.println("학반 : ");
					int classNumber = scan.nextInt();
					System.out.println("학번 : ");
					int number = scan.nextInt();
					str = new Student(name, grade, classNumber, number);
					
				}
					if(menu == 2) {
						str.print();
						
					}
		}

	}

}
//클래스 생성
class Student{
	//필드
	String name;
	int grade;
	int classNumber;
	int number;
	//출력 메소드
	void print(){
		System.out.println("이름 " + name);
		System.out.println("학년 " + grade);
		System.out.println("학반 " + classNumber);
		System.out.println("번호 " + number);
	}
	//생성자
	public Student(String name, int grade, int classNumber, int number) {
		this.name = name;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
	}
}