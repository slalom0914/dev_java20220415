package com.day3;

public class Parameter {

	public static void main(String[] args) {
		// 배열을 선언하기 - 한 번에 방이 3개가 생김
		String[] names = new String[3];
		names[0] = "홍길동";
		names[1] = "이순신";
		names[2] = "강감찬";
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
	}

}
/*
컴파일을 하는 명령어
javac Parameter.java -> JVM경유 -> 컴파일 경유 -> Parameter.class

java Parameter 이순신 강감찬 이성계
*/