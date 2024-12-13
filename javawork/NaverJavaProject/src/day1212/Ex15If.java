package day1212;

import java.util.Scanner;

public class Ex15If {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String sangpum;
		int su, dan, total, dctotal;
		
		System.out.println("상품명을 입력하시오.");
		sangpum = sc.next();
		System.out.println("수량을 입력하시오.");
		su = sc.nextInt();
		System.out.println("단가를 입력하시오.");
		dan = sc.nextInt();
		
		total = su*dan;
		dctotal = (int)(0.9*total);
		
		if (su >= 5) {
		System.out.println("상품명 : " + sangpum);
		System.out.println("수량 : " + su + "개");
		System.out.println("단가 : " + dan + "원");
		System.out.println("총금액 : " + dctotal + "원(할인됨)");
		}
		else {
			System.out.println("상품명 : " + sangpum);
			System.out.println("수량 : " + su + "개");
			System.out.println("단가 : " + dan + "원");
			System.out.println("총금액 : " + total + "원");
		}
	}
}
