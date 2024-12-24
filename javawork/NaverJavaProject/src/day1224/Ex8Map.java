package day1224;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex8Map {
	public static void main(String[] args) {
		/*
		 * Map 타입은 k,v 쌍으로 데이터를 추가한다
		 * 이때 key값은 Set 타입이다 중복 비허용 하며 비순차적
		 */
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", "송혜교");
		map.put("age", "34");
		map.put("blood", "AB");
		map.put("name", "이영자"); //이렇게 되면 기존 name key에 있는 송혜교는 덮어서 씌워진다.
		
		System.out.println("map의 사이즈: " + map.size());
		System.out.println("map에서 key 값으로 value 값 꺼내기");
		System.out.println("이름: " + map.get("name"));
		System.out.println("나이: " + map.get("age"));
		System.out.println("혈액형: " + map.get("blood"));
		System.out.println("핸드폰: " + map.get("hp")); //map 내에서 없으면 null이 나온다
		System.out.println();
		System.out.println("key 값들을 자동으로 얻은 후 value 값들 얻기");
		
		Set<String> keySets = map.keySet();
		for(String key:keySets)
		{
			String v = map.get(key);
			System.out.println(key + "=>" + v);
		}
	}
}