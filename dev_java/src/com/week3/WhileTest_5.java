package com.week3;

public class WhileTest_5 {
	int i;
	int hap;	
	public WhileTest_5(int i, int hap) {
		this.i = i;
		this.hap = hap;
	}
	public void account() {
		while(i<6) {
			hap = hap + i;
			System.out.println("i : "+i);
			System.out.println("hap : "+hap);
			i++;
		}
	}
	public static void main(String[] args) {
		int i = 1;
		int hap = 0;
		WhileTest_5 w = new WhileTest_5(i,hap);
		w.account();
		System.out.println("1부터 5까지의 합은 "+w.hap);		
	}

}
