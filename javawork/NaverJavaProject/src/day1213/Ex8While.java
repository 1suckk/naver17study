package day1213;

import java.util.Scanner;

public class Ex8While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i = 0, n = 0, sum = 0;
		
		System.out.println("숫자를 입력하시오: ");
		n = sc.nextInt();
		
		while(i <= n) {
			sum += i;
			i++; //꼭 i를 추가해야 한다.
		}
		System.out.printf("%4d", sum);
	}

}
