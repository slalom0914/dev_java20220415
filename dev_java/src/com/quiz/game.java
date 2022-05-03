package com.quiz;

import java.util.Scanner;
public class game {
	public static void main(String args[]) {
		
		int num = (int)(Math.random()*10)+1;
		int count = 5;		
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			--count;
			System.out.println("0~9사이의 숫자를 입력하세요>");
			int input = scanner.nextInt();
		
			if(num > input ) {
				if(count == 0) {
					System.out.println("틀렸습니다. 프로그램을 종료합니다.");
					break;}
				System.out.println("틀렸습니다. 더 큰 수를 입력하세요.(기회 :" + count + "번 남음)");
			}else if(num < input) {
					if(count == 0) {
						System.out.println("틀렸습니다. 프로그램을 종료합니다.");
						break;
					}
				System.out.println("틀렸습니다. 더 작은 수 를 입력하세요.(기회 " + count + "번 남음)");
			}else {
				System.out.println("정답입니다. ");
				break;
			}
		}while (count > 0);
	}
}
