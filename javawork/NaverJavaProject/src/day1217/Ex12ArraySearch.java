package day1217;

import java.util.Scanner;

public class Ex12ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] member = {"강호동", "김태희", "유재석", "박명수",
				"정형돈", "노홍철", "김범수", "하석진", "주태영", "강영진", "주성훈"};
		String searchName;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("검색할 성씨는?(종료시 exit 입력)");
			searchName = sc.nextLine();
			
			if(searchName.equalsIgnoreCase("exit"))
			{
				System.out.println("종료");
				break;
			}
			
			for (int i = 0; i < member.length; i++) {
				if (member[i].startsWith(searchName) == true) {
					count++;
					System.out.println(i + ":" + member[i]);
				}
			}
			
			if(count == 0)
				System.out.println("\"" + searchName + "\" 씨 성을 가진 사람은 없습니다.");
			else
				System.out.println("총 " + count + "명이 검색");
		}
	}	
}
