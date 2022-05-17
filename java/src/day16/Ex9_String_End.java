package day16;

public class Ex9_String_End {

	public static void main(String[] args) {
		/* 다음과 같이 파일이름이 주어졌을 때 파일이 이미지인지 아닌지 구별하는 코드를 작성하세요.
		 * 파일 확장자가 .jpg, .png, .bmp인 경우 이미지로 구별
		 * */
		String fileName = "testjpg.jpg";
		int index = fileName.lastIndexOf(".");
		//switch문 이용
		if(index != -1) {
			String endwith = fileName.substring(index+1); //점 다음을 기준으로 끝까지 살피려면 +1 을 한다.
			switch(endwith) {
			case "jpg", "bmp", "png":
				System.out.println(fileName + "은 이미지 입니다.");
				break;
				default:
					System.out.println(fileName+"은 이미지가 아닙니다.");
			}
		}else {
			System.out.println(fileName+"은 이미지가 아닙니다.");
		}
		//반복문을 이용하여 이미지 찾기.
		String img[] = {"jpg", "bmp", "png"};
		
		if(index != -1) {
			//substring은 찾아서 가져온다.
			String endwith = fileName.substring(index+1); //점 다음을 기준으로 끝까지 살피려면 +1 을 한다.
			int i;
			for(i = 0; i < img.length; i++) {
				if(img[i].equals(endwith)) {
					break;
				}
			}
			if(i <= img.length) {
				System.out.println(fileName+"은 이미지 입니다.");
			}else {
				System.out.println(fileName+"은 이미지가 아닙니다.");
			}
		}else {
			System.out.println(fileName+"은 이미지가 아닙니다.");
		}
		//substring을 이용하지 않고 이미지 찾기.
		
		int length = fileName.length();
		int i;
		for(i = 0; i < img.length; i++) {
			index = fileName.lastIndexOf(img[i]); //배열에서 하나씩 꺼내서 체크함
			if(index == length - img[i].length()) {
				break;
			}
		}
		if(i <= img.length) {
			System.out.println(fileName+"은 이미지 입니다.");
		}else {
			System.out.println(fileName+"은 이미지가 아닙니다.");
		}
		
		String search = ".jpg";
		int index1 = fileName.lastIndexOf(search);
		if(index1 >= 0) {
			System.out.println(fileName +"은 이미지 파일입니다.");
			index1 = fileName.lastIndexOf(search);
		}else {
			System.out.println(fileName+"은 이미지파일이 아닙니다.");
		}
	}
}
