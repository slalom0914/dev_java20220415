package com.week3;

// 변수의 초기화는 언제? 어디에? 왜? 해야 하는거니?
// 문제 : 1부터 5까지의 합을 구하는 프로그램을 작성하시오.
public class Initialization_6 {
	int count;
	int hap = 0;
	public void account() {
		for(count=1;count<6;count++) {
			hap = hap+count;
		}
		System.out.println("after count : "+count);
		System.out.println("after hap : "+hap);
		// 만일 이어서 1부터 5까지 다시 세면서 홀수의 합을 구하라고 한다면?
		// 초기화는 어디에? 그리고 얼마로 해야 될까요
		count = 1;
		for(;count<6;count++) {
			if(count%2==0)
				hap = hap+count;
		}	
		// 6을 기대했는데 왜 21이 출력되는 거지!!! 앗 초기화
		System.out.println("짝수의 합은 : "+hap);
	}
	public static void main(String[] args) {
		Initialization_6 i3 = new Initialization_6();
		i3.account();
	}

}
