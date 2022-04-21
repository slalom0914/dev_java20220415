package com.day4;

public class Variable_5 {
	// 전역변수 - 선언부에 선언하면 
	// 전역변수는 초기화를 생략할 수 있다.
	// 그러면 뭐가 출력되지? 디폴트 값이 출력된다.
	// int 는 0, double은 0.0, boolean은 false
	// 참조형 변수의 디폴트 값은 null이다 
	int age 	= 20;
	// 변수 선언 앞에 static이 있으면 정적변수라고 함 - 클래스 급이다
	// 인스턴스화 없이 호출할 수 있다.
	// 단 클래스 외부에서 접근할 때는 클래스 타입.변수명 으로 호출가능함
	static int height 	= 170;// 전역의 성격을 가지면서 동시에 외부클래스에서 호출가능함
	public static void main(String[] args) {
		Variable_5 v1 = new Variable_5();
		System.out.println(v1.age);
		System.out.println(height);
		System.out.println(Variable_5.height);
	}
}
/*
	primary data type - 원시형 변수
	
	reference type - 참조형 변수

*/