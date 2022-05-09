package com.week3;

// 변수의 초기화는 언제? 어디에? 왜? 해야 하는거니?
// 문제 : 1부터 5까지의 합을 구하는 프로그램을 작성하시오.
public class Initialization_5 {
	int count;
	int hap = 0;
	public void account() {
		for(count=1;count<6;count++) {
			hap = hap+count;
		}
		System.out.println("after count : "+count);
		System.out.println("after hap : "+hap);
	}
	public static void main(String[] args) {
		Initialization_5 i3 = new Initialization_5();
		i3.account();
	}

}
