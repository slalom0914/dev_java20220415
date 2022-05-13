package com.week4;

import java.util.List;
import java.util.Vector;

public class ListTest_1 {
	List list1 = new Vector();
	List<String> list2 = new Vector<>();
	public void setList1() {
		list1.add("수박");
		list1.add("토마토");
		list1.add("사과");
	}
	public void setList2() {
		list2.add("이순신");
		list2.add("강감찬");
		list2.add("김유신");
	}
	public void list1_Print() {
		list1.remove(1);
		list1.add(1, "파인애플");
		for(int i=0;i<list1.size();i++) {
			String fruit = (String )list1.get(i);
			System.out.println(list1.get(i));
		}
	}
	public void list2_Print() {
		for(int i=0;i<list1.size();i++) {
			String name = list2.get(i);
			System.out.println(name);
		}
	}
	public static void main(String[] args) {
		ListTest_1 lt = new ListTest_1();
		lt.setList1();
		lt.list1_Print();
		lt.setList2();
		lt.list2_Print();
	}
}
