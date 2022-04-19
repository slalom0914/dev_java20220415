package com.basic;

public class Variable_2 {
	int age = 20;
	void methodA(int age) {
		age = 30;
	}
	public static void main(String[] args) {
		Variable_2 v1 = new Variable_2();
		System.out.println("before : "+v1.age);
		v1.methodA(50);
		System.out.println("after : "+v1.age);		
	}
}
