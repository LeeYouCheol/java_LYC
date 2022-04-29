package day5;

public class Ex10_NestedLoop4_Alphabet {

	public static void main(String[] args) {
		/* a
		 * ab
		 * abc
		 * ....
		 * abc...xyz
		 * */
		char i ='a';
		char j;
		for(i='a'; i<='z'; i++) {
			for(j='a'; j<=i; j++) {
				System.out.print(j);
			}System.out.println();
		}
				
	}

}
