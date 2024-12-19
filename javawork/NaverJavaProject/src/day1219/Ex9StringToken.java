package day1219;

import java.util.StringTokenizer;

public class Ex9StringToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "red|green|yellow|white|black";
		//String msg = "red,green,yellow,white,black";
//		String[] arr = msg.split("|");
//		for (String a:arr)
//		{
//			System.out.println(a);
//		}
		
		StringTokenizer st = new StringTokenizer(msg, "|");
		System.out.println("분리할 총 토큰 수 : " + st.countTokens());
		
		//countTokens 는 토큰을 읽을 때마다 갯수가 줄어든다
//		for (int i=0; i < st.countTokens(); i++) 
//		{
//			System.out.println(st.nextToken());
//		}
		
		//방법 1
		int count = st.countTokens();
		for (int i = 0; i < count; i++)
		{
			System.out.println(st.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer(msg, "|");
		
		//방법 2
		while(st2.hasMoreTokens())
		{
			System.out.println(st2.nextToken());
		}
		System.out.println();
		String[] arr2 = msg.split("|");
		System.out.println("총 " + arr2.length + "개");
		
		String[] arr3 = msg.split("\\|");
		System.out.println("총 " + arr3.length + "개");
		
		for (String a:arr3)
			System.out.println(a);
		System.out.println();
		
		String msg2 = "이미자.손태영.가오동.이영자.박진아";
		String[] arr22 = msg2.split("\\.");
		for (String a: arr22) 	
			System.out.println(a);
	}
	
}
