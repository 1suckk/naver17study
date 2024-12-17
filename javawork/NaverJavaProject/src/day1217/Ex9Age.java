package day1217;

public class Ex9Age {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[5];
		int[] data = {12, 34, 54, 20, 33, 59, 41, 44, 27, 21};
		System.out.println("인원수: " + data.length + "명");
		
		//10대부터 50대까지의 각각의 인원수를 구하시오
		//배열변수 이용해서 구하시오
		//10대 : 1명
		//20대 : 3명
		// ...
		//50대 : 2명
		
		//if, else if를 반복할 필요 없이 가능한 방법
		
		for (int age: data) {
			int ageGroup = age / 10 - 1;
			if (0 <= ageGroup && ageGroup <= 4) 
				num[ageGroup]++;
		}
		
		for (int i = 0; i < 5; i++)
		{
			System.out.println(i+1 + "0대 : " + num[i] + "명");
		}
		
		
	}

}
