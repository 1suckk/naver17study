package day1216;

// continue loop 문은 for (int i = 1; i <= 3; i++)로 이동해서 다시 반복된다

public class Ex4ForLabel {
	public static void main(String[] args) {
		Loop:
			for (int i = 1; i <= 3; i++)
			{
				for (int j = 1; j <= 4; j++)
				{
					if (j==3)
						break Loop; // break 루프문은 for (int i = 1; i <= 3; i++) 로 이동하지 않고 바로 나간다
					
					System.out.println("i = " + i + ", j = " + j);
				}
			}
	}
}
