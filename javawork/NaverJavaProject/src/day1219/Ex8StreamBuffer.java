package day1219;

public class Ex8StreamBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Happy";
		
		//String -> StringBuffer
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb);
		System.out.println(sb.toString());
		//인스턴스 변수인 경우 변수명만 출력시 자동으로 toString() 호출
		//toString을 갖고 있지 않는 경우 값이 아닌 주소가 출력된다
		
		//String은 값 전체를 변경할 순 없지만 SB는 문자열 편집이 가능
		sb.append('A');
		sb.append(100);
		sb.append("Bitcamp");
		System.out.println(sb);
		
		//삭제
		sb.delete(5, 9); //5인덱스부터 9-1 = 8인덱스까지 삭제 
		System.out.println(sb);
		
		sb.insert(3, "Java");	
		System.out.println(sb);
		
		sb.replace(3,  7, "Hello");
		System.out.println(sb);
		
		String name = "캔디";
		int age = 23;
		
		StringBuffer sb2 = new StringBuffer();
		sb2.append("{\"name\":");
		sb2.append("\""+name+"\",");
		sb2.append("\"age\": ");
		sb2.append(age+"}");
		
		System.out.println(sb2);
	}

}
