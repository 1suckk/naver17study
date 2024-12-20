package day1220;

class SuperObj1
{
	SuperObj1()
	{
		System.out.println("super 생성자");
	}

	SuperObj1(String msg) {
		System.out.println("super 메시지 받는 생성자");
	}
}
////////////////////////////////////////////
class SubObj1 extends SuperObj1
{
	SubObj1()
	{
		//부모의 생성자를 먼저 호출
		System.out.println("sub 생성자");
	}
	
	SubObj1(String msg)
	{
		super(msg); //생략 불가능함, 만약 생략 시 부모의 디폴트 생성자가 호출된다
		System.out.println("sub의 두번째 생성자");
	}
}
////////////////////////////////////////////
public class Ex1Inheri {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj1 sub1 = new SubObj1();
		SubObj1 sub2 = new SubObj1("Hello");
	}

}
