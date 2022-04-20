package com.day4;

public class Variable_1_1 {
	// 전역변수 age선언 및 초기화(초기값은 20임)
	int age = 20;
	void methodA() {
		// 변수 age앞에 int를 붙였으므로 지역변수를 새로 선언한 것이 됨
		// 5번 라인에 선언된 변수와는 아무 상관 없음. 다만 이름만 같을 뿐임
		int age = 30;
	}// end of methodA
	public static void main(String[] args) {
		// 아래 코드가 메모리에 로딩 되면 5번 라인에 age변수도 생성되고 20으로 초기화됨
		Variable_1_1 v1 = new Variable_1_1();
		// 아래 v1.age는 20이 출력됨 그러나 7번 메소드를 경유하면 11번에서 30으로 변경됨
		System.out.println("before : "+v1.age);// 20이 출력됨
		v1.methodA();// 이메소드를 경유하면 지역변수 age가 30으로 초기화됨
		// 아래코드에서는 전역변수 age에 저장된 값을 출력하니까 20이 출력됨	
		System.out.println("after : "+v1.age);	
	}// end of main 
}////// end of Variable_1_1
