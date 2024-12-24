package day1224;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex6Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new TreeSet<>();
		
		set1.add("전상훈");
		set1.add("고혁진");
		set1.add("이중무");
		set1.add("전상훈");
		
		set2.add("고혁진");
		set2.add("이중무");
		set2.add("고혁진");
		set2.add("전상훈");
	
		System.out.println("set1의 갯수:" + set1.size());
		System.out.println("set2의 갯수:" + set2.size());
		
		//컬렉션 출력 for문
		System.out.println("HashSet 결과");
		for (String s:set1)
			System.out.print(s + " ");
		System.out.println();
		
		System.out.println("TreeSet 결과");
		for (String s:set2)
			System.out.print(s + " ");
		System.out.println();
		
		//for 문 대신에 아래 방법도 사용 가능
		Iterator<String> iter = set2.iterator();
		while (iter.hasNext())
		{
			System.out.println(iter.next() + " ");
			System.out.println();
		}
	}
}