package day1212;

public class Ex5Operator {
	public static void main(String[] args) {
		//항이 3개이고 조건 연산자라고 한다
		int x = 5, y = 13, max;
		
		max = x>y? x : y ;
		System.out.println("max = " + max);
		
		int z = 20;
		max = (x>y && x>z) ? x : (y>x && y>z) ? y : z;
		System.out.println("max = " + max);
		
		int score = 86;
		char grade;
		
		grade = (score >= 90) ? 'A' : (score >= 80) ? 'B' : (score >= 70) ? 'C' :
			(score >= 60) ? 'D' : 'F';
		System.out.println(score + "점은 " + grade + "학점입니다.");
		
		// 점수가 90 이상이면 Good 나머지는 try
		System.out.println(score + "점은 " + ( (score >= 90)? "Good" : "Try again") );
	}
}
