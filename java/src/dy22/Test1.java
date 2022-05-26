package dy22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		/* 학생 1명의 성적을 관리하는 프로그램을 작성하세요
		 * 1. 성적 추가.
		 * 2. 성적 확인
		 * 3. 성적 수정
		 * 4. 프로그램 종료
		 * */
		Scanner scan = new Scanner(System.in);
		List<Student> list = new ArrayList<Student>();
		Student std = new Student("홍길동", 1, 1, 1);
		int menu = -1;
		while(menu != 4) {
			System.out.println("-------------------------------");
			System.out.println("1. 성적 추가");
			System.out.println("2. 성적 확인");
			System.out.println("3. 성적 수정");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
			System.out.println("--------------------------------");
			
			switch(menu) {
			case 1:
				System.out.println("추가할 학생의 학년을 입력하세요");
				System.out.print("학년 : ");
				int grade = scan.nextInt();
				if(grade == 1) {
					System.out.println("1학년 학생입니다. 학생 정보를 입력하세요.");
					System.out.println("반 , 번호, 이름 : ");
					int classNum = scan.nextInt();
					int num = scan.nextInt();
					String name = scan.next();
					System.out.print("성적을 입력하세요(국어, 영어, 수학)");
					int kor = scan.nextInt();
					int eng = scan.nextInt();
					int math = scan.nextInt();
					System.out.println("정보가 추가되었습니다.");
					list.add(std);
					}
					else if(grade == 2) {
						System.out.println("2학년 입니다.");
						System.out.println("반 , 번호, 이름 : ");
						int classNum = scan.nextInt();
						int num = scan.nextInt();
						String name = scan.next();
						System.out.print("성적을 입력하세요(국어, 영어, 수학)");
						int kor = scan.nextInt();
						int eng = scan.nextInt();
						int math = scan.nextInt();
						System.out.println("정보가 추가되었습니다.");
						list.add(std);
					}
					else if(grade == 3) {
						System.out.println("3학년 입니다.");
						System.out.println("반 , 번호, 이름 : ");
						int classNum = scan.nextInt();
						int num = scan.nextInt();
						String name = scan.next();
						System.out.print("성적을 입력하세요(국어, 영어, 수학)");
						int kor = scan.nextInt();
						int eng = scan.nextInt();
						int math = scan.nextInt();
						System.out.println("정보가 추가되었습니다.");
						list.add(std);
						}
				break;
			case 2:
				System.out.println(list);
				break;
			case 3:
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}

}

class Student{
	String name;
	int grade;
	int classNum;
	int num;
	int kor;
	int eng;
	int math;
	
	public Student(String name, int grade, int classNum, int num) {
		this.name = name;
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "이름 : " + name + ", 학년 : " + grade + ", 반 : " + classNum + ", 번호" + num + ", 국어성적 : " + kor
				+ ", 영어성적 : " + eng + ", 수학성적 : " + math;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
	
}