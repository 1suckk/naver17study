package day1218;

class Apple {
	//접근지정자 생략시 default 
	static String message = "hello"; //변수
	static final String EMP = "비트캠프"; //상수
	String name = "캔디";
}

////////////////////////////////////////////

public class Ex7Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("message=" + Apple.message);
		System.out.println("EMP=" + Apple.EMP);
	
		Apple.message = "Happy Day!!";
		System.out.println("message=" + Apple.message);
		// Apple.EMP = "네이버클라우드"; // 상수이므로 변경이 적용 안됨
		//System.out.println("Apple의 name=" + Apple.name); //static 없으므로 인스턴스가 없으면 접근 불가
	
		//인스턴스 변수를 만들어서 캔디를 가져오도록 하자
		Apple a = new Apple();
		System.out.println("이름=" + a.name); //이렇게 외부에서 인스턴스 변수로 접근이 가능하다
		a.name = "클라";
		System.out.println("a의 이름=" + a.name); //캔디 외의 다른 이름 사용
		
		Apple b = new Apple();
		System.out.println("이름=" + b.name); //이렇게 외부에서 인스턴스 변수로 접근이 가능하다
		b.name = "우드";
		System.out.println("b의 이름=" + b.name); //우드 외의 다른 이름 사용
	}

}
