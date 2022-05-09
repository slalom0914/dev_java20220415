package com.dice;

import java.util.Scanner;
import java.util.Random;
/////////////////////////////////////////////////// Random Dice 2 ///////////////////////////////////////////////////
//////////////////////// 게임 시작 묻기 - 기회 부여 - 숫자 입력 후 성공 여부 묻기 - 정답 공개하기 - 게임 종료 ////////////////////////
////////////////////////////////////////////////////// 코드 줄이기 ////////////////////////////////////////////////////

public class RandomDice5_edit {
	public void newGame() {
		System.out.println("newGame 호출 성공");
		Random ran = new Random(); // 랜덤 함수 생성 
		Scanner scan = new Scanner(System.in); // 스캐너 함수 생성 
		
		System.out.println("========== Random Dice ==========");
		System.out.println("게임을 시작하시겠습니까? 1.Yes 2.No");
		
		while(true) {
			String yOrN = scan.nextLine();
			
			if(yOrN.equals("2")) {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			} else if(yOrN.equals("1")) {
				System.out.println("게임을 시작합니다.");
				System.out.println("0부터 9까지의 숫자를 입력하세요. 기회는 5번 입니다.");
				int count = 5; // 카운트를 while문 바깥에 두니 성공함 ! 왜지 ?
				int answer = ran.nextInt(10);
				// 랜덤 숫자 확인
                System.out.println(answer);
				
				while(true) {
//					if(yOrN.equals("1")) {
					int user = scan.nextInt();
					
					if(count == 0) {
						System.out.println("아쉽게도 실패했습니다.");
						System.out.println("정답은 " + answer + "(이)였습니다.");
						System.exit(0);
					} else if(user < answer) {
						count--;
						System.out.print("더 높은 숫자입니다.");
						if(count == 0) break;
						System.out.println(" 기회는 " + count + "번 남았습니다.");
					} else if(user > answer) {
						count--;
						System.out.print("더 낮은 숫자입니다.");
						if(count == 0) break;
						System.out.println(" 기회는 " + count + "번 남았습니다.");
					} else if(user == answer) {
						// 기회가 1번 남았을 때 정답을 맞추면 실패했다는 오류가 발생
						System.out.println("축하합니다. 정답입니다.");
						System.exit(0);
					}
//					} 
				}////////////// end of inner while
				System.out.println("아쉽게도 실패했습니다.");
				System.out.println("정답은 " + answer + "(이)였습니다.");	
				System.out.println("========== Random Dice ==========");
				System.out.println("다시 게임을 시작하시겠습니까? 1.Yes 2.No");
				String newGame = scan.next();
				if("1".equals(newGame)) {
					newGame();
					break;
				}
			} else /* if (!(yOrN.equals("1")) && yOrN.equals("2")) */{
				System.out.println("잘못된 숫자입니다. 다시 입력해주세요! 1.Yes 2.No"); // 다시 앞으로 돌아가야하는데,,, 모르겠음.. 그래서 배우지 않은 continue를 사용해봄 
				continue;
			}
		}
	}/////////////////// end of newGame
	public static void main(String[] args) { // 메인 메소
		RandomDice5_edit r5 = new RandomDice5_edit();
		Random ran = new Random(); // 랜덤 함수 생성 
		Scanner scan = new Scanner(System.in); // 스캐너 함수 생성 
		
		System.out.println("========== Random Dice ==========");
		System.out.println("게임을 시작하시겠습니까? 1.Yes 2.No");
		
		while(true) {
			String yOrN = scan.nextLine();
			
			if(yOrN.equals("2")) {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			} else if(yOrN.equals("1")) {
				System.out.println("게임을 시작합니다.");
				System.out.println("0부터 9까지의 숫자를 입력하세요. 기회는 5번 입니다.");
				int count = 5; // 카운트를 while문 바깥에 두니 성공함 ! 왜지 ?
				int answer = ran.nextInt(10);
				// 랜덤 숫자 확인
                System.out.println(answer);
				
				while(true) {
//					if(yOrN.equals("1")) {
					int user = scan.nextInt();
					
					if(count == 0) {
						System.out.println("아쉽게도 실패했습니다.");
						System.out.println("정답은 " + answer + "(이)였습니다.");
						System.exit(0);
					} else if(user < answer) {
						count--;
						System.out.print("더 높은 숫자입니다.");
						if(count == 0) break;
						System.out.println(" 기회는 " + count + "번 남았습니다.");
					} else if(user > answer) {
						count--;
						System.out.print("더 낮은 숫자입니다.");
						if(count == 0) break;
						System.out.println(" 기회는 " + count + "번 남았습니다.");
					} else if(user == answer) {
						// 기회가 1번 남았을 때 정답을 맞추면 실패했다는 오류가 발생
						System.out.println("축하합니다. 정답입니다.");
						System.exit(0);
					}
//					} 
				}////////////// end of inner while
				System.out.println("아쉽게도 실패했습니다.");
				System.out.println("정답은 " + answer + "(이)였습니다.");	
				System.out.println("========== Random Dice ==========");
				System.out.println("다시 게임을 시작하시겠습니까? 1.Yes 2.No");
				String newGame = scan.next();
				if("1".equals(newGame)) {
					r5.newGame();
					break;
				}
			} else /* if (!(yOrN.equals("1")) && yOrN.equals("2")) */{
				System.out.println("잘못된 숫자입니다. 다시 입력해주세요! 1.Yes 2.No"); // 다시 앞으로 돌아가야하는데,,, 모르겠음.. 그래서 배우지 않은 continue를 사용해봄 
				continue;
			}
		}	
	}			

}
