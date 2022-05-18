package day17;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ex04_Date {

	public static void main(String[] args) {
		// new Date()는 실생 사간을 기준으로 날자 객체를 생성
		Date date = new Date();
		System.out.println(date);
		
		//new Date(num)은 1970년 1월 1일 00:00:00를 기준으로 num밀리 세컨드가 흐른 날짜 객체를 생성
		Date date2 = new Date(1000);
		System.out.println(date2);
		//yyyy-mm-dd hh:mm:ss
		//Date클래스의 객체를 원하는 포맷의 문자열로 바꾸는 예제
		
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		String strDate = format.format(date);
		System.out.println(strDate);
		
		//문자열을 Date클래의 객체로 바꾸는 예제
		Date date3;
		try {
			date3 = format.parse(strDate);
			System.out.println(date3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
