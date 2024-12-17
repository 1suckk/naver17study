package day1217;

public class Ex5ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {1000, 100, 100, -100, 100};
		int max = data[0]; //순차 비교
		int min = data[0];
		
		for (int i = 1; i < data.length; i++)
		{
			if (max<data[i])
			{
				max = data[i];
			}
			
			if (min>data[i])
			{
				min = data[i];
			}
		}
		System.out.println("max=" + max);
		System.out.println("min=" + min);
	}

}
