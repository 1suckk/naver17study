package day1218;

public class Ex6Object {
	//스태틱 변수는 인스턴스 없이도 접근이 가능하다.
	//당연히 this 도 없다.
	
	static int x = 10;
	static int y = 20; 
	
	//메서드도 스태틱으로 만들어보자
	private static void showTitle() {
		System.out.println("클래스 공부중");
		System.out.println("스태틱 변수는 접근 가능:" + x + y); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("x=" + Ex6Object.x); 
		System.out.println("x=" + x); //같은 클래스일때는 스태틱 변수 앞의 클래스명을 굳이 안써도 된다
	
		//x+y 구해보자
		int sum = x + y;
		System.out.println("sum=" + sum);
		
		//스태틱 메서드 호출
		Ex6Object.showTitle();
		showTitle(); //여기서도 마찬가지로 앞의 클래스명을 제외해도 된다
	}

}
