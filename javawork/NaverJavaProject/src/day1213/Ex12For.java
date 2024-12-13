package day1213;

import java.util.Scanner;

public class Ex12For {
	
	public static void main(String[] args) {
		/*for 문을 사용하며
		인원은 5명 입력
		출력은 40세 초과 48세 미만
		그리고 평균 나이*/
		
		int i, n = 0, sum = 0, count = 0;
		double avg;
		
		Scanner sc = new Scanner(System.in);
		
		for (i = 1; i <= 5; i++) {
			System.out.print(i + "번째 인원의 나이를 적으시오: ");
			int age = sc.nextInt();
			sum += age;
			/*sc.nextInt()는 for 문 내에서 반복 사용하지 말 것,
			엔터를 해도 다음 인원의 나이로 넘어갈 수 없는 현상 발생 */
			
			if (age > 40 && age < 48)
                count++;
		}
		
		avg = (double)sum / 5;
		
		
		
		System.out.println("Greater than 40 and less than 48 is " + count);
		System.out.println("Average is " + avg);
	}
}
