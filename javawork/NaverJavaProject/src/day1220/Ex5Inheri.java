package day1220;
class Parent1
{
	public void process()
	{
		System.out.println("기본 작업을 합니다.");
	}
}
////////////////////////////////////////////
class My1 extends Parent1
{
	@Override
	public void process()
	{
		super.process();
		System.out.println("벽지 작업을 합니다.");
	}
}
////////////////////////////////////////////
class My2 extends Parent1
{
	@Override
	public void process()
	{
		super.process();
		System.out.println("바닥 작업을 합니다.");
	}
}
////////////////////////////////////////////
public class Ex5Inheri {
	
	public static void homeProcess(My1 my)
	{
		my.process();
	}
	
	public static void homeProcess2(My2 my)
	{
		my.process();
	}
	
	public static void homeProcessAll(Parent1 p)
	{
		p.process(); //p라는 것은 Parent1 외에도 Parent1의 상속자들이 해당됨
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		My1 my1 = new My1();
//		my1.process();
		
		My2 my2 = new My2();
//		my2.process();
		
		homeProcess(my1);
		homeProcess2(my2);
		
		//다형성처리
		Parent1 p1 = null;
		p1 = new My1();
		p1.process();
		
		p1 = new My2();
		p1.process();
		System.out.println("=".repeat(20));
		
		homeProcessAll(new My1());
		homeProcessAll(new My2());
	}
}
