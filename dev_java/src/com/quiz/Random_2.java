package com.quiz;

import java.util.Scanner;
/* 
 *  1-2에서는 새 게임을 시작할 때 컴퓨터가 채번하는 메소드를 따로 만들어 보면 좋을 거 같습니다.
 *  만일 화면이 제공되는 게임을 상상해 보고 게임 화면에 새게임이라는 버튼이 있다고 생각해 보면 어떨까요?
 *  재사용성을 높이는 코드를 작성하는 첫 단추가 메소드 중심의 코딩을 전개하는 것이라 생각하고 연습했던 기억이 나에게도 있습니다.
 *  민지씨도 그렇게 좀 더 깊은 고민을 해 보면 좀 더 시야를 넓혀 나아갈 수 있다고 생각 됩니다.
 *  자 도전해 보시죠
 */
public class Random_2 {
	int random;
	// 새 게임이 눌렸을 때 호출 되어야 할 메소드 선언하기
	// 다섯번 만에 답을 못 맞추었을 때 새로운 숫자로 다시 시작해보는 상상을 해보세요
	// 이 경우 컴터가 채번한 숫자는 전역변수로 해야 할까요? 아님 지역변수로 해야 할까요? 
	// 판단할 수 있는 기준에 대해 생각해 보면 좋을 거 같습니다.
	public void newGame() {
		random = (int)(Math.random()*10);
	}
	public void goGame() {
		System.out.println("0~9 사이의 숫자를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		int scan = scanner.nextInt();
		int chance=0;
		
		for(chance=0;chance<5;) {
		if (scan == random) {
			System.out.println("정답은 " + random + "입니다.");
			break;
		}
		else if (scan > 9 || scan < 0) {
			System.out.println("범위 내의 값을 입력해 주세요.");
			chance++;
			System.out.println("기회: "+ (5 - chance));
		}
		else if (scan > random) {
			System.out.println("Down");
			chance++;
			System.out.println("기회: "+ (5 - chance));
		}
		else if (scan < random) {
			System.out.println("Up");
			chance++;
			System.out.println("기회: "+ (5 - chance));
		}
		if (chance!=5) {scan = scanner.nextInt();}
		}		
	}//////////////// end of goGame
	public static void main(String[] args) {
		Random_2 r1 = new Random_2();
		// 컴퓨터가 채번한 숫자를 맞추는 게임이므로 goGame메소드가 호출되기 전에 
		// newGame이 먼저 호출되어야 합니다.
		r1.newGame();
		r1.goGame();
	}//////////////// end of main 
}
