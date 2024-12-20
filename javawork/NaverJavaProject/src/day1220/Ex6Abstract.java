package day1220;
/*
 * 추상클래스는 객체 생성을 할 수 없다
 * 자식 클래스로 하여금 반드시 구현하게 할 목적으로 추상메서드를 만든다
 * 만약 자식클래스가 추상메서드를 오버라이드 안했을경우 그 클래스도 추상화해야
 */
abstract class Parent2
{	
	/*부모가 process 에서 하는 일이 없을 경우
	*그렇다고 안만들면 자식클래스에서 오버라이드를 할 수 없다
	*이러면 미완으로 선언만 하고 abstract 메서드로 만든다
	*클래스와 메서드에 모두 abstract 를 붙여줘야 한다
	*/
	abstract public void process(); //추상메서드는 일반클래스에 멤버로 올 수 없다
	
	public void study() {
		System.out.println("자바 공부");
	};
}
 /////////////////////////////////////////////
class Your1 extends Parent2
{
	@Override
	public void process()
	{
		System.out.println("벽지 공사");
	}
	
	//Your1이 가진 메서드
	public void draw()
	{
		System.out.println("그림을 그린다.");
	}
}
/////////////////////////////////////////////
abstract class Your2 extends Parent2
{
	@Override
	public void process()
	{
		System.out.println("타일 공사");
	}
}
/////////////////////////////////////////////
public class Ex6Abstract {
	
	private static void yourProcess(Parent2 p)
	{
		p.process();
		p.study(); //부모가 가진 메소드는 호출 가능
		
		//p.draw(); //부모가 없기에오류 발생
		//p 에 Your2 가 생성되어 있는 경우에 오류가 발생
		((Your1)p).draw();//다운캐스팅후 호출하면 된다
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		yourProcess(new Your1());
		System.out.println("=".repeat(30));
		//yourProcess(new Your2());
		
		//yourProcess(new Parent2()); //오류:추상클래스는 new로 생성 불가
	}
}