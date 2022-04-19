package com.basic;

public class StaticTest_2 {
	// 선언부
	
	// 사용자 정의 메소드 
	static void methodA() {
		System.out.println("methodA 호출 성공");
	}
	// 메인메소드
	public static void main(String[] args) {
		methodA();
	}
}

/*
1. JVM에서 제공되는 메소드
JVM안에 이미 내장되어 있는 클래스에 선언되고 구현된 메소드를 말함
2. 사용자 정의 메소드 
개발자가 접근제한자 static 여부, 그리고 반환타입을 정할 수 있다

static이 붙은 메소드는 static영역에서 사용할 수 있다
*/