package day1223;

import java.sql.Date;
import java.util.Scanner;

public class Ex8Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int birthYear, age;
		
		System.out.println("태어난 년도는?");
		
		try {
		birthYear = Integer.parseInt(sc.nextLine());
		
		Date date = null;
		age= (date.getYear()+1900) - birthYear;
		
		System.out.println("내 나이는 " + age + "세입니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("정상종료");
	}

}
