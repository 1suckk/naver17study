package day1220;
/*
 * 이럴 때는 굳이 추상클래스를 고집하기보다는
 * 인터페이스를 쓰는 편이 낫다
 */
abstract class Test1
{
	abstract public void play();
}

////////////////////////////////////////////
abstract class Test2 extends Test1
{
	//눈에는 안보여도 추상화된 play()가 상속이 되었다
	abstract public void job();
}

////////////////////////////////////////////
class Test3 extends Test2
{
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("놀아");
	}
	
	@Override
	public void job() {
		// TODO Auto-generated method stub
		System.out.println("일해");
	}
}

////////////////////////////////////////////
public class Ex8Abstract {
	
	public static void hello1(Test1 t1)
	{
		t1.play();
		System.out.println();
	}

	public static void hello2(Test2 t2)
	{
		t2.play();
		t2.job();
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hello1(new Test3()); // 놀아
		hello2(new Test3()); // 놀아 , 일해
	}
}
