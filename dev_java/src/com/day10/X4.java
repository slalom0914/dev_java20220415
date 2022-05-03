package com.day10;

public class X4 {

	public static void main(String[] args) {
		// 이때  true는 논리연산자가 아니다.
		Boolean s1 = new Boolean(true);
		// 원시형 타입 boolean의 Wrapper클래스 이다.
		// 원시형 타입은 변수와 메소드를 가질 수 없다.
		// 그런데 이러한 원시형도 변수와 메소드 선언이 필요한 경우가 있다.
		// 이것을 지원하지 위해서 제공되는 클래스가 있는데 그것을 래퍼클래스라 함
		Boolean b1 = new  Boolean(true);
		System.out.println(s1+","+b1);
		if(s1.equals(b1)) {
			System.out.println("Equal");
		}else {
			System.out.println("Not Equal");			
		}
		if(s1 == b1) {
			System.out.println("주소번지가 같다");			
		}else if(s1!=b1) {
			System.out.println("주소번지가 다르다");						
		}
	}

}
