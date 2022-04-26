package day2;

public class Ex6_Logic {

	public static void main(String[] args) {
		// 결과값이 참 또는 거짓 => 조건식
		/*성적이 A학점인가? A학점의 기준은 90점이상이고 100점이하
		 * score가 90점 이상이고 score가 100점 이하이다.
		 * score가 90점이상 && score가 100점 이하
		 * score >= 90 && score <= 100
		 */
		int score1 = 89;
		System.out.println(score1 + "점은 A학점인가?" + (score1 >= 90 && score1 <= 100));
		int score2 = 90;
		System.out.println(score2 + "점은 A학점인가?" + (score2 >= 90 && score2 <= 100));
		
		/* 유효하지 않은 성적인가? 유요한 성적은 성적이 0점이상 100점이하
		 * 잘못된 성적은 성적이 0점 미만이거나 100점 초과
		 * 성적이 0점 미만 || 성적이 100점 초과
		 * score < 0 || score > 100
		 */
		int score3 = 105;
		System.out.println(score3 + "점은 잘못된 학점인가?" + (score3 < 0 || score3 > 100));
		
		/* 우요한 성적인가? 잘못된 성적의 반대
		 * 
		 */
		System.out.println(score3 + "점은 유요한 학점인가?" + !(score3 < 0 || score3 > 100));
		

	}

}
