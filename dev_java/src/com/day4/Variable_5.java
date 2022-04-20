package com.day4;

public class Variable_5 {
	// 전역변수 - 선언부에 선언하면 
	int age 	= 20;
	// 변수 선언 앞에 static이 있으면 정적변수라고 함
	// 인스턴스화 없이 호출할 수 있다.
	// 단 클래스 외부에서 접근할 때는 클래스 타입.변수명 으로 호출가능함
	static int height 	= 170;
	public static void main(String[] args) {
		Variable_5 v1 = new Variable_5();
		System.out.println(v1.age);
		System.out.println(height);
	}
}
