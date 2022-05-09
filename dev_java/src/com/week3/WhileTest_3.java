package com.week3;

public class WhileTest_3 {
	/****************************************************
	 * 합을 구하는 메소드 구현
	 * @param i 카운트 하는 변수
	 * @param hap 합을 담을 변수
	 ****************************************************/
	public void account(int i, int hap) {
		while(i<6) {
			hap = hap + i;
			System.out.println("i : "+i);
			System.out.println("hap : "+hap);
			i++;
		}
		System.out.println("1부터 5까지의 합은 "+hap);		
	}
	public static void main(String[] args) {
		WhileTest_3 w = new WhileTest_3();
		int i = 1;
		int hap = 0;
		w.account(i, hap);
	}

}
