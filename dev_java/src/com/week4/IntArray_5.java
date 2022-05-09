package com.week4;

public class IntArray_5 {
	// 부서번호를 담을 배열 선언
	public int[] initArray() {
		int deptnos[] = new int[]{10,20,30};
		return deptnos;
	}
	public void arrayPrint(int deptnos[]) {
		for(int deptno:deptnos) {
			System.out.println(deptno);
		}
	}
	public static void main(String[] args) {
		IntArray_5 i3 = new IntArray_5();
		int deptnos[] = i3.initArray();
		i3.arrayPrint(deptnos);
	}

}
