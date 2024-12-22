package day1220;

class A
{
	public void method1()
	{
		System.out.println("A-method1()");
	}
}

class B extends A
{
	public void method1()
	{
		System.out.println("B-method1()");
	}
}

class C extends A
{
	public void method1()
	{
		System.out.println("C-method1()");
	}

	public void method2()
	{
		System.out.println("C-method2()");
	}
}

/*
 * 자바 12부터 instanceof를 쓰면서, 뒤에 곧바로 자식 클래스와
 * 인스턴스를 사용하는 것이 가능해진다 
 */
public class checkForInheri {
	public static void action(A a) {
		a.method1();
		if (a instanceof C c) {
			c.method2();    
		}
	}

	public static void main(String[] args) 
	{
		action(new A());
		action(new B());
		action(new C());
	}
} 
