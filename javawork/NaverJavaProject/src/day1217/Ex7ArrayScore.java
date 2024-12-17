package day1217;

import java.util.Scanner;

public class Ex7ArrayScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		
		int num;
		String[] names;
		int[] score, rank;
		int total = 0;
		double avg;
		
		System.out.println("인원수를 입력하세요 : ");
		num = Integer.parseInt(sc.nextLine());
		score = new int[num];
		rank = new int[num];
		names = new String[num];
		
		//이름, 점수 입력
		for (int i = 0; i < num; i++) {
			System.out.println(i+1 + "번지 이름입력");
			names[i] = sc.nextLine();
			System.out.println("점수입력");
			score[i] = Integer.parseInt(sc.nextLine());
			
			total += score[i];
		}
		
		//평균 구하기
		avg = (double)total/num;
		
		//등수 구하기
		for (int i = 0; i < score.length; i++)
		{
			rank[i] = 1;
			for (int j = 0; j < score.length; j++) 
			{
				if (score[i] < score[j])
					rank[i]++;
			}
		}
		
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("=".repeat(40));
		for (int i = 0; i < num; i++) {
			System.out.println(i+1 + "\t"+ names[i] + "\t" + score[i] + "\t" + rank[i]);
		}
		System.out.println("=".repeat(40));
		System.out.println("총점: " + total + "\t\t평균: " + avg);
	}

}
