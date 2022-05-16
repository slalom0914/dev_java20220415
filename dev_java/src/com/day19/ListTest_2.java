package com.day19;

import java.util.ArrayList;
import java.util.List;

public class ListTest_2 {
	List<String> list = new ArrayList<>();

	public void setList() {
		list.add("수박");
		list.add("토마토");
		list.add("사과");
	}
	public void printList() {
		setList();
		// 배열처럼 첫번째 인덱스가 0이므로 두번째를 삭제할 경우 1을 준다
		String ele = list.remove(1);
		boolean isFail = list.remove("사과");
//		list.remove(1);
		list.add("바나나");
		for(int i=0;i < list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("삭제된 요소는 "+ele);
		System.out.println("응답 결과 값 "+ isFail);
		System.out.println("바나나 있니? "+list.contains("바나나")+", "+list.contains("키위"));
		if(list.contains("바나나")) {
			System.out.println("바나나 있습니다. 드릴까요?");
		}
	}
	public static void main(String[] args) {
		ListTest_2 lt = new ListTest_2();//디폴트 생성자 호출
		lt.printList();
	}

}
