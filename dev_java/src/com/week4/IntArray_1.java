package com.week4;

public class IntArray_1 {
	// 부서번호를 담을 배열 선언
	int deptnos[] = null;
	public IntArray_1() {
		deptnos = new int[3];
		initArray();
		arrayPrint();
	}
	public void initArray() {
		deptnos[0] = 10;
		deptnos[1] = 20;
		deptnos[2] = 30;
	}
	public void arrayPrint() {
		for(int i=0;i<deptnos.length;i++) {
			System.out.println(deptnos[i]);
		}
	}
	public static void main(String[] args) {
		new IntArray_1();
	}

}
