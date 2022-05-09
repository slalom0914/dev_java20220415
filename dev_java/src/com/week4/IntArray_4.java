package com.week4;

public class IntArray_4 {
	// 부서번호를 담을 배열 선언
	public void initArray(int deptnos[]) {
		arrayPrint(deptnos);
	}
	public void arrayPrint(int deptnos[]) {
		for(int deptno:deptnos) {
			System.out.println(deptno);
		}
	}
	public static void main(String[] args) {
		IntArray_4 i3 = new IntArray_4();
		int deptnos[] = null;
		deptnos = new int[]{10,20,30};
		i3.initArray(deptnos);
	}

}
