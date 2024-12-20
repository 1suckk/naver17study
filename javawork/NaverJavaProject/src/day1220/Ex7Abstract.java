package day1220;
/*
 * 컬렉션 제네릭 C++ 에서의 STL
 */

import java.util.List;
import java.util.Vector;

public class Ex7Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다형성 처리 예
		List<String> list = null;
		list = new Vector<String>();
		list.add("Red");
		list.add("Green");
		list.add("Blue");
		
		for(String s:list)
			System.out.println(s);
	
		/*
		 *현재 할당된 크기를 알아보는 capacity() 이 메서드는
		 *vector 만이 갖고 있다
		 *아래와 같이 다운캐스팅해주면 된다
		 */
		int n = ((Vector<String>)list).capacity();
		System.out.println(n);
		
		
	}

}
