package day1216;

import java.util.Random;

public class Ex1Random {
	
	public static void main(String[] args) {
		
		System.out.println("0.0 이상이면서 1.0보다 작은 값");
		for (int i = 1; i <= 5; i++) {
			System.out.print( Math.random() + " " ); // 0 ~ 9 까지의 범위
		}
		System.out.println();
		System.out.println();
		
		System.out.println("0 ~ 9 사이의 값");
		for (int i = 1; i <= 5; i++) {
			System.out.print( (int)(10*Math.random()) + " " ); // 0 ~ 9 까지의 범위
		}
		System.out.println();
		System.out.println();
		
		System.out.println("0 ~ 99 사이의 값");
		for (int i = 1; i <= 5; i++) {
			System.out.print( (int)(100*Math.random()) + " " ); // 0 ~ 9 까지의 범위
		}
		System.out.println();
		System.out.println();
		
		System.out.println("1 ~ 100 사이의 값");
		for (int i = 1; i <= 5; i++) {
			System.out.print( (int)(100*Math.random() + 1) + " " ); // 0 ~ 9 까지의 범위
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Random 클래스를 이용해서 난수 구하기");
		Random r = new Random();
		System.out.println("0 ~ 9 사이의 값");
		for (int i = 1; i <= 5; i++) {
			int n = r.nextInt(10);
			System.out.print(n + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("1 ~ 10 사이의 값");
		for (int i = 1; i <= 5; i++) {
			int n = r.nextInt(10)+1;
			System.out.print(n + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("65(A) ~ 90(Z) 사이의 값");
		for (int i = 1; i <= 5; i++) {
			int n = r.nextInt(26) + 65;
			System.out.print((char)n + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("97(a) ~ 122(z) 사이의 값");
		for (int i = 1; i <= 5; i++) {
			int n = r.nextInt(26) + 97;
			System.out.print((char)n + " ");
		}
		System.out.println();
		System.out.println();
	}
}
