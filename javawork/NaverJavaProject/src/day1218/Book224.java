package day1218;

public class Book224 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Korean k1 = new Korean("고혁진", "881003-1234567");
		System.out.println("국적: " + k1.nation);
		System.out.println("이름: " + k1.name);
		System.out.println("주민번호: " + k1.ssn);
		
		Korean k2 = new Korean("이중무", "740520-1234567");
		System.out.println("국적: " + k2.nation);
		System.out.println("이름: " + k2.name);
		System.out.println("주민번호: " + k2.ssn);
	}

}
