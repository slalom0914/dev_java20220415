package com.day13;

public class FizzBuzzGame_1 {
	// 1부터 100까지 센다 - 반복문
	public static void main(String[] args) {
		//선언과 초기화를 쪼개서 쓸 수 있는 건 메소드 안 또는 생성자 안에서만 가능함.
		// 변수 선언만
		int i;
		// 변수 초기화 함.
		i=1;
		//for(int i=1;i<101;i++) {
		while(i < 101) {
			//
			System.out.println(i);
			++i;
			//
		}///////////// end of while
	}///////////////// end of main
}///////////////////// end of FizzBuzzGame_1
