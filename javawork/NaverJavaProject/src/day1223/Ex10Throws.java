package day1223;

import java.util.Scanner;

public class Ex10Throws {
	/*
	 * throws는 넘기는 역할을 한다.
	 * 
	 */
	public static void sum(String a, String b) throws NumberFormatException {
		int su1 = Integer.parseInt(a);
		int su2 = Integer.parseInt(b);
		int sum = su1 + su2;
		System.out.println(a + "+" + b + "=" + sum);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자1 입력");
		String s1 = sc.nextLine();
		System.out.println();
		System.out.println("숫자1 입력");
		String s2 = sc.nextLine();
		
		try
		{
		sum(s1, s2);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally 
		{
			System.out.println("정상종료");
		}
		
		System.out.println("정상종료");
	}
}
