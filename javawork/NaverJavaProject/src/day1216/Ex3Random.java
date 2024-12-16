package day1216;

import java.util.Scanner;

public class Ex3Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int su, count, rnd;
		
		Exit:
			while(true)
			{
				rnd = (int)(Math.random() * 100) + 1;
				count = 0;
				
				while (true)
				{
					System.out.print(++count + "회: 1부터 100까지의 정수 중 하나를 예측해서 입력하세요: ");
					su = Integer.parseInt(sc.nextLine());
					
					if (rnd > su)
						System.out.println(su + "보다 큽니다.");
					else if (rnd < su)
						System.out.println(su + "보다 작습니다.");
					else {
						System.out.println("정답입니다.");
						System.out.println("게속하려면 y, 그만하려면 n");
						char ch = sc.nextLine().charAt(0);
						if (ch=='y' || ch=='Y') {
							System.out.println("새로운 난수를 발생합니다.");
							break;
						}
						else {
							break Exit; //n을 입력하면 레이블을 아예 나감
						}
					}
				}
			}
		
		System.out.println("프로그램을 종료합니다. ");
	}

}
