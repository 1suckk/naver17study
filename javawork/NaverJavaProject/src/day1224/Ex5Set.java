package day1224;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Set은 중복 데이터를 허용하지 않고
 * 비순차적인 즉 추가한대로 들어가지 않는  인터페이스이다.
 * 이를 implements 하는 클래스가
 * HashSet(임의로 지정)과 LinkedHashSet이 있다.
 * 이 Set에서 SortedSet 인터페이스가 자식으로 extends 되고,
 * 이 SortedSet에서 TreeSet(오름차순으로 정해짐) 이 implements 된다.
 * 
 * 모든 컬렉션 타입은 (Set, Map, List) 제네릭을 이용하여 타입 지정
 * 모든 컬렉션은 원래 오브젝트 타입만 추가되지만 jdk5 이후로
 * 오토박싱에 의해서 기본형도 자동으로 오브젝트화 되서 들어간다.
 */
public class Ex5Set {
	public static void main(String[] args) {
		/*
		 * 등호 뒷부분의 <>에는 아래와 같이 아무 것도 안쓰거나
		 * 쓸거면 등호 좌측처럼 Integer로 써줘야 한다
		 */
		Set<Integer> set1 = new HashSet<>(); //뒤에는 구현체를 new해야함
		Set<Integer> set2 = new TreeSet<>();
		
		set1.add(100);
		set1.add(300);
		set1.add(100);
		set1.add(200);
		set1.add(500);
		
		set2.add(100);
		set2.add(300);
		set2.add(100);
		set2.add(200);
		set2.add(500);
	
		System.out.println("set1의 갯수:" + set1.size());
		System.out.println("set2의 갯수:" + set2.size());

		//컬렉션 출력 for문
		System.out.println("HashSet 결과");
		for (Integer n:set1)
			System.out.print(n + " ");
		System.out.println();
		
		System.out.println("TreeSet 결과");
		for (Integer n:set2)
			System.out.print(n + " ");
		System.out.println();
	}
}