package com.day17;

public class A {
	void methodA(int i) {
		//for문안에서 선언된 변수는 for문 밖에서 사용이 불가능하다
		int z = 0;
		try {			
			z = i/0;
		} catch (Exception e) {
			System.out.println("[Exception]"+e.toString());
		}
		System.out.println(z);
	}
	public static void main(String[] args){
		int i = 5;
		int j = 0;
		A a  = new A();
		a.methodA(i);
	}

}
