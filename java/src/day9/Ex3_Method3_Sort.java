package day9;

import java.util.Scanner;

public class Ex3_Method3_Sort {

	public static void main(String[] args) {
		/* 5명의 학생의 성적을 입력받아 오름차순으로 출력하는 코드를 작성하세요.
		 * 입력받은 성적은 배열에 저장해야합니다.
		 * */
		//스캐너로 성적 입력 받음
		Scanner scan = new Scanner(System.in);
		System.out.print("성적을 입력하세요(5명) : ");
		int score[] = inputCreateArray(scan, 5);
	
		//반복문을 이용하여 성적을 정렬
		bubbleSort(score, false);
		
		printArray(score);
		
		scan.close();
	}
	/* 기능 : 정수형 배열이 주어졌을 때, 주어진 배열의 값을 콘솔에 출력하는 메소드
	 * 매개변수 : 정수형 배열 => int num[]
	 * 리턴타입 : 없음 => void 
	 * 메소드명 : printArray
	 * */
	public static void printArray(int num[]) {
		if(num == null || num.length == 0) {
			System.out.println("출력할 배열이 없습니다.");
			return ;
		}
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
	/* 기능 : 주어진 Scanner를 이용하여 콘솔에서 정수를 n개 입력받아 배열로 반환하는 메소드
	 * 매개변수 : Scanner, 입력받을 정수의 개수 => Scanner scan, int n
	 * 리턴타입 : 정수 배열 => int []
	 * 메소드명 : inputCreateArray 
	 * */
	public static int[] inputCreateArray(Scanner scan, int n) {
		if( n <= 0) {
			return null;
		}
		int arr[] = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		return arr;
	}
	/* 기능 : 장스 베열이 주어지면 오름차순 또는 내림차순으로 정렬하는 메소드
	 * 매개변수 : int score[], boolean asc(up은 오름차순이다. 그런데 참 거짓을 판별하는것이니. 참이면 오름차순. 거짓이면 내림차순이된다.)
	 * 리턴타입 : 없음 => void
	 * 메소드명 : bubbleSort
	 * */
	public static void bubbleSort(int arr[], boolean asc) {
		if(arr == null) {
			return;
		}
		for(int i = 0; i<arr.length-1; i++) {
			for(int j = 0; j<arr.length-1; j++) { 
				//오름차순인 경우
				if(asc && arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}//내림차순인 경우
				else if(!asc && arr[j] < arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
}
	

	


