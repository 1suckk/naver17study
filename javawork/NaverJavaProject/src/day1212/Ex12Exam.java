package day1212;

import java.util.Scanner;

public class Ex12Exam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum;
		float avg; //평균은 소수점 보완해서 반영
		String grade, passOrFail;
		
		System.out.println("성명을 입력하세요.");
		String name = sc.next();
		
		System.out.println("java 점수를 입력하세요.");
		int javaScore = sc.nextInt();
		
		System.out.println("html 점수를 입력하세요.");
		int htmlScore = sc.nextInt();
		
		System.out.println("spring 점수를 입력하세요.");
		int springScore = sc.nextInt();
		
		sum = javaScore + htmlScore + springScore;
		avg = (int)(sum/3);
		grade =
		(avg >= 90) ? "우등장학생" :
		(avg >= 80) ? "50프로장학금": "노력";
		
		passOrFail = 
		((javaScore >= 50) & (htmlScore >= 50) & (springScore >= 50) & (avg >= 70)) ? "합격입니다": 
		"불합격입니다";
		
		System.out.println("자바 점수: " + javaScore);
		System.out.println("html 점수: " + htmlScore);
		System.out.println("스프링 점수: " + springScore);
		System.out.println("총점: " + sum);
		System.out.printf("평균: %5.1f점\n", avg); //C언어 외의 자바에서도 사용 가능함
		System.out.println("등급: " + grade);
		System.out.println("합격 여부: " + passOrFail);
	}
}