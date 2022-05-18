package com.day20;

public class StringTest {

	public static void main(String[] args) {
		String s = "이순신";
		s = "Hello World";
		System.out.println(s.length());// 문자열의 길이를 출력한다.
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println(s.substring(0, 3));
		System.out.println(s.substring(7, 9));
		s = "java";
		s = s.replace('j', 'h');
		// String타입은 원본이 절대로 바뀌지 않는다.
		// 굳이 바꾸려면 대입연산자로 치환을 해야 한다. - 비효율적이다.
		// StringBuffer, StringBuilder
		System.out.println(s);// java  or hava
	}

}
