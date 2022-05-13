package com.day17;

import java.util.Scanner;

public class BaseBallGameDemo4 {
	int my[] = new int[3];
	//컴터가 채번한 숫자를 담을 배열 선언 - 전변으로 처리해 보기
	int com[] = new int[3];
	//0부터 9사이의 중복을 제거하는 3자리 숫자 채번하기
	public void nanSu() {
		// 0.0~1.0 -> 0.0~10.0
		com[0] = (int)(Math.random()*10);
		do {
			com[1] = (int)(Math.random()*10);			
		}while(com[0]==com[1]);
		do {
			com[2] = (int)(Math.random()*10);			
		}while(com[0]==com[2] || com[1]==com[2]);
	}
	// 파라미터를 String으로 했니? - 왜냐하면 화면에서 입력 받을 때 숫자를 쳐도 문자열로 취급 되니까  "245"
	public String account(String input) {
		System.out.println("사용자가 입력한 값 받아오기 : "+input);
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
		my[0] = temp/100;// 579/100=5.79=> 5 -백의자리
		my[1] = (temp%100)/10;// 7
		my[2] = temp%10;//57.9===> 9 - 일의 자리
		for(int val:my) {
			System.out.println(val);
		}
		return "1스 0볼";
	}
	public static void main(String[] args) {
		BaseBallGameDemo4 bbg = new BaseBallGameDemo4();
		Scanner scan = new Scanner(System.in);
		System.out.println("0부터 9까지 세자리 숫자를 입력하세요.");
		String result = bbg.account(scan.next());
		System.out.println("판정 결과 : "+result);
	}
}
