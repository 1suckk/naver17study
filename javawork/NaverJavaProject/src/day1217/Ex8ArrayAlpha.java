package day1217;

import java.util.Scanner;

public class Ex8ArrayAlpha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String message;
		int[] alpha = new int[26];
		
		System.out.print("영어 문장을 입력해 주세요: ");
		message = sc.nextLine();
		
		for (int i = 0; i < message.length(); i++) 
		{
			char ch = message.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				alpha[ch - 'A']++;
			else if (ch >= 'a' && ch <= 'z')
				alpha[ch - 'a']++;
		}
		
		for (int i = 0; i < alpha.length; i++)
		{
			System.out.print((char)('A'+i) + " : " + alpha[i] + "개\t");
			//한 줄에 4개씩 출력
			if ((i+1) % 4 == 0)
				System.out.println();
		}
	}

}
