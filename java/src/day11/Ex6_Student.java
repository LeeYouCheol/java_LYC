package day11;
/*2. 필요한 클래스가 있는지 확인, 있으면 만듬
 * 	- 학생 클래스 : 이름, 학년, 반, 번호, 국어, 영어, 수학 성정
 * 	- 기능
 * 		- 학생 정보를 출력
 * 		- 학년, 반, 번호가 주어졌을 때 일치하는지 확인하는 기능
 * 		- 주어진 이름, 국어, 영어, 수학을 수정하는 기능
 * 	- 생성자 : 이름, 학년, 반, 번호, 국어, 영어, 수학 성적이 주어졌을 때 초기화 하는 생성자*/
public class Ex6_Student {
	private String name;
	private int grade;
	private int classNumber;
	private int number;
	private double kor;
	private double eng;
	private double math;
	
	public void print() {
		System.out.println("===============================");
		System.out.println(name + grade + "학년 " + classNumber + "반 " + number + "번 ");
		System.out.println(" 국어 : " + kor + " 영어 : " + eng + " 수학 : " + math);
		System.out.println("===============================");
	}
	/* 기능 : 학년, 반, 번호가 주어졌을때 일치하는지 확인하는 메소드
	 * 매개변수 : 학년, 반, 번호 => int grade, int classNumber, int num
	 * 리턴타입 : boolean
	 * 메소드명 : equal
	 * */
	public boolean equal(int grade, int classNumber, int number) {
		if(this.grade != grade) {
			return false;
		}if(this.classNumber != classNumber) {
			return false;
		}if(this.number != number) {
			return false;
		}
		return true;
	}
	/* 기능 : 주어진 이름, 국어, 영어, 수학점수로 수정하는 메소드
	 * 매개변수 : 이름, 국영수 성적 => double kor, double eng, double math
	 * 리턴타입 : void
	 * 메소드명 : modify
	 * */
	public void modify(String name, double kor, double eng, double math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public Ex6_Student(String name, int grade, int classNumber, int number, double kor, double eng, double math) {
		this.name = name;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
}
