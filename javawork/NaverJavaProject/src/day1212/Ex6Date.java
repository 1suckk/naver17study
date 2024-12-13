package day1212;

import java.util.Date;

public class Ex6Date {
	
	public static void main(String[] args) {
		//Date class 사용해서 현재 날짜와 시간을 얻어보자
		Date today = new Date();
		
		int curYear = today.getYear() + 1900;
		int curMonth = today.getMonth() + 1;
		int curDate = today.getDate();
		
		System.out.println("현재년도: " + curYear);
		System.out.println("현재월: " + curMonth);
		System.out.println("현재일: " + curDate);
		
		System.out.println(today.getHours() + "시 " + today.getMinutes() + "분");
		
		// 요일 산출
		int weekDay = today.getDay();
		System.out.println(weekDay);
		
		String week = (weekDay == 0) ? "일요일" : 
            (weekDay == 1) ? "월요일" : 
            (weekDay == 2) ? "화요일" : 
            (weekDay == 3) ? "수요일" : 
            (weekDay == 4) ? "목요일" : 
            (weekDay == 5) ? "금요일" : "토요일";

		System.out.println("오늘의 요일은 " + week + "입니다.");
	}
}
