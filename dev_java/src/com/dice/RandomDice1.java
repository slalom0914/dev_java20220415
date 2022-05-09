package com.dice;

import java.util.Scanner;
import java.util.Random;
/////////////////////////////////////////////////// Random Dice 1 ///////////////////////////////////////////////////
/////////////////////////////////// 게임 시작 묻기 - 숫자 입력 후 성공 여부 묻기 - 게임 종료 ////////////////////////////////////
public class RandomDice1 {

	public static void main(String[] args) {
		
		Random ran = new Random();
		int answer = ran.nextInt(10);
		
		Scanner scan = new Scanner(System.in);
		
		String str = null;
		
		System.out.println("==========Random Dice==========");
		System.out.println("게임을 시작하시겠습니까? 1.Yes 2.No");
		
		while((str=scan.next()) !=null) {
			if(str.equals("1")) {
				System.out.println("게임을 시작합니다.");
				break;
			} else if(str.equals("2")) {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			}
		}
		
		System.out.println("0부터 9까지의 숫자를 입력하세요.");
		int input = scan.nextInt();
		
		while(true) {
			if(input == answer) {
				System.out.println("정답입니다.");
				break;
			} else if(input < answer) {
				System.out.println("더 높은 숫자입니다.");
				input = scan.nextInt();
			} else if(input > answer) {
				System.out.println("더 낮은 숫자입니다.");
				input = scan.nextInt();
			} 
		} 
		
		while(true) {
			if (input == answer) {
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
		
	}
​
}
