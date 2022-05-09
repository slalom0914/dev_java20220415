package com.week4;

public class IntArray_3 {
	// 부서번호를 담을 배열 선언
	int deptnos[] = null;
	public void initArray() {
		deptnos = new int[]{10,20,30};
	}
	public void arrayPrint() {
		for(int deptno:deptnos) {
			System.out.println(deptno);
		}
	}
	public static void main(String[] args) {
		IntArray_3 i3 = new IntArray_3();
		i3.initArray();
		i3.arrayPrint();	
	}

}
