package day1213;

import java.util.Scanner;

public class Ex13For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int i, n = 0, sum = 0; 
		double avg;
		
		n = sc.nextInt();
		
		for (i = 0; i <= n; i++) 
		{
			sum += i;
		}
		
		
		System.out.println(sum);
	}

}
