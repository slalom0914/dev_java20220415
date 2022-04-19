package com.basic;

public class Variable_4 {
	//전역변수 - 선언부에 선언하면 
	int age = 20;
	int methodA(int age) {// age는 지역변수 - 메소드 파라미터이면
		age = 30;
		return age;
	}
	public static void main(String[] args) {
		Variable_4 v1 = new Variable_4();
		System.out.println("before : "+v1.age);
		int age = v1.methodA(50);
		System.out.println("after : "+age);		
	}
}
