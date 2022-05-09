package com.week3;

// 변수의 초기화는 언제? 어디에? 왜? 해야 하는거니?
// 문제 : 1부터 5까지의 합을 구하는 프로그램을 작성하시오.
public class Initialization_3 {
	int count;
	int hap = 0;
	public void account() {
		for(count=1;count<6;count++) {
			System.out.println("count : "+count);
			System.out.println("hap : "+hap);
		}
	}
	public static void main(String[] args) {
		Initialization_3 i3 = new Initialization_3();
		i3.account();
	}
}
