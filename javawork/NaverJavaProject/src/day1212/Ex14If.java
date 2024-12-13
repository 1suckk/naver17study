package day1212;

import java.util.Scanner;

public class Ex14If {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int score;
		char grade;
		
		System.out.println("점수를 입력해주세요.");
		score = sc.nextInt();
		
		//점수가 0~100 사이를 벗어나면 메서드 종료
		if (0 > score || score > 100)
		{
			System.out.println("점수가 값을 벗어남");
			return;
		}
			
		if (score >= 90)
			grade = 'A';
		else if (score >= 80)
			grade = 'B';
		else if (score >= 70)
			grade = 'C';
		else if (score >= 60)
			grade = 'D';
		else
			grade = 'F';
		
		System.out.printf("%d점의 학점은 %s입니다.\n", score, grade);
	}
}
