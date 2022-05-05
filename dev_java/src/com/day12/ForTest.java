package com.day12;

public class ForTest {

	public static void main(String[] args) {
		int hap = 0;
		for(int i=1;i<6;i=i+1) {
			if(i%2==0) {
				hap = hap+i;
			}
			System.out.println(i);
		}
		System.out.println("1부터 5까지의 합은 "+hap);
	}

}
