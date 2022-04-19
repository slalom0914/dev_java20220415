package com.basic;

public class Variable_1 {
	int age = 20;
	void methodA() {
		age = 30;
	}
	public static void main(String[] args) {
		Variable_1 v1 = new Variable_1();
		System.out.println("before : "+v1.age);
		v1.methodA();
		System.out.println("after : "+v1.age);		
	}
}
