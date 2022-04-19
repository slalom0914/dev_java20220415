package com.basic;

public class StaticTest_1 {
	// 선언부
	
	// 사용자 정의 메소드
	void methodA() {
		System.out.println("methodA 호출 성공");
	}
	// 메인메소드
	public static void main(String[] args) {
		StaticTest_1 st1 = new StaticTest_1();
		st1.methodA();
	}

}
