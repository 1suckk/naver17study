package day1213;

public class Ex10For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=1; i<=5; i++) //i 값 자체가 계속 바뀌지 않으면 안됨
			System.out.print(i + " ");
		System.out.println();
		
		for(int i=1; i<=10; i+=2) 
			System.out.print(i + " ");
		System.out.println();
		
		for(int i=10; i>=1; i--) 
			System.out.print(i + " ");
		System.out.println();
		
		for(int i=10; i<=100; i+=10) 
			System.out.print(i + " ");
		System.out.println();
		System.out.println("break");
		
		for(int i=1; i<=10; i++) {
			System.out.print(i + " ");
			if (i==5)
				break;
		}
		System.out.println();
	}	
}
