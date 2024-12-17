package day1217;

import java.util.Scanner;

public class Ex1Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int inputYear, inputMonth, endDays, weekDays = 0;
		
		System.out.println("년도를 입력하세요.");
		inputYear = sc.nextInt();
		System.out.println("월을 입력하세요.");
		inputMonth = sc.nextInt();
		
		if (!(1 <= inputMonth && inputMonth <= 12)) {
			System.exit(0);
		}
		
		//윤년 확인
		boolean leapYear = (inputYear%4==0) && (inputYear % 100==0) || (inputYear%400==0);
		
		//해당 월이 몇일까지 있는지 구하기
		switch(inputMonth)
		{
			case 2:
				endDays = leapYear?29:28;
				break; 
			case 4: case 6: case 9: case 11:
				endDays = 30;
				break;
			default:
				endDays = 31;
		}
		
		//캘린더 출력 부분
		System.out.println("=".repeat(50));
		System.out.println("\t\t["+inputYear+"년 "+inputMonth+"월]");
		System.out.println("=".repeat(50));
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("=".repeat(50));
		
		for (int i = 1; i < weekDays; i++) 
			System.out.print("\t");
		
		//토요일 다음에는 개행
		for (int i = 1; i<=endDays; i++) 
		{
			++weekDays;
			System.out.printf("%2d\t", i);
			if (weekDays%7 == 0)
				System.out.println();
		}
	}

}
