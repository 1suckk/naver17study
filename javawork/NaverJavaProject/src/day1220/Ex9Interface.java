package day1220;
/*
 * interface 는 음식점의 메뉴판 -> 구현체는 없다
 * 소켓과 유사한 것이라고 생각하면 됨
 * 인터페이스는 추상메서드나 상수만이 올 수 있다
 * 이때 abstract final 생략
 */
interface InterA
{
	public void process(); 
}

class SubInter implements InterA
{
	//부모 인터페이스가 가진 메서드를 모두 오버라이딩 해야만 한다!!
	@Override
	public void process()
	{
		// TODO Auto-generated method stub
		System.out.println("sub 클래스의 process");
	}	
}

public class Ex9Interface {
	public static void process(InterA interA) {
		interA.process();	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterA interA = new SubInter();
		interA.process();
	
		//메서드 호출
		process(new SubInter());
	}
}