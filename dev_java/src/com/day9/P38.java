package com.day9;

public class P38 {
	// Casting 연산자
	// 자동형전환, 강제 형전환
	public static void main(String[] args) {
		int i = 10;
		double d = 3.14;
		String s = null;
		boolean isOk = false;
		// 캐스팅 연산자는 받아주는 쪽의 타입으로 쓴다.
		// 대신 받아주는 쪽의 데이터 범위만 담을 수 있다.
		i = (int)d;
		d = i;
		//s = (String)d;
		//isOk = (boolean)i;
		System.out.println(i);// 3.14 -> 3 
	}

}
