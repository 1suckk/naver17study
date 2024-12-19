package day1219;

public class Ex6VarArgs {
	
	public static void writeColor(String color1) {
		System.out.println("color1= " + color1);
	}
	
	public static void writeColor(String color1, String color2) {
		System.out.println("color1= " + color1 + "color2= " + color2);
	}
	
	public static void writeColor(String color1, String color2, String color3) {
		System.out.println("color1= " + color1 + "color2= " + color2 + "color3= " + color3);
	}
	
	public static void writename(String ... name) //...은 배열 타입으로 입력받음
	{
		System.out.println("name의 length: " + name.length);
		if (name.length == 0)
			System.out.println("멤버가 없습니다.");
		else {
			System.out.println("** 멤버 목록 **");
			for (String n : name) 
				System.out.println("\t" + n);
			System.out.println("=".repeat(20));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//parameter 가 4개 이상부터는 오류 발생
		writeColor("red");
		writeColor("red", "green");
		writeColor("red", "green", "blue");
		
		System.out.println("varargs 기능을 확인해보자");
		writename("채원석");
		writename("채원석", "최원석");
		writename("채원석", "최원석", "채원석", "최원석");
		writename();
	}

}
