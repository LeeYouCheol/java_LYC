package day16;

public class Ex2_System_CurrentTimeMillis {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long sum = 0;
		for(int i = 1; i< 10000; i++) {
			sum += i;
			System.out.println(sum + " ");
		}
		long end = System.currentTimeMillis();
		
		System.out.println("1부터 10000까지 합 : " + sum);
		System.out.println("소요시간 : " +(end - start)/1000.0 + "초");
	}

}
