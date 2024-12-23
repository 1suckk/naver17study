package day1220;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Command라는 인터페이스에 process() 추상메서드 추가
 * 
 * 인터페이스 Command를 구현하는 Insert(추가)
 * List(출력), Delete(삭제), Update(수정)
 * 클래스를 구현하시오
 */
interface Command
{
	public void process(); 
}

/*
 * 호출하는 메서드는
 * public static void dbProcess(Command comm)
 * {
 * 		comm.process(); // 다형성 처리가 되도록
 * 		//1번을 누르면 추가 2번을 누르면 출력....
 * }
 */ 
class Insert implements Command
{
	private ArrayList<Integer> list;
	private Scanner sc;
	
	public Insert(ArrayList<Integer> list, Scanner sc) {
		this.list = list;
		this.sc = sc;
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("추가할 정수를 입력하세요.");
		int num = Integer.parseInt(sc.nextLine());
		list.add(num);
		System.out.println("데이터가 추가되었습니다.");
	}	
}

class List implements Command
{
	private ArrayList<Integer> list;

	public List(ArrayList<Integer> list) {
		this.list = list;
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) 
			System.out.println(i + ": " + list.get(i));
	}	
}

class Delete implements Command
{
	private ArrayList<Integer> list;
	private Scanner sc;
	
	public Delete(ArrayList<Integer> list, Scanner sc) {
		this.list = list;
		this.sc = sc;
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 데이터의 인덱스를 입력하시오: ");
		int index = Integer.parseInt(sc.nextLine());
		if (index >= 0 && index < list.size()) {
			list.remove(index);
			System.out.println("데이터가 삭제되었습니다.");
		}
		else {
			System.out.println("유효하지 않은 인덱스입니다.");
		}
	}
}

class Update implements Command
{
	private ArrayList<Integer> list;
	private Scanner sc;
	
	public Update(ArrayList<Integer> list, Scanner sc) {
		this.list = list;
		this.sc = sc;
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		  System.out.print("수정할 데이터의 인덱스를 입력하세요: ");
	        int index = Integer.parseInt(sc.nextLine());
	        if (index >= 0 && index < list.size()) {
	            System.out.print("새로운 값을 입력하세요: ");
	            int newValue = Integer.parseInt(sc.nextLine());
	            list.set(index, newValue);
	            System.out.println("데이터가 수정되었습니다.");
	        } else {
	            System.out.println("유효하지 않은 인덱스입니다.");
	        }
	}
	
}

class Quit implements Command
{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("프로그램을 종료합니다.");
        System.exit(0);
	}
	
}

public class Ex11interFaceMunje {
	
	public static void dbProcess(Command comm) {
		comm.process();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> dataList = new ArrayList<>();
		
		/*
		 * 메인에서 while 문을 통해 다음과 같이 메뉴가 나오면
		 * 1. 추가 2. 출력 3. 삭제 4. 수정 5. 종료
		 * 
		 * 1번을 누르면 데이터가 추가되었습니다.
		 * 2번을 누르면 데이터를 출력합니다.
		 * 3번을 누르면 데이터가 삭제되었습니다.
		 * 4번을 누르면 데이터가 수정되었습니다.
		 * 5번을 누르면 프로그램을 종료합니다.
		 * 
		 * 이렇게 출력해서 보여줘야 한다
		 */

			while(true)
			{
				System.out.println("=".repeat(50));
				System.out.printf("1. 출력\t2. 추가\t3. 삭제\t4. 수정\t5. 종료\n");
				System.out.println("1번을 누르면 데이터가 추가되었습니다.");
				System.out.println("2번을 누르면 데이터를 출력합니다.");
				System.out.println("3번을 누르면 데이터가 삭제되었습니다.");
				System.out.println("4번을 누르면 데이터가 수정되었습니다.");
				System.out.println("5번을 누르면 프로그램을 종료합니다.");
				System.out.println("=".repeat(50));
				int input = Integer.parseInt(sc.nextLine());
				
				Command command;
				switch(input) 
				{
				case 1: 
					command = new List(dataList);
					break;
				case 2: 
					command = new Insert(dataList, sc);
					break;
				case 3:
					command = new Delete(dataList, sc);
					break;
				case 4:
					command = new Update(dataList, sc);
					break;
				case 5: 
					command = new Quit();
					break;
				default:
					System.out.println("잘못된 입력입니다. 1 ~ 5 중에서 입력하세요.");
					continue;
				}
				
				dbProcess(command);
			}
	}

}


