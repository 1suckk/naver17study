package day1224;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex10ListVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 = new Vector<String>(); //별도로 적어주지 않으면 10개 생성
		//List<String> list2 = new Vector<String>(5); //별도로 적어주면 5개 생성
		List<String> list2 = new Vector<String>(5, 3);
		
		System.out.println("list1의 데이터 갯수: " + list1.size() + ", 할당갯수: "
				+ ((Vector<String>)list1).capacity());
		
		System.out.println("list2의 데이터 갯수: " + list2.size() + ", 할당갯수: "
				+ ((Vector<String>)list2).capacity());
		
		list2.add("김상아");
		list2.add("이미자");
		list2.add("홍상수");
		list2.add("이진");
		list2.add("이효리");
		list2.add("김상아");
		list2.add("이진");
		
		System.out.println("list2의 데이터 갯수: " + list2.size() + ", 할당갯수: "
				+ ((Vector<String>)list2).capacity());
		System.out.println();

		System.out.println("출력 방법 1");
		for (String s:list2)
			System.out.print(s + " ");
		System.out.println();
		System.out.println();
		
		System.out.println("출력 방법 2");
		for (int i=0; i<list2.size(); i++) 
			System.out.print(i+1 + ":" + list2.get(i) + " ");
		System.out.println();
		System.out.println();
		
		System.out.println("출력 방법 3");
		Iterator<String> iter = list2.iterator();
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
		System.out.println();
		System.out.println();
		
		System.out.println("출력 방법 4");
		Object[] ob = list2.toArray();
		for (Object s:ob)
			System.out.print(s + " ");
	}
}