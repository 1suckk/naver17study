package day1217;

public class Ex14StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"이중무", "고혁진", "김장영", "장성태", "전상훈", "허성민"};
		
		for(int i = 0; i<names.length; i++)
		{
			for (int j = i+1; j<names.length; j++)
			{
				if (names[i].compareTo(names[j])>0) //가나다순으로 앞의 것이 ㅎ에 가까운 경우 가나다순 정렬
				{
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		
		for (int i = 0; i<names.length; i++) {
			System.out.println(i + ":" + names[i]);
		}
	}

}
