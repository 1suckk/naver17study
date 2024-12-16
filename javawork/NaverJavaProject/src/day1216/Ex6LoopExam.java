package day1216;

import java.util.Scanner;

public class Ex6LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count1 = 0, count2 = 0, count3 = 0; //대문자, 소문자, 숫자의 개수를 저장하는 카운터
		
		System.out.println("문자열을 입력하세요.");
		String str = sc.nextLine();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			//char를 가지고 직접 적어도 된다
			//ascii code를 이용한 대문자, 소문자, 숫자 판별
			if ((65 <= (int)ch) && (90 >= (int)ch))
				count1++;
		
			else if ((97 <= (int)ch) && (122 >= (int)ch))
				count2++;
		
			else if ((48 <= (int)ch) && (57 >= (int)ch))
				count3++;
		}
		
		System.out.println("대문자의 개수: " + count1);
		System.out.println("소문자의 개수: " + count2);
		System.out.println("숫자의 개수: " + count3);
		
	}

}
