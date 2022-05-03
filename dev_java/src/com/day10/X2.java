package com.day10;

public class X2 {

	public static void main(String[] args) {
		// 이때  true는 논리연산자가 아니다.
		String s1 = new String("true");
		// 원시형 타입 boolean의 Wrapper클래스 이다.
		// 원시형 타입은 변수와 메소드를 가질 수 없다.
		// 그런데 이러한 원시형도 변수와 메소드 선언이 필요한 경우가 있다.
		// 이것을 지원하지 위해서 제공되는 클래스가 있는데 그것을 래퍼클래스라 함
		Boolean b1 = new  Boolean(true);
		boolean isOk = false;
		// s1이 가리키는 값과 b1이 가리키는 값이 같은지를 비교할 때 사용함
		// == s1의 주소번지와 b1의 주소번지가 같은지를 비교하는 것임
		System.out.println(s1.equals(b1));
		System.out.println(s1 == b1);
	}

}
