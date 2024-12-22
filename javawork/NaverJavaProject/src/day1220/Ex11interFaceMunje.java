package day1220;

import java.util.Scanner;

/*
 *12월 22일까지 종료하고자 했으나 보류
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

	@Override
	public void process() {
		// TODO Auto-generated method stub
		
		
	}
	
}

class List implements Command
{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		
	}
	
}

class Delete implements Command
{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		
	}
	
}

class Update implements Command
{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		int
	}
	
}

class Quit implements Command
{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Ex11interFaceMunje {
	
	public static void dbProcess(Command comm) {
		comm.process();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
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
		Loop:
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
				
				switch(input) 
				{
				case 1: 
				case 2: 
				case 3:
				case 4:
				case 5: break Loop;
				}
				
			}
	}

}


