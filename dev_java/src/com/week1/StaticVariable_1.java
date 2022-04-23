package com.week1;

public class StaticVariable_1 {
	static double pi = 3.14;
	public static void main(String[] args) {
		StaticVariable_1 sv = new StaticVariable_1();
		System.out.println(pi);
		pi = pi + 1;
		System.out.println(StaticVariable_1.pi);
	}

}
