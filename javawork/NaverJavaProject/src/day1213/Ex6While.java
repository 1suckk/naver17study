package day1213;

public class Ex6While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 65;
		while(a<=90) {
			System.out.print((char)a++);
		}
		System.out.println();
		
		//do-while문을 이용해서 a ~ z 까지 출력하시오.
		char b = 'a';
		do { System.out.print(b++); } while( (int)b <= 122 );
		System.out.println();
		
		int n = 0;
		while (n<=10) {
			n++;
			if (n%2 == 0)
				continue;
			System.out.printf("%3d", n);
		}
	}

}
