package day1212;

import java.util.Scanner;

public class Ex8Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sangpum;
		int price;
		
		// 둘 다 nextLine으로 짠다
		System.out.println("상품 가격 입력");
		price = sc.nextInt(); // 숫자만 읽고 엔터는 버퍼로 들어간다
		sc.nextLine(); // 버퍼의 엔터를 익어서 없앤다
		
		System.out.println("상품명 입력");
		sangpum = sc.nextLine(); // 버퍼의 엔터를 읽어온다
		
		System.out.println(sangpum + " 가격은 " + price + "원입니다.");
		System.out.println(sangpum + " 가격은 " + price + "원입니다.");
		System.out.println(sangpum + " 가격은 " + price + "원입니다.");
		
	}
}
