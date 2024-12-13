package day1213;

import java.util.Scanner;

public class Ex3Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int year, month, days;
		
		System.out.println("년도와 월을 입력하세요.");
		year = sc.nextInt();
		month = sc.nextInt();
		
		boolean b = (year%4==0) && (year%100!=0) || (year%400==0);
		
		if(b) //if(b==true)와 동일, 반대는 if(!b)라고 쓴다.
			System.out.println(year + "년은 윤년입니다.");
		else
			System.out.println(year + "년은 윤년이 아닙니다.");
		
		switch(month) {
			case 2:
				days=b?29:28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			default:
				days = -1;
		}
		
		if (days == -1) {
			System.out.println("잘못된 범위입니다.");
		} else {
			System.out.printf("%d년 %d월은 %d일까지 있습니다.", year, month, days);
		}
	}

}
