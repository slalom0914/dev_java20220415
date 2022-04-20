package com.method;

public class Method_1 {
	public void methodA() {
		System.out.println("methodA 호출 성공");
	}
	void methodB() {
		System.out.println("methodB 호출 성공");		
	}
	// 접근 제한자가 private이면 외부의 클래스에서 접근이 불가함
	// 만일 Method_1App에서 methodC는 호출할 수 없다는 점
	private int methodC() {
		System.out.println("methodC 호출 성공");		
		return 0;
	}
	/***************************************************************
	 * 리턴타입도 결정되고 파라미터도 있는 경우
	 * @param insa - 타입은 String이고 호출하는 쪽에서 값이 결정됨.
	 * @return - 파라미터로 받은 값을 메소드 외부로 내보낼 때 사용 가능.
	 ***************************************************************/
	String methodD(String insa) {
		System.out.println("methodD 호출 성공");		
		return insa;
	}
	public static void main(String[] args) {
		Method_1 m1 = new Method_1();
		m1.methodA();
		m1.methodB();
		m1.methodC();
		m1.methodD("안녕하세요");
	}

}
/*
	나는 메소드를 선언하고 호출할 수 있다.
	메소드 선언하기
	(접근제한자:생략가능) (static:생략가능) [리턴타입:생략불가] [메소드명(파라미터1,...):생략불가]
*/