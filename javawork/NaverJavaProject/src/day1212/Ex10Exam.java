package day1212;

import java.util.Date;
import java.util.Scanner;

public class Ex10Exam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("년도 입력: ");
		int year = sc.nextInt();
		System.out.println("월 입력: ");
		int month = sc.nextInt();
		System.out.println("일 입력: ");
		int day = sc.nextInt();
		
		Date myDate = new Date(year - 1900, month - 1, day);
		
		int weekNum = myDate.getDay();
		
		String week = 
		(weekNum == 0) ? "일" : 
		(weekNum == 1) ? "월" :
		(weekNum == 2) ? "화" :
		(weekNum == 3) ? "수" :
		(weekNum == 4) ? "목" :
		(weekNum == 5) ? "금" :
		(weekNum == 6) ? "토" : "일";
		
		System.out.println(myDate.getYear() + 1900 + "년 " + myDate.getMonth()
		+ "월 " + myDate.getDate() + "일 " + week + "요일");
	}
}
