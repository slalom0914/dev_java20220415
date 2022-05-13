package com.day16;

import java.util.Random;

public class NansuJumsu {
	public void totalSum(int jumsu[], int tot) {
		System.out.println("totalSum 호출");
		for(int i=0;i<jumsu.length;i++) {
			System.out.println(i);
			tot = tot + jumsu[i];
		}
		System.out.println("totalSum ===> "+tot);
	}
	public static void main(String[] args) {
		int jumsu[] = new int[5];
		// 난수 발생을 위한 씨앗이되는 값이다.
		Random r = new Random();
		//총점을 담을 변수 선언하기
		int tot = 0;
		// 업무에 대한 요구사항 수렴
		double d_avg =0.0;
		// 5개의 임의의 점수를 입력 받아야 하므로 반복문 사용하기
		for(int i=0;i<jumsu.length;i++) {
			jumsu[i] = r.nextInt(101);
			System.out.println("jumsu["+i+"] : "+jumsu[i]);
		}
		for(int j=0;j<jumsu.length;j++) {
			tot = tot + jumsu[j];
		}
		System.out.println("총점 ===> "+tot);
		// 평균 구하기
		d_avg = tot/5.0;
		System.out.println("평균 ===> "+d_avg);
		//석차 구하기
		int rank[] = {1,1,1,1,1};
		for(int i=0;i<jumsu.length;i++) {
			for(int j=0;j<jumsu.length;j++) {
				if(jumsu[i] < jumsu[j]) {
					rank[i]++;
				}
			}
		}
		for(int rnk:rank) {
			System.out.println(rnk);
		}
	}// end of main

}






















