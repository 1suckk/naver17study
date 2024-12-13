package day1213;

public class Ex5While {

	public static void main(String[] args) {
		// console 자체가 열리지 않음
		int n = 10;
		while (n < 10) {
			System.out.println("while loop");
		}

		//do-while
		do { System.out.println("do-while loop"); } while (n < 10);
	
		//while(true)는 무한루프가 돌게 된다.
		n = 1;
		while (n <= 10) {
			System.out.printf("%3d", ++n);
		}
		
		//
		n = 1;
		while (true) {
			System.out.printf("%3d", ++n);
			if (n > 10)
				break;
		}
		System.out.println(); //한 칸 개행해주는 효과
		
		//
		n = 1;
		do { System.out.printf("%3d", n++); } while (n <= 10);
	}
	
}
