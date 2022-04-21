package com.day4;

public class Variable_4 {
	//전역변수 - 선언부에 선언하면 
	int age = 20;
	//리턴 타입이 생겼네???
	// 지역변수가 갖는 값을 다른 메소드에서 사용할 때 리턴타입을 사용함.
	int methodA(int age) {// age는 지역변수 - 메소드 파라미터이면
		System.out.println("7번 라인 : "+age);
		age = 30;//지역변수임
		System.out.println("9번 라인 : "+age);
		// 6번 라인에 리턴타입이 int가 왔으므로 메소드를 닫기 전에 반드시 
		// return을 붙여야 함. 그리고 반환타입은 오직 int만 가능함
		return age;
	}
	public static void main(String[] args) {
		Variable_4 v1 = new Variable_4();
		System.out.println("before : "+v1.age);
		// 6번 라인에 선언된 메소드의 리턴 타입이 있으므로 
		// 메소드의 리턴값을 대입연산자로 받아서 main메소드에서 사용이 가능함
		int age = v1.methodA(50);
		System.out.println("20번 라인 after : "+age);		
	}
}
