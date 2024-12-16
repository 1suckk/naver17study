package day1216;

public class Ex5String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Apple";
		String str2 = "Have a nice day!!";
		String str3 = "orange";
		String str4 = new String("Apple");
		
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
		
		System.out.println("str2의 길이: " + str2.length());
		System.out.println("str1의 0번글자: " + str1.charAt(0));
		System.out.println("str2의 3번글자: " + str2.charAt(3));
		System.out.println("str3의 1번글자: " + str3.charAt(1));
		
		System.out.println();
		System.out.println("str1에서 l의 위치는 :" + str1.indexOf('l'));
		System.out.println("str2에서 a의 위치는 :" + str2.indexOf('a')); //첫번째 a의 위치 : 0부터 시작
		System.out.println("str2에서 a의 위치는 :" + str2.lastIndexOf('a')); //마지막 a의 위치 : 0부터 시작
		System.out.println("str3에서 x의 위치는 :" + str3.indexOf('x')); //x의 위치 : 없으면 -1 리턴
		
		System.out.println();
		System.out.println(str1==str4);
		System.out.println(str3=="Orange");
		System.out.println(str1=="apple");
		
		//대소문자까지 맞아야 true
		System.out.println();
		System.out.println("equal 사용 예시");
		System.out.println(str1.equals(str4));
		System.out.println(str1.equals("apple"));
		System.out.println(str1.equals("Apple"));
		System.out.println(str1.equals("aPple"));
		System.out.println(str1.equalsIgnoreCase("apple"));
		
		System.out.println();
		System.out.println("문자열 비교: compareTo ");
		int n = str1.compareTo("Apple");
		System.out.println(n);
		
		n = str1.compareTo("Banana");
		System.out.println(n);
		
		n = str3.compareTo(str1);
		System.out.println(n);
		
		System.out.println();
		System.out.println("대문자 소문자로 바꾸는 함수");
		System.out.println("str2를 모두 대문자로 반환: " + str2.toUpperCase());
		System.out.println("str2를 모두 소문자로 반환: " + str2.toLowerCase());
		
		System.out.println();
		System.out.println("startsWith 함수와 endsWith 함수");
		System.out.println("str2가 Have로 시작하면 true: " + str2.startsWith("Have"));
		System.out.println("str2가 Happy로 시작하면 true: " + str2.startsWith("Happy"));
		System.out.println("str2가 Day!!로 끝나면 true: " + str2.endsWith("Days!!"));
		System.out.println("str2가 day!!로 끝나면 true: " + str2.endsWith("day!!"));
		
		System.out.println();
		System.out.println("split 함수");
		System.out.println("=".repeat(20));
		System.out.println(str1.repeat(5));
		System.out.println("=".repeat(20));
		
		System.out.println();
		System.out.println("replace 함수");
		System.out.println(str2.replace('a', '*'));
		System.out.println(str2.replace("Nice", "Happy"));
		
		System.out.println();
		System.out.println("substring 함수");
		System.out.println(str2.substring(7));
		System.out.println(str2.substring(7, 10)); //7, 8, 9번 인덱스 추출
		
		System.out.println();
		System.out.println("split으로 문자열 분리해서 배열로 반환");
		String str5 = "red,green,blue"; 
		System.out.println("str5 = " + str5);
		String[] array = str5.split(",");
		// 배열 출력
		for (String a: array)
			System.out.println(a);
	
		System.out.println();
		System.out.println("trim 함수 사용");
		String str6 = "   hello   ";
		System.out.println("*"+str6+"*");
		System.out.println("*"+str6.trim()+"*");
		
		System.out.println();
		System.out.println("valueOf 함수 사용");
		//String s1 = String.valueOf(100);
		String s1 = 100 + ""; //묵시적 형변환
		String s2 = String.valueOf(true);
		String s3 = String.valueOf(34.6);
		String s4 = String.valueOf('A');
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}

}
