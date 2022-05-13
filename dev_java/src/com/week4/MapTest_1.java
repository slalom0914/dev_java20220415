package com.week4;

import java.util.HashMap;
import java.util.Map;

public class MapTest_1 {
	Map<String, Object> map1 = new HashMap<>();
	public void setMap1() {
		map1.put("mem_id", "tomato");
		map1.put("mem_pw", "123");
		map1.put("mem_name", "토마토");
	}
	public void map1Print() {
		Object keys[] = map1.keySet().toArray();
		for(int i=0;i<keys.length;i++) {
			System.out.println(keys[i]+", "+map1.get(keys[i]));
		}
	}
	public static void main(String[] args) {
		MapTest_1 mt = new MapTest_1();
		mt.setMap1();
		mt.map1Print();
	}

}
