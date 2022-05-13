package com.day16;
/*
 * int + int = int
 * int * float = float
 * double / int = double
 * int / double = double
 * double /double = double
 * 
 * 둘 중에 하나는 반드시 타입을 변경해주어야 한다.
 */
public class C {

	public static void main(String[] args) {
		int x = 251/3;
		System.out.println(x);
		double d = 251/3.0;
		System.out.println(d);
	}

}
