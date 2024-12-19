package day1219;

class Orange
{
	private String name;
	private String color;
	private int age;
	
	//생성자 
	Orange()
	{
//		this.name = "이말자";
//		this.color = "노랑";
//		this.age = 30;
		this("이말자", "노랑");
	}
	
	
	
	
	//생성자가 다른 생성자를 호출 시 this() 사용
	Orange(String name, String color)
	{
		this.name = name;
		this.color = color;
		this.age = 30;
	}
	
	public void writeMember(int n) {
		if (n==1) {
			System.out.println("이름: " + name);
			System.out.println("선호색상: "+ color);
			System.out.println("연령: " + age);
			System.out.println("*".repeat(30));
		}else if (n==2) {
			System.out.println(name + "님은 " + color + " 색상을 좋아합니다");
		}else {
			System.out.println("1 or 2만 가능합니다.");
		}
		
		
	}
	
	public void writeMember() {
		System.out.println("name=" + name + ", color=" + color + 
							", age = " + age);
	}
}

public class Ex4Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orange a1 = new Orange();
		a1.writeMember();
		
		Orange a2 = new Orange("고민지", "파랑");
		a2.writeMember(1);
	}

}
