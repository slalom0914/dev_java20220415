package com.day4;

public class Variable_3 {
	int age = 20;
	void methodA(int age) {
		age = 30;
		System.out.println("methodA : "+age);
	}
	public static void main(String[] args) {
		Variable_3 v1 = new Variable_3();
		System.out.println("before : "+v1.age);
		v1.methodA(50);
		System.out.println("after : "+v1.age);		
	}
}
