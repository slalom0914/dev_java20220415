package com.day4;

public class Variable_8 {
	// boolean타입의 디폴트 값은 false 이다.
	// 변수 선언시 타입 앞에 static을 붙일 수 있다.
	// 인스턴스화 없이도 사용이 가능하다 
	// boolean타입은 선택할 때 결정해야 할 때 사용한다 - if, switch
	public static boolean isOk;// 전역변수의 scope를 갖는다
	// 파라미터가 없는 디폴트 생성자 구현/선언
	public Variable_8() {
		System.out.println("Variable_8디폴트 생성자 호출 성공");
		isOk = true;
	}
	public static void main(String[] args) {
		System.out.println(isOk);// false 출력
		//stack
		isOk = true;
		System.out.println(Variable_8.isOk);

	}

}
// 지역변수는 인스턴스화를 통해서 호출이 불가하다 