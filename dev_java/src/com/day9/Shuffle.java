package com.day9;
// 변수가 몇 개 필요하니? - 3개
// 변수 위치는?
public class Shuffle {

	public static void main(String[] args) {
		int i=3;
		int j=6;
		int imsi = 0;
		imsi = i;
		i = j;// 3->6
		j = imsi;
		System.out.println(i+", "+j);
	}

}
