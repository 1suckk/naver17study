package day1217;

public class Ex15ArrayRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//중복되지 않게 난수를 생성하라
		int[] numbers = new int[20];
		
		Loop:
		for (int i=0; i < numbers.length; i++)
		{
			numbers[i] = (int)(Math.random()*50) + 1;
			
			for (int j = 1; j < i; j++)
			{
				if (numbers[i] == numbers[j])
				{
					//해당 중복 번지를 제거하고 늘어나지 않은 상태로 다시 만들어야
					i--;
					//break;
					continue Loop;
				}
			}
		}
		
		for (int i = 0; i < numbers.length; i++)
		{
			for (int j = i+1; j < numbers.length; j++) 
			{
				if (numbers[i] > numbers[j])
				{
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}	
		}
		
		for (int i = 0; i < numbers.length; i++) 
		{
			System.out.println(i + " : " + numbers[i] + "\t");
			if (i+1 % 4 == 0) {
				System.out.println();
			}
		}
	}

}
