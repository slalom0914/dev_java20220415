package com.day10;

public class Z {

	public static void main(String[] args) {
		int i = 2;// i=2
		int j = 0;// j=0
		// 후위연산자이다 - 대입이 먼저 그리고 다음에 증가시킨다
		j = ++i;// i++ -> i = i + 1
		System.out.println(i+", "+j);

	}

}
