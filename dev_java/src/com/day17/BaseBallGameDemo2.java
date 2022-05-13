package com.day17;

public class BaseBallGameDemo2 {
	// 사용자가 입력한 숫자를 받는 코드
	public int userInput(String input) {
		int my = 0;
		// 예외가 발생할 가능성이 있는 코드
		//  예외처리를 다중문으로 할때 반드시 상위 클래스가 맨 나중에 와야 함.
		try {
			my = Integer.parseInt(input);	
		} catch (Exception ex) {
			//toString메소드로 예외이름을 확인 가능하니까 외우지 않아도 돼
			System.out.println(ex.toString());
		}
		//설령 문제가 발생하더라도 여기까지 진행됩니다.
		// 이것이 예외처리 하는 이유이다.
		//예외가 발생하더라도 프로그램이 중지하지 않고 다음으로 이동가능함.
		System.out.println("요기");
		return my;
	}
	public static void main(String[] args) {
		BaseBallGameDemo2 bbg = new BaseBallGameDemo2();
		int result = bbg.userInput("안녕");
		System.out.println("사용자가 입력한 값은 "+result);
	}

}
