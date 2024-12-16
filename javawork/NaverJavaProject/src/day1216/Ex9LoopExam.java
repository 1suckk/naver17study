package day1216;

public class Ex9LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("별로 트리 만들기");
		for (int i = 1; i <= 5; i++)
		{
			for (int j = 1; j <= 5; j++)
			{
				System.out.println("*".repeat(j));
			}
		}
		
		System.out.println("=으로 트리 만들기");
		for (int i = 1; i <= 5; i++)
		{
			for (int j = 1; j <= 5; j++)
			{
				System.out.println("=".repeat(j));
			}
		}
		
		System.out.println("역으로 별찍기");
		for (int i = 1; i <= 5; i++)
		{
			for (int j = 5; j >= 1; j--)
			{
				System.out.println("*".repeat(j));
			}
		}
	}

}
