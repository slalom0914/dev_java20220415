package com.day10;

public class Y {
	public static void main(String args[]) {
		int i = 2;
		int j = i++;
		System.out.println(i+","+j);
		if((i==--j) && (i++==j)) {
			//실행문 진행
			i += j;// i=i+j;
		}
		System.out.println(i);
	}
}
