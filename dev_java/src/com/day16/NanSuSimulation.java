package com.day16;

public class NanSuSimulation {

	public static void main(String[] args) {
	// 내가 다른 클래스의 메인메소드를 호출할 수 있나?
	// 사용자 정의 메소드와 콜백메소드 차이
    // 시행착오법 - 안된다 헤어진다
		NansuJumsu nj = new NansuJumsu();
		int j[] = {5,6,7,8,9};
		nj.totalSum(j, 0);// call by value - 값에 의한 호출
	}

}
