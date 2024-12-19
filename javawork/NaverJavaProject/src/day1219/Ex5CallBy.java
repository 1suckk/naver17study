package day1219;
/*
 * 인자전달방식
 * callByValue : 값만 전달 (기본형, String)
 * callByReference : 주소만 전달 (모든 객체, 배열타입)
 */

class Test
{
	String message;
	int code;
}
////////////////////////////////////////
public class Ex5CallBy {

	public static void changeInt(int n)
	{
		//주소가 다르게 새로 생성
		n = 200;
	}
	
	public static void changeString(String s)
	{
		s = "apple";
	}
	
	public static void changeArray(int[] arr)
	{
		arr[1] = 20;
	}
	
	public static void changeTest(Test t) {
		t.message="Happy";
		t.code=100;
	}
	
	public static int changeScore(int score) {
		if (score >= 80)
			return score;
		else
			return 90;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		changeInt(n);
		System.out.println("n=" + n); //값만 전달
	
		String s = "Berry";
		changeString(s);
		System.out.println(s); //값만 전달
	
		Test t = new Test();
		System.out.println("message=" + t.message + ", code=" + t.code);
		changeTest(t);
		System.out.println("message=" + t.message + ", code=" + t.code);
		
		//배열
		int[] a = {10, 9, 8}; //레퍼런스 타입
		changeArray(a); //주소가 전달
		for (int aa:a)
			System.out.println(aa + " ");
		System.out.println();
		
		int score = 80;
		//값만 전달받는 경우에는 메서드에서 변경돈 값을 받아오려면 
		//리턴으로 받아와야 한다
		score = changeScore(score);
		System.out.println("score= " + score);
	}

}
