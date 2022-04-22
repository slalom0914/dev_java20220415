package com.day4;

public class Variable_6 {
	// 전역변수는 초기화를 생략할 수 있다.
	// 지역변수는 초기화를 생략하면 안돼나????
	// int의 디폴트 값은 0이다
	int i;
	void methodA(int i) {// 100이 복사됨
		//insert here i=10
		System.out.println(i);
	}
	public static void main(String[] args) {
		int i;// 변수 선언
		//i = 10;// 변수의 초기화
		//지변 i는 다른 메소드에서도 유지가 되나요?
		Variable_6 v6 = new Variable_6();
		//i = 100;
		v6.methodA(v6.i);
	}

}
