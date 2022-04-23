package com.week1;

public class LocalVariable_1 {
	// 메소드의 파라미터로 선언된 변수는 지역변수 이고 메소드 안에서만 유지됨
	// 지역변수는 초기화를 생략할 수 없다고 했는데 
	// 그럼 누가 언제 하나요? 메소드 호출할 때 초기화가 됨
	void methodA(double d) {
		System.out.println("methodA 호출 성공 : "+d);
	}
	public static void main(String[] args) {
		LocalVariable_1 lv = new LocalVariable_1();
		double avg = 85.8;
		lv.methodA(avg);
		// 7번 라인에 변수 d는 지역변수 이므로 main메소드 영역에서 사용불가
		// System.out.println(d); 변수 d에 접근할 수 없어서 에러발생
		
	}

}
