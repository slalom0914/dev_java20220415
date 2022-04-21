package com.method;

public class Method_1App {

	public static void main(String[] args) {
		Method_1 m1 = new Method_1();
		m1.methodA();
		m1.methodB();
		// methodC는 private이니까 Method_1외부에서 접근이 불가함
		//m1.methodC();
		m1.methodD("안녕하세요");
	}

}
