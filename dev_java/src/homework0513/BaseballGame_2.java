package homework0513;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame_2 {
	int ComNum;
	int myNum;
	int[] ComNumArr = new int[4];
	int[] myNumArr = new int[4];
	int ball;
	int strike;

	public void ComRandom() { // 컴퓨터 난수 추출+중복값 아닐 때까지 돌리기
		boolean r = false;
		int test = 0;
		do {
			ComNum = (int) (Math.random() * 9000) + 1000; // 난수 받아 오기
			int temp = ComNum;
			for (int i = 3; i >= 0; i--) { // 난수 배열에 하나씩 넣기
				ComNumArr[i] = (int) (temp % 10);
				temp = temp / 10;
			}
//			System.out.println("컴퓨터 난수: " + ComNum);

			loop: for (int i = 0; i < ComNumArr.length; i++) { // 중복 있나 확인. 중복 하나라도 있으면 test++ 하고 루프 빠져나옴.
				for (int j = i + 1; j < ComNumArr.length; j++) {
					if (ComNumArr[i] == ComNumArr[j]) {
//						System.out.println(i + "와 " + j + "는 같다");
						test++;
						break loop;
					}
				}
			}
			if (test == 0) { // test가 0이면(중복이 없으면) r true... 잘한 거... 중복 없는 거로 바꾸고 와일문 종료시키기
				r = true;
			} else { // 중복 있으면 난수 다시 받을 때 비교도 다시 해야 하므로 test 0으로 초기화
				test = 0;
			}
		} while (r == false); // r이 false일 때... 중복 있는 건 잘못이니까 false라고 하기
	}

	public void inputNum() {
		System.out.println("네 자리 숫자를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		myNum = scanner.nextInt();
		if (myNum < 1000 || myNum > 10000) { // 내가 입력한 숫자가 범위 밖일 때
			System.out.println("범위 내의 숫자를 입력하세요.");
//			Scanner scanner = new Scanner(System.in);
			myNum = scanner.nextInt();
		}

		boolean r = false;

		do {
			int temp = myNum;
			for (int i = 3; i >= 0; i--) { // 내가 입력한 숫자 배열에 넣기
				myNumArr[i] = (int) (temp % 10);
				temp = temp / 10;
			}
			int test = 0;
			loop: for (int i = 0; i < myNumArr.length; i++) { // 중복 있나 확인. 중복 하나라도 있으면 test++ 하고 루프 빠져나옴.
				for (int j = i + 1; j < myNumArr.length; j++) {
					if (myNumArr[i] == myNumArr[j]) {
//					System.out.println(myNumArr[i] + "와 " + myNumArr[j] + "는 같다");
						test++;
						break loop;
					}
				}
			} // end of loop
			if (test == 0) { // test가 0이면(중복이 없으면) r true로 바꾸고 와일문 종료시키기
				r = true;
			} else { // 중복 있으면 난수 다시 받을 때 비교도 다시 해야 하므로 test 0으로 초기화
				test = 0;
				System.out.println("중복이 없는 숫자를 입력하세요.");
				myNum = scanner.nextInt();
			}
		} while (r == false);

//		System.out.println("내 입력값: " + myNum);
	}

	public void comparison() {
		strike = 0;
		ball = 0;
		for (int i = 0; i < ComNumArr.length; i++) { // com이랑 my 자리마다 비교하는 for문
			for (int j = 0; j < myNumArr.length; j++) {
				if (ComNumArr[i] == myNumArr[j]) { // 배열 하나씩 비교
					if (i == j) { // 같은 자리면
						strike++;
					} else if (i != j) { // 다른 자리면(그냥 엘즈로 해도 되는데 확인차)
						ball++;
					}
				} else { // 확인차
				}
			}
		}
		System.out.println("Strike: " + strike);
		System.out.println("Ball: " + ball);

		if (strike == 4) {
			System.out.println("Homerun");
		} else if (strike == 0 && ball == 0) {
			System.out.println("Out");

		}
	}

	public static void main(String[] args) {
		BaseballGame_2 bg = new BaseballGame_2();
		int chance = 0;
		bg.ComRandom();
		do {
			bg.inputNum();
			bg.comparison();
			chance++;
		} while (bg.strike != 4); // s가 4면 홈런이므로 while문 종료되고 안 돌아감. 홈런 될 때까지 돌리는 거라 조건문 이렇게...
		System.out.println("도전 횟수: " + chance);
	}

}
