package day1217;

import java.util.Scanner;

public class Ex10ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {2, 4, 5, 6, 9, 8, 1, 3, 7, 10};
		System.out.println("개수: " + data.length);
		int searchNum;
		boolean find;
		
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			find = false;
			System.out.println("검색할 숫자는?(종료시 0)");
			searchNum = sc.nextInt();
			if (searchNum==0) {
				System.out.println("종료");
				break;
			}
			
			for (int i = 0; i < data.length; i++)
			{
				if (searchNum == data[i]) 
				{
					find = true;
					System.out.println((i+1) + "번째에 있습니다.");
					break;
				}
			}

			if (!find)
				System.out.println("없는 숫자");
			
		}
		
	}

}
