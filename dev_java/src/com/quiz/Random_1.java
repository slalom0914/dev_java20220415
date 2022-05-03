package com.quiz;

import java.util.Scanner;
/* 
 *  와 for문과 if문을 정식으로 배운게 아닌데도 게임 규칙을 잘 적용했네요.
 *  for문에서 세번째 자리가 증감연산자를 쓰는 자리인데 그 자리를 비워놓고
 *  힌트문을 주는 조건문 안에서 chance++ 한 표현이 인상적 입니다.
 *  혹시 좀 더 개선해 보고 싶은 관심이 있다면 가능하다면 main메소드 안에 코딩하는 양을 줄여 보면 어떨까 생각해 보았습니다.
 *  main메소드는 개발자가 호출하는 메소드가 아니라 콜백 메소드 즉 JVM이 호출하는 메소드 이므로 개발자의 생각대로 
 *  조작하는데 제약이 있을 수 있기 때문입니다.
 *  그래서 아래 예시를 붙여 보았습니다.
 *  (추신 : 좀 더 성장시키기 위해서 잘 한 부분을 이야기 하기 보다는 일부러 딴지를 걸어 보는 피드백으로 할께요^^)
 */
public class Random_1 {
	public void goGame() {
		int random = (int)(Math.random()*10);
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
		Random_1 r1 = new Random_1();
		r1.goGame();
	}//////////////// end of main 
}
