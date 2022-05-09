package com.dice;

import java.util.Random;
import java.util.Scanner;

public class RandomDiceAnswer {
	int random; // 랜덤 숫자 선언 

	Random ran = new Random(); // 랜덤 함수 생성
	Scanner scan = new Scanner(System.in); // 스캐너 함수 생성 
	
	public void gameStart() { // 게임을 시작했을 때 실행되는 메소드 
		random = ran.nextInt(9); // random 값 생성 (0~9 까지)
		//System.out.println("정답은 " + random + "입니다."); // 컴퓨터가 채번한 답
		
		int count = 5; // 횟수 부여
		
		while(true) { // while문 true일 때 반복 실행 
			int user = scan.nextInt(); // user가 입력한 숫자
			
			if(user != random && count == 1) {
				System.out.print("아쉽게도 실패했습니다.");
				System.out.println(" 정답은 " + random + "(이)였습니다. \n");
				break;
			} else if(user < random) {
				--count;
				System.out.print("더 높은 숫자입니다.");
				System.out.print(" 기회는 " + count + "번 남았습니다. \n> ");
			} else if(user > random) {
				--count;
				System.out.print("더 낮은 숫자입니다.");
				System.out.print(" 기회는 " + count + "번 남았습니다. \n> ");
			} else if(user == random) {
				// 기회가 1번 남았을 때 정답을 맞추면 실패했다는 오류가 발생
				System.out.println("축하합니다. 정답입니다. \n");
				break;
			}
		}

	}
}
