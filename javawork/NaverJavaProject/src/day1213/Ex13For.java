package day1213;

import java.util.Scanner;

public class Ex13For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, sum = 0; 
		int[] a = {80, 70, 60};
		double avg;
		
		for (i = 0; i <= 2; i++) 
		{
			sum += a[i];
		}
		
		avg = (double)sum / 3;
		System.out.println(avg);
	}

}
