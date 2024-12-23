package day1223;

import java.util.Date;

public class Ex7Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 5, 6, 12};
		for (int i = 0; i <= arr.length; i++)
		{
			try {
			System.out.println(arr[i]);
			}catch (Exception e) {
				System.out.println("오류메시지: " + e.getMessage());
				e.printStackTrace();
			} //try-catch 문을 사용하면 오류가 나도 다음 문장을 실행할 수 있다
		}	
		
		System.out.println();
		Date date = null;
		try {
			int age = (date.getYear()+1900) - 2000;
			System.out.println("age: " + age);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류메시지: " + e.getMessage());
		}
		
		System.out.println("정상종료");
	}
}