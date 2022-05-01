package com.day9;
// 변수가 몇 개 필요하니? - 3개
// 변수 위치는?
public class Shuffle_1 {
	int i=2;
	int j=4;
	int imsi = 0;

	public static void main(String[] args) {
		Shuffle_1 s1 = new Shuffle_1();
		s1.imsi = s1.i;
		s1.i = s1.j;// 3->6
		s1.j = s1.imsi;
		System.out.println(s1.i+", "+s1.j);
	}

}
