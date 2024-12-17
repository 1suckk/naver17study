package day1217;

public class Ex4ArrayString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str1;
		str1 = new String[4]; //객체인 경우 null 값이 들어감
		
		for (int i=0; i < str1.length; i++)
			System.out.println("str1[" + i + "] = " + str1[i]);
		
	
		str1[0] = "hello";
		str1[1] = "kitty";
		for (int i=0; i < str1.length; i++)
			System.out.println("str1[" + i + "] = " + str1[i]);
		System.out.println("=".repeat(30));
		
		String[] str2 = new String[] {"초록색", "분홍색", "노란색", "빨강색"};
		for (String s: str2)
			System.out.println(s);
			System.out.println("=".repeat(30));
		
		String[] str3 = new String[] {"적색", "분홍색", "노란색", "빨강색"};
		for (String s: str3)
			System.out.println(s);
			System.out.println("=".repeat(30));
	}
}
