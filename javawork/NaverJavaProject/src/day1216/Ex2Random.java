package day1216;

import java.util.Scanner;

public class Ex2Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int su, n = 0, rnd;
		
		rnd = (int)(Math.random()*100)+1;
		while(true)
		{
			System.out.print(++n + "회: 1부터 100까지의 정수 중 하나를 예측해서 입력하세요: ");
			su = sc.nextInt();
			
			if (rnd > su)
				System.out.println(su + "보다 큽니다.");
			else if (rnd < su)
				System.out.println(su + "보다 작습니다.");
			else {
				System.out.println("정답입니다.");
				break;
			}
		}
	}

}
