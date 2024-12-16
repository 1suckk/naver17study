package day1216;

import java.util.Scanner;

public class Ex7LoopExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, result = 1;
		int n, fact = 1;
		int r; double area;
		int menu;
		
		Loop:
			while(true) 
			{
				System.out.println("===================================================");
				System.out.println("1. 지수승구하기  2. 팩토리얼 구하기 3.원의 넓이 구하기  4. 종료");
				System.out.println("===================================================");
				
				menu = sc.nextInt();
				
				switch(menu)
				{
				case 1:
					System.out.print("밑과 지수를 입력해 주세요: ");
					x = sc.nextInt();
					y = sc.nextInt();
					
					for (int i = 1; i <= y; i++) {
						result *= x;
					}
					System.out.println(x + "의 " + y + "승은 " + result + "입니다.");
					break;
				
				case 2:
					System.out.print("n!에 필요한 n을 입력해주세요: ");
					n = sc.nextInt();
					
					for (int i = n; i > 0; i--) {
						fact *= i;
					}
					
					System.out.println(n+ "!은 " + fact + "입니다.");
					break;
				case 3:
					System.out.print("반지름을 입력해주세요: ");
					r = sc.nextInt();
					area = (r*r*(Math.PI));
					
					System.out.printf("넓이는 %.2f입니다.", area);
					System.out.println();
					break;
				default:
					System.out.print("프로그램이 종료되었습니다.");
					break Loop;
				}
			}
	}
}
