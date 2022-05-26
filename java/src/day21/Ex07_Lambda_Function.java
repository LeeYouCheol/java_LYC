package day21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Ex07_Lambda_Function {

	public static void main(String[] args) {
		List<Student> list  = new ArrayList<Student>();
		list.add(new Student(1,1,1,100,90,80,"홍길동"));
		list.add(new Student(1,1,2,80,90,100,"임꺽정"));
		list.add(new Student(1,1,3,20,30,40,"둘리"));
		list.add(new Student(1,1,4,40,30,100,"고길동"));
		
		BiFunction<Student, String, Integer> f = (Student std, String subject) ->{
			if(subject.equals("국어"))	return std.getKor();
			if(subject.equals("영어"))	return std.getEng();
			if(subject.equals("수학"))	return std.getMath();	
			return 0;
		};
		
		System.out.println("학생들의 국어 총점 : " + sum(list, "국어", f));
		System.out.println("학생들의 국어 총점 : " + sum(list, "영어", f));
		System.out.println("학생들의 국어 총점 : " + sum(list, "수학", f));
	
	}
	public static int sum(List<Student>list, String subject, BiFunction<Student, String, Integer> function) {
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += function.apply(list.get(i), subject);
		}
		return sum;
	}

}
class Student{
	private int grade, classNum, num, kor, eng, math;
	private String naame;
	
	
	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", kor=" + kor + ", eng=" + eng
				+ ", math=" + math + ", naame=" + naame + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + eng;
		result = prime * result + grade;
		result = prime * result + kor;
		result = prime * result + math;
		result = prime * result + ((naame == null) ? 0 : naame.hashCode());
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
		if (eng != other.eng)
			return false;
		if (grade != other.grade)
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (naame == null) {
			if (other.naame != null)
				return false;
		} else if (!naame.equals(other.naame))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	public Student(int grade, int classNum, int num, int kor, int eng, int math, String naame) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.naame = naame;
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
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getNaame() {
		return naame;
	}
	public void setNaame(String naame) {
		this.naame = naame;
	}
	
	
}