package day1218;

class Orange {
	public static final String MESSAGE = "happy";
	
	private String name;
	private int age;

	public void showData() {
		//일반 멤버 메서드는 this라는 인스턴스 변수를 가지고 있음
		//this.name 이런 식으로 접근 가능 (this는 경우에 따라 생략 가능)
		System.out.println("이름=" + this.name + ", 나이=" + this.age);
	}
	
	//값을 변경하기 위한 setter 메서드, 클래스에 같은 이름의 변수 있으면 반드시 this 붙이자
	public void setName(String name)
	{
		this.name = name; 
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}

public class Ex8Object {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("x=" + Orange.MESSAGE);
		
		Orange orange = new Orange();
		/*
		 
			Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
			The field Orange.name is not visible
			private 변수는 직접 접근이 불가
		*/
		//System.out.println("message=" + orange.name); 
		orange.showData(); //값을 별도로 주지 않으면 null로 지정됨
		System.out.println("값변경");
		orange.setName("클라");
		orange.setAge(20);
		orange.showData();
	}

}
