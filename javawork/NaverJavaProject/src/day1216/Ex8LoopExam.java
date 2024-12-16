package day1216;

import java.util.Scanner;

public class Ex8LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names;
		int kimCount = 0, leeCount = 0, otherCount = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("이름을 입력하세요 (종료할거면 {끝}을 입력하세요.)");
			names = sc.nextLine();
			if (names.equals("끝"))
				break; //아래의 출력창으로 바로 나간다.
			if (names.startsWith("김"))
				kimCount++;
			else if (names.startsWith("이"))
				leeCount++;
			else
				otherCount++;
			}
				
		System.out.println("김씨는 총 " + kimCount + "명입니다.");
		System.out.println("이씨는 총 " + leeCount + "명입니다.");
		System.out.print("그 외는 총 " + otherCount + "명입니다.");			
	}
}
