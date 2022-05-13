package com.day17;

public class BaseBallGameDemo1 {
	// 사용자가 입력한 숫자를 받는 코드
	public int userInput(String input) {
		int my = 0;
		// 예외가 발생할 가능성이 있는 코드
		try {
			my = Integer.parseInt(input);			
		} catch (NumberFormatException e) {
			System.out.println("제발 숫자만 입력하세요.");
		}
		//설령 문제가 발생하더라도 여기까지 진행됩니다.
		// 이것이 예외처리 하는 이유이다.
		//예외가 발생하더라도 프로그램이 중지하지 않고 다음으로 이동가능함.
		System.out.println("요기");
		return my;
	}
	public static void main(String[] args) {
		BaseBallGameDemo1 bbg = new BaseBallGameDemo1();
		int result = bbg.userInput("안녕");
		System.out.println("사용자가 입력한 값은 "+result);
	}

}
