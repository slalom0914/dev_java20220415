package com.day13;
// switch문도 조건문의 하나이다.
public class SwitchTest_1 {
	public static void main(String args[]) {
		int i = 1,j = -1;
		switch(i) {
			case 0: case 1:
				j = 1;// j=1 저장, break 예약어가 없어서 계속 아래로 진행됨
				break;
			case 2:
				j = 2;
			default:
				j = 0;
		}
		System.out.println("j =" +j);		
	}
}
