package day1213;

import java.util.Scanner;

public class Ex7While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int score, total = 0, count = 0;
		double avg;
		
		while(true)
		{
			System.out.print("점수입력 (종료시 0): ");
			score = sc.nextInt();
			
			//1단계: 0 ~ 100 내의 값인지?
			if (score < 0 || score > 100) {
				System.out.println("\t잘못된 값입니다.");
//				continue; //다시 처음으로 간다	
			}
			
			//2단계: 끊어치기
			if(score==0)
				break;
			
			//정상 수치에 대한 카운트 값 추가와 점수 추가
			count++;
			total += score;
		}
		
		avg = (double)total/count;
		
		System.out.println("과목 수: " + count);
		System.out.println("점수 총합: " + total);
		System.out.println("점수 평균: " + avg);
	}

}
