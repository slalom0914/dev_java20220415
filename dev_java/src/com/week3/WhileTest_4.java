package com.week3;

public class WhileTest_4 {
	/****************************************************
	 * 합을 구하는 메소드 구현
	 * @param i
	 * @param hap
	 ****************************************************/
	public int account(int i, int hap) {
		while(i<6) {
			hap = hap + i;
			System.out.println("i : "+i);
			System.out.println("hap : "+hap);
			i++;
		}
		return hap;
	}
	public static void main(String[] args) {
		WhileTest_4 w = new WhileTest_4();
		int i = 1;
		int hap = 0;
		hap = w.account(i, hap);
		System.out.println("1부터 5까지의 합은 "+hap);		
	}

}
