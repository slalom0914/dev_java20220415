package com.day11;

import java.util.Scanner;

public class ScannerTest_1 {

	public static void main(String[] args) {
		//System - 사용자가 사용하는 PC
		//  in -  입력장치, 키보드, 마우스
		// out -  출력장치, 모니터, 프린터
		Scanner sc = new Scanner(System.in);// PC 에서 입력받은 값을 읽어올 때 사용하는  API
		
		while(true) {// while 반복문 1부터 5까지 센다
			System.out.println("0~9사이의 숫자를 입력하세요.");
			System.out.println(sc.next());
			// 사용자가 입력한 값을 어떻게 가져오나요? sc.next()
			if(sc.next().equals("q")) {
				//무한루프를 돌면 서버가 다운된다
				break;// while문을 탈출한다.
			}
		}//////end of while
		System.out.println("while문 탈출");
	}
}
