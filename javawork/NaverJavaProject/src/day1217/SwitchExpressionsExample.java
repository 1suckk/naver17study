package day1217;

public class SwitchExpressionsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자바 12 이후부터 적용되는 사항
		char grade = 'B';
		
		switch(grade) {
			case 'A', 'a' -> { 
				System.out.println("우수 회원입니다.");
			}
			case 'B', 'b' -> {
				System.out.println("일반 회원입니다.");
			}
			default -> {
				System.out.println("");
			}
		}
	}

}
