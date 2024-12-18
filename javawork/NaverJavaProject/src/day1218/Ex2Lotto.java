package day1218;

import java.util.Random;
import java.util.Scanner;

public class Ex2Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int money;
		int[] lotto = new int[6];
		Random r = new Random();
		
		System.out.print("금액을 입력하세요: ");
		money = sc.nextInt();
		
		if (money < 1000) {
			System.out.println("금액이 부족합니다.");
			return;	
		}
		
		for (int n = 0; n < (money / 1000); n++) {
			
			System.out.printf("%3d회 : ", n);
			
			for (int i = 0; i < 6; i++) {
				lotto[i] = r.nextInt(45) + 1;
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
			}
			
			//lotto[]를 각 회차마다 정렬
			for (int i = 0; i < lotto.length; i++) {
				for (int j = i + 1; j < lotto.length; j++) {
					if (lotto[i] > lotto[j]) {
						int temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
					}
				}
			}
			
			//출력
			for (int i = 0; i < lotto.length; i++) {
				System.out.printf("%4d", lotto[i]);
			}
			System.out.println();
		} //여기까지 최외곽 for 문
	}

}
