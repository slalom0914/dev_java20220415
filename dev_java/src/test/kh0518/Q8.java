package test.kh0518;

import java.util.HashMap;
import java.util.Map;

public class Q8 {
	Map<String, Object> map1 = new HashMap<>();
	public void setMap1() {
		map1.put("mem_id", "tomato");
		map1.put("mem_pw", "123");
		map1.put("mem_name", "토마토");
	}
	public void map1Print() {
		// Map은 key로 value를 관리하는 인터페이스이고 
		// 구현체 클래스로 HashMap과 Hashtable이 있다
		// keySet()은 Map의 key를 Set인터페이스로 생성해주는 함수임
		// 이렇게 생성된 Set이 제공하는 toArray()를 사용하면 
		// key값을 배열로 담아줌
		Object keys[] = map1.keySet().toArray();
		for(int i=0;i<keys.length;i++) {
			System.out.println(keys[i]+", "+map1.get(keys[i]));
		}
		// Map계열의 구현체 클래스들은 모두 key로 value를 접근하므로
		// key값을 알아낼 수 있는 메소드를 지원하는데 그 중 하나가 entrySet()이다.
		for (Map.Entry<String, Object> entry : map1.entrySet()) {
			System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
		}
	}
	public static void main(String[] args) {
		Q8 q = new Q8();
		q.setMap1();
		q.map1Print();
	}

}
