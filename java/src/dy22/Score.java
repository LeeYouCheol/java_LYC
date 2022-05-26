package dy22;
//성적 관리를 위한 클래스
// 성적 추가시, 과목명, 중간성적, 기말성적, 수행평가성적, 학년 성적, 학기 성적
public class Score {
	//과목명, 중간, 기말, 수행평가, 학년, 학기
	private String name;
	//중간고사 성적 = midterm, finals = 기말고사, term = 학기
	private int midterm, finals, pa, grade, term;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMidterm() {
		return midterm;
	}

	public void setMidterm(int midterm) {
		if(midterm < 0 || midterm > 100) {
			new RuntimeException("중간고사 성적은 0~100사이의 정수를 입력하세요");
		}
		this.midterm = midterm;
	}

	public int getFinals() {
		return finals;
	}

	public void setFinals(int finals) {
		if(finals < 0 || finals > 100) {
			new RuntimeException("기말고사 성적은 0~100사이의 정수를 입력하세요");
		}
		this.finals = finals;
	}

	public int getPa() {
		return pa;
	}

	public void setPa(int pa) {
		if(pa < 0 || pa > 100) {
			new RuntimeException("수행평가 성적은 0~100사이의 정수를 입력하세요");
		}
		this.pa = pa;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		if(grade < 0 || grade > 100) {
			new RuntimeException("학년은 성적은 0~100사이의 정수를 입력하세요");
		}
		this.grade = grade;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		if(term < 0 || term > 100) {
			new RuntimeException("학기는 0~100사이의 정수를 입력하세요");
		}
		this.term = term;
	}

	public Score(int grade, int term, String name, int midterm, int finals, int pa) {
		this.name = name;
		setMidterm(midterm);
		setFinals(finals);
		setPa(pa);
		setGrade(grade);
		setTerm(term);
		//set으로 바꾼이유는 set에 예외처리를 다 했기때문
	}

	public Score(int grade, int term, String name) {
		setGrade(grade);
		setTerm(term);
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grade;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + term;
		return result;
	}
	//입력한 값과 일치하는지 여부를 판별하기위해서.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (grade != other.grade)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (term != other.term)
			return false;
		return true;
	}

	@Override
	public String toString() {
		double total = midterm * 0.4 + finals * 0.5 + pa * 0.1;
		return grade + "학년 " + term + "학기 " + name + "[중간 : " + midterm + ", 기말 : " + finals
				+ ", 수행 : " + pa + ", 총점 : " + total + "]";
	}
	private void modify() {
		setMidterm(midterm);
		setFinals(finals);
		setPa(pa);
	}
}
