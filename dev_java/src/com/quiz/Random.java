package com.quiz;

import java.util.Scanner;

public class Random {
	public static void main(String[] args) {
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
	}
}
