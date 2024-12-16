package day1213;

import java.util.Scanner;

public class Ex12For {
	
	public static void main(String[] args) {
		/*
		for 문을 사용하며
		인원은 5명 입력
		출력은 40세 이상과 40세 미만의 인원 각각과 그리고 평균 나이
		100세보다 많거나 0세보다 작으면 값에서 제외하고 다시 입력을 하게 하고 인원수에서는 제외를 해애 한다
		*/
		
		int i, n = 0, sum = 0, count1 = 0, count2 = 0;
		double avg;
		
		Scanner sc = new Scanner(System.in);
		
		for (i = 1; i <= 5; i++) {
			System.out.print(i + "번째 인원의 나이를 적으시오: ");
			int age = sc.nextInt();
			
			if (0 > age || age > 100) {
				System.out.println("0 ~ 100 범위 정수값만 입력하세요. ");
				i--;
				continue;
			}
			
			sum += age;
			/*sc.nextInt()는 for 문 내에서 반복 사용하지 말 것,
			엔터를 해도 다음 인원의 나이로 넘어갈 수 없는 현상 발생 */
			
			if (age >= 40)
                count1++;
			else if (age < 40)
				count2++;
			
		}
		
		avg = (double)sum / 5;
		
		
		
		System.out.println("Number of people whose age is Greater than and equal 40 is " + count1);
		System.out.println("Number of people whose age is less than 40 is " + count2);
		System.out.println("Average is " + avg);
	}
}
