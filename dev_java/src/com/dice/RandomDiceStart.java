package com.dice;

import java.util.Scanner;

public class RandomDiceStart {

	public static void main(String[] args) { // 메인 메소드 
		RandomDiceAnswer rds = new RandomDiceAnswer();

		Scanner scan = new Scanner(System.in); // 스캐너 함수 생성 
		
		System.out.println("========== Random Dice ==========");
		System.out.print("게임을 시작하시겠습니까? 1.Yes 2.No \n> ");
		
		while(true) {
			String yOrN = scan.nextLine(); 
			
			if(yOrN.equals("2")) {
				System.out.println("\n게임을 종료합니다.");
				break;
				// 게임을 다시 권유하는 코드 추가하고 싶음.
			} else if(yOrN.equals("1")) {
				System.out.println("\n게임을 시작합니다.");
				System.out.print("0부터 9까지의 숫자를 입력하세요. 기회는 5번 입니다. \n> ");
				// 여기에 gameStart 메소드 추가
				rds.gameStart(); // 게임 시작 메소드 
			} else {
				System.out.println("\n잘못된 숫자입니다. 다시 입력해주세요! 1.Yes 2.No \n> "); // 다시 앞으로 돌아가야하는데,,, 모르겠음.. 그래서 배우지 않은 continue를 사용해봄 
				continue;
			}
			System.out.print("다시 시작하시겠습니까? 1.Yes 2.No \n> ");
		}	
	}			

}