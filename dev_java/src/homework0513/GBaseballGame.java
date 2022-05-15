package homework0513;

import java.util.Scanner;

public class GBaseballGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] user = new int[1]; // 컴퓨터가 랜덤으로 뽑을 숫자 3개를 담을 배열
		int[] userArr = new int[3]; // 사용자가 직접 입력한 세자리 숫자의 각 자릿수를 담을 배열
		int[] comArr = new int[3]; // 사용자가 직접 입력할 숫자 3개를 담을 배열

		boolean isOk = false;

		int userInput = 0; // 사용자가 입력하는 숫자
		int ball = 0, strike = 0; // ball과 strike 변수 초기화 (userArr와 comArr 배열의 인덱스를 비교하여 답을 출력하는 데에 사용)

		System.out.print("** 세자리 숫자를 입력해주세요. \n> ");

		while (!isOk) {
			userInput = scan.nextInt();
			if (100 > userInput || userInput > 999) {
				System.out.print("** 세자리 숫자만 입력해주세요. \n> ");
				continue;
			} else if (100 <= userInput && userInput <= 999) {
				for (int i = 0; i < user.length; i++) {
					// System.out.println("user [" + i + "] = " + userInput);

					userArr[0] = userInput / 100; // 백의 자리
					userArr[1] = (userInput % 100) / 10; // 십의 자리
					userArr[2] = userInput % 10; // 일의 자리
				}
				/*
				 * // userArr 배열의 인덱스 출력하여 확인하기 for (i = 0; i < userArr.length; i++) {
				 * System.out.println("userArr [" + i + "] = " + userArr[i]); // userArr 배열의 인덱스
				 * 출력 }
				 */
				System.out.println("\r" + "** 랜덤 숫자 3개 입니다.");
				for (int i = 0; i < comArr.length; i++) {
					int ranCom = (int) (Math.random() * 10); // 랜덤 숫자를 배열의 길이(3)만큼 채번
					comArr[i] = ranCom; // 랜덤으로 채번된 숫자 3개를 각 인덱스에 넣기

					/*
					 * // 랜덤으로 채번한 숫자의 중복을 제거 for(int j=0; j<comArr.length; j++) { if(comArr[j] ==
					 * userArr[i]) { i--; } }
					 */

					// comArr 배열의 인덱스를 출력하여 확인하기
					System.out.println("comArr [" + i + "] = " + ranCom); // comArr 배열의 인덱스 출력
				}
				// userArr 배열과 comArr 배열을 비교
				for (int i = 0; i < userArr.length; i++) {
					for (int j = 0; j < comArr.length; j++) {
						if ((userArr[i] == comArr[j]) && (i == j)) {
							strike++;
						} else if ((userArr[i] == comArr[j]) && (i != j)) {
							ball++;
						}
					}
				}
				System.out.println(ball + "볼 " + strike + "스트라이크");
			} else {
				System.out.print("제발 세자리 숫자만 읿력하세요. \n> ");
				continue;
			}
		}
	}

}
