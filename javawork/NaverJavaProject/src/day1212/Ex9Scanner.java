package day1212;

import java.util.Scanner;

public class Ex9Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//이름 키 몸무게 읽기
		String sang;
		int su, dan, total;
		System.out.println("상품명 입력");
		sang = sc.nextLine();
		System.out.println("수량 입력");
		su = sc.nextInt();
		System.out.println("단가 입력");
		dan = sc.nextInt();
		total = su >= 5 ? (int)(0.9*su*dan) : su*dan;
		System.out.println("상품명 : " + sang);
		System.out.println("수량 : " + su + "개");
		System.out.println("단가 : " + dan + "원");
		System.out.println("총금액 : " + total + "원" + (su<5 ? "" : "(할인됨)"));
	}
}
