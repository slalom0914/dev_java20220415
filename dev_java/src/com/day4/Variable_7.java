package com.day4;

public class Variable_7 {
	/***************************************
	 * 
	 **************************************/
	void methodA() {
		//return 5;
	}
	/****************************************
	 * 
	 * @return 안녕
	 ****************************************/
	int methodB() {
		int x = 5;
		int y;
		y = x;
//		return 0;
		return y;
	}
	public static void main(String[] args) {
		Variable_7 v7 = new Variable_7();
		int x;
//		int x = v7.methodA();
		v7.methodA();
		x = v7.methodB();
		x = x + 2;
		System.out.println(x);
	}

}
