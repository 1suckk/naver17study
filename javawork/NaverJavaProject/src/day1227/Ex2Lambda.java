package day1227;

/*
 * 자바에서의 함수형 프로그램인 람다 (Lambda) 표현식은 인터페이스를
 * 사용하는 익명 내부 클래스의 또다른 표현식이다
 * 단, 인터페이스는 단 하나의 추상 메서드만 가지고 있어야 한다
 * 
 * 람다는 그리스어 알파벳의 11번재 글자이다
 * 
 */
@FunctionalInterface //메서드가 하나인지 검증하는 어노테이션
interface Orange
{
	public void write(); //추상 메서드
//	public void study(); //메서드를 두개 추가 시 오류 발생
}

@FunctionalInterface
interface DataAdd
{
	public void add(int x, int y); //추상 메서드
}

public class Ex2Lambda {
	//우리가 알고 있는 익명 내부 클래스 형태로 Orange 를 구현해보자
	Orange or = new Orange() {
		
		@Override
		public void write() {
			// TODO Auto-generated method stub
			System.out.println("오렌지 익명 내부 클래스 형태");
		}
	};
	
	//위의 or 메서드를 아래의 람다식 메서드와 같이 간단하게 서술 가능
	public void lambdaMethod() {
		Orange orange1=() -> System.out.println("람다식 오렌지 메서드 호출");
		orange1.write();
		
		Orange orange2=() -> System.out.println("안녕하세요 람다씨");
		orange2.write();
		
		DataAdd add1 = (int x, int y) -> System.out.println(x+"+"+y+"="+(x+y));
		add1.add(10, 20);
		add1.add(3, 5);
	}
	
	public static void main(String[] args) {
		Ex2Lambda ex2 = new Ex2Lambda();
		ex2.or.write();
		ex2.lambdaMethod();
	}

}







