package day7;

public class Ex8_Arry_Multidimensional {

	public static void main(String[] args) {
		
		/* 각 반에는 최대 30명
		 * 1학년 1반의 국어 성적을 저장하기 위한 배열을 선언해 보세요.
		 * */
			int score1[] = new int[30];
			/* 1학년 전체 학생의 국어 성적을 저장하기 위한 배열을 선언해보세요. 각 학년은 최대 10반까지 있음*/
			int score2[] = new int[30*10];
			int score3[][] = new int[10][30];
			score1[10] = 100; //1반 학생의 11번 학생 성적
			score2[201] = 100; //7반 학생의 22번 학생 성적
			score3[6][21] = 100; //7반 학생의 22번 학생 성적
	}

}
