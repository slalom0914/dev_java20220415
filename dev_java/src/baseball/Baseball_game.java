package baseball;

import java.util.Arrays;

public class Baseball_game {
	private int strike;
	private int ball;
	private int[] random;

	// 재사용성 높인 클래스들 Baseball_game()에서 사용
	public Baseball_game() {
		Random random_number = new Random(3); // 랜덤 클래스의 인덱스값(iv) 3으로 초기화
		this.random = random_number.auto_random(); // 랜덤 배열길이 3인 배열 생성
		explain();
	}
	// 게임 규칙
	public void account() {

		do {
			ball = 0;
			strike = 0;
			int[] input;
			User_Input ip = new User_Input(3); // 입력값 배열 3으로 생성
			input = ip.user_Enter();
			
			for (int i = 0; i < random.length; i++) {
				for (int j = 0; j < input.length; j++) {
					if (random[i] == input[j] && i == j) {
						strike++;
						if (strike == 3) {
							System.out.println("--------------------");
							System.out.printf("%d | %d | %d | %dS | %dB%n", input[0], input[1], input[2], strike, ball);
							System.out.println("--------------------");
							System.out.println("정답입니다. 프로그램을 종료합니다");
							System.exit(0);
						}
					} else if (random[i] == input[j] && i != j) {
						ball++;
					}
				}
			}
			System.out.println("--------------------");
			System.out.printf("%d | %d | %d | %dS | %dB%n", input[0], input[1], input[2], strike, ball);
			System.out.println("--------------------");
		} while (strike != 3);

	}// end of account

	public void explain() {
		while (true) {
			System.out.println("--------------");
			System.out.println("밑의 명령어 입력시 동작");
			System.out.println("1: 게임시작");
			System.out.println("2: 정답 미리보기");
			System.out.println("3: 프로그램 종료");
			System.out.print("--------------");
			String input;
			User_Input ip = new User_Input();
			input = ip.help_Enter();

			if (input.equals("1")) {
				System.out.println("베이스볼 게임에 오신것을 환영합니다. 게임을 시작합니다:)");
				System.out.println("0~9사이의 숫자 3개를 중복없이 한줄에 입력하세요.");
				System.out.println("게임은 맞출 때 까지 진행 됩니다.");
				break;
			} else if (input.equals("2")) {
				System.out.println("정답은 " + Arrays.toString(random) + " 입니다.");
				continue;

			} else if (input.equals("3")) {
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			} else {
				System.out.print("명령어 입력 오류!!\n(1)~(3)까지의 명령어만 입력 하세요\n");
			}
		} // end of while()
	}// end of explain
}// end of Baseball_game class
