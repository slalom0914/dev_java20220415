package homework0513;

import java.util.Scanner;

//전역변수 초기화 
public class BaseballGame3_2 {
	Scanner scan = new Scanner(System.in);

	boolean isStop;

	int userInput;
	int ball, strike, out;
	int count;

	int[] userArr = new int[3]; // 사용자가 직접 입력한 세자리 숫자의 각 자릿수를 담을 배열
	int[] comArr = new int[3]; // 사용자가 직접 입력할 숫자 3개를 담을 배열

	// 야구게임 시작(컴퓨터가 랜덤으로 채번한 숫자를 배열에 저장) 및 종료 여부를 결정하는 메소드
	public void gameStart() {

		System.out.println("========== Baseball Game ==========");
		System.out.print("게임을 시작하시겠습니까? (y/n) \n> ");

		// String yN = scan.nextLine();

		while (!isStop) {

			String yN = scan.nextLine();

			switch (yN) {
			case "n":
				System.out.println("\r게임을 종료합니다.");
				break;
			case "y":
				System.out.print("\r게임을 시작합니다.\n");

				// 컴퓨터가 채번하는 랜덤 숫자 3개
				// System.out.println("\r" + "랜덤 숫자 3개 입니다.");
				for (int i = 0; i < comArr.length; i++) {
					comArr[i] = (int) (Math.random() * 9 + 1); // 랜덤 숫자를 배열의 길이(3)만큼 첫번째 인덱스 0을 제외하고 채번

					// 랜덤으로 채번한 숫자의 중복을 제거
					for (int j = 0; j < i; j++) {
						if (comArr[i] == comArr[j]) {
							i--;
						}
					}

					// 컴퓨터가 랜덤으로 채번한 숫자의 각 인덱스를 확인
					// System.out.println("comArr [" + i + "] = " + comArr[i]);
				}
			}
			break;
		}

	}

	// 사용자가 입력하는 세자리 숫자를 배열에 저장
	public void gameArray() {

		while (!isStop) {

			System.out.print("\r세자리 숫자를 입력해주세요. \n> ");

			userInput = scan.nextInt();

			if (100 > userInput || userInput > 999) {
				System.out.println("세자리 숫자만 입력해주세요.");
				continue;
			} else if (100 <= userInput && userInput <= 999) {
				for (int i = 0; i < 1; i++)

					// 사용자가 입력한 세자리 숫자를 각 자릿수를 출력하여 userArr 배열에 담기
					userArr[0] = userInput / 100; // 백의 자리
				userArr[1] = (userInput % 100) / 10; // 십의 자리
				userArr[2] = userInput % 10; // 일의 자리

				/*
				 * // userArr 배열의 각 인덱스에 담긴 숫자를 확인 for (int i = 0; i < userArr.length; i++) {
				 * System.out.println("userArr [" + i + "] = " + userArr[i]); // userArr 배열의 인덱스
				 * 출력 }
				 */

				for (int i = 0; i < userArr.length; i++) {
					for (int j = 0; j < comArr.length; j++) {
						if ((userArr[i] == comArr[j]) && (i == j)) {
							strike++;
						} else if ((userArr[i] == comArr[j])) {
							ball++;
						} else if (!(userArr[i] == comArr[j]) && (i == j)) {
							out++;
						}
					}
				}
				System.out.println("결과 ==> " + ball + "볼 " + strike + "스트라이크 " + out + "아웃");

				if (strike == 3) {
					System.out.print("축하합니다. 정답입니다. ");
					System.out.println(count + "회만에 성공하셨습니다.");
					break;
				} else if (strike < 3) {
					System.out.println("정답이 아닙니다. 다시 시도해보세요.");
					count++;
				}
			}
			ball = 0;
			strike = 0;
			out = 0;
		}
		return;
	}

	public static void main(String[] args) {
		BaseballGame3_2 b3 = new BaseballGame3_2();
		b3.gameStart();
		b3.gameArray();
	}

}
