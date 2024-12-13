package day1213;

public class Ex1Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		
		//각 케이스에 break를 걸어주지 않으면,
		//도착하는 가운데 모두 출력하게 된다.
		switch (n) {
		case 1:
			System.out.println("one"); break;
		case 2:
			System.out.println("two"); break;
		case 3:	
			System.out.println("three"); break;
		default:
			System.out.println("other number");
		}
	}

}