package day1217;

import java.util.Scanner;

public class Ex11ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] member = {"강호동", "김태희", "유재석", "박명수",
				"정형돈", "노홍철", "김범수", "하석진", "주태영", "강영진", "주성훈"};
		String searchName;
		boolean find;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			find = false;
			System.out.println("검색할 이름은?(종료시 종료 입력)");
			searchName = sc.nextLine();
			
			if (searchName.equals("종료"))
			{ //== 쓰면 주소값 비교하는 것임
				System.out.println("종료");
				break;
			}
			
			for (int i = 0; i < member.length; i++) {
				if (member[i].equals(searchName)) { //== 쓰면 주소값 비교하는 것임
					find = true;
					System.out.println(i+1 + "번째에 " + "있습니다.");
					break;
				}
			}
			
			if (!find)
				System.out.println("없는 숫자입니다.");
		}
	
	}

}
