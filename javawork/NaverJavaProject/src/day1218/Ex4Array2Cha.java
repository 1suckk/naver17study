package day1218;

public class Ex4Array2Cha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2차원 배열의 선언 시 초기값 지정
		int[][] arr1 = {{54, 65, 76},
						{12, 54, 86},
						{23, 54, 85}};
		
		System.out.println("행 갯수" + arr1.length);
		System.out.println("0번 행의 열 갯수: " + arr1[0].length);
		System.out.println("1번 행의 열 갯수: " + arr1[1].length);
		System.out.println("2번 행의 열 갯수: " + arr1[2].length);
		
		// 2차원 구조로 출력
		for (int i = 0; i < arr1.length; i++)
		{
			for (int j =0; j < arr1[i].length; j++)
			{
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
