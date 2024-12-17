package day1217;

public class Ex15ArrayRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[20];
		
		for (int i=0; i < numbers.length; i++)
		{
			numbers[i] = (int)(Math.random()*50) + 1;
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
