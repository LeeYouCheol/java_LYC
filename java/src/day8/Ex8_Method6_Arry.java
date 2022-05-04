package day8;

public class Ex8_Method6_Arry {

	public static void main(String[] args) {
		int arr[] = new int[] {1,2,3,4,5};
		printArray(arr);
		int n = 7;
		int num = 3;
		printArray(arr);
		System.out.println(contains(arr,num));
		System.out.println(contains(arr, n, num));

	}
	/* 기능 : 정수형 배열이 주어졌을 때, 주어진 배열의 값을 콘솔에 출력하는 메소드
	 * 매개변수 : 정수형 배열 => 
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printArray
	 * */
	public static void printArray(int num[]) {
		if(num == null || num.length == 0) {
			System.out.println("출력할 배열이 없습니다.");
			return; //메소드를 종료하는역할
		}
		
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
	/* 기능 : 정수형 배열에 정수 num가 있는지 없는지 알려주는 메소드
	 * 매개변수 : 정수형 배열, 정수 num => int arr[], int num
	 * 리턴타입 : boolean
	 * 메소드명 : contains
	 * */
	public static boolean contains(int arr[], int num) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == num) {
				count++;
			}
		}if(count == 0) {
			return false;
		}else {
			return true;
		}
	}
	/* 기능 : 정수형 배열에서 처음부터 n개중에서 정수 num가 있는지 없는지 알려주는 메소드
	 * 매개변수 : 정수형 배열, 정수 => int arr[], int num
	 * 리턴타입 : bloolean
	 * 메소드명 : contains
	 * */
	public static boolean contains(int arr[], int n, int num) {
		//배열이 잘못되거나 비교 갯수가 잘못되서 비교팔 필요가 없는 경우
		if(arr==null || arr.length ==0 || n <= 0) {
			return false;
		}
		if(arr.length < n) { 
			n = arr.length; //배열의 범위보다 n이 큰경우 n을 배열의 크기와 강제로 맞춰줌
			// 또는 return flase; 로 해줘도된다.
		}
		for(int i = 0; i<n; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
}