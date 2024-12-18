package day1218;

import java.util.Scanner;

public class Ex1ArraySwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//필요 변수
		int inwon;
		int[] java, spring, sum, rank;
		String[] name, grade;
		double[] avg;
		
		//입력 시작
		System.out.println("인원 수는?");
		inwon = Integer.parseInt(sc.nextLine());
		
		//입력 인원에 따른 배열 할당
		java = new int[inwon];
		spring = new int[inwon];
		sum = new int[inwon];
		rank = new int[inwon];
		
		name = new String[inwon];
		grade = new String[inwon];
		
		avg  =new double[inwon];

		// 이름과 점수를 입력받는 for 문
		for (int i = 0; i < inwon; i++) {
			System.out.println(i + "번째 이름 입력: ");
			name[i] = sc.nextLine();
			
			System.out.println(i + "번째 자바 ,스프링 점수 입력: ");
			java[i] = Integer.parseInt(sc.nextLine());
			spring[i] = Integer.parseInt(sc.nextLine());
			
			sum[i] = java[i] + spring[i];
			avg[i] = sum[i] / 20;
			
			System.out.println();
		}
		
		//등수 매기는 구간
		for (int i = 0; i < inwon; i++) {
			rank[i] = 1;
			for (int j = 1; j < inwon; j++) {
				if (avg[i] < avg[j]) 
					rank[i]++;
			}
		}
		
		/*
		등급 구하기 
		90~100 : 우수장학생
		80~89 : 일반장학생
		*/
		for (int i = 0; i < inwon; i++) {
			switch((int)(avg[i]/10)) {
				case 10:
				case 9:
					grade[i] = "우수장학생";
					break;
				case 8:
					grade[i] = "일반장학생";
					break;
				default:
					grade[i] = "해당없음";
			}
		}
		
		System.out.println("번호\t이름\t자바\t스프링\t총점\t평균\t등수\t등급");
		System.out.println("=".repeat(60));
		
		for (int i = 0; i < inwon; i++) {
			System.out.println(i+1 + "\t" + name[i] + "\t" + java[i] + "\t"
					+ spring[i] + "\t" + sum[i] + "\t" + avg[i] + "\t" 
					+ rank[i] + "\t" + grade[i]);
		}
	}

}
