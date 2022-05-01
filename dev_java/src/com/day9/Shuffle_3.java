package com.day9;
// 변수가 몇 개 필요하니? - 3개
// 변수 위치는?
public class Shuffle_3 {
	static int i=210;
	static int j=455;
	static int imsi = 0;

	public static void main(String[] args) {
		imsi = i;
		i = j;// 3->6
		j = imsi;
		System.out.println(i+", "+j);
	}

}
