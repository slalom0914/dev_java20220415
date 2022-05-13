package com.day17;

public class BaseBallGameDemo3 {
	public String account(String input) {
		// length:배열의 원소갯수
		// length():문자열의 갯수
		if(input.length() !=3) {
			//반복문을 탈출할 때는 break;
			//조건문을 탈출시는 return
			return "세자리 숫자를 입력하세요.";
		}
		int temp = 0;
		try {
			temp = Integer.parseInt(input);	
		} catch (NumberFormatException ex) {
			return "숫자만 입력하세요.";
		}
		return "1스 0볼";
	}
	public static void main(String[] args) {
		BaseBallGameDemo3 bbg = new BaseBallGameDemo3();
		String result = bbg.account("안녕3");
		System.out.println("판정 결과 : "+result);
	}
}
