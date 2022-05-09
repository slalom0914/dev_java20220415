package baseball;

import java.util.Scanner;

// 사용자 입력 클래스 (재상용성 높이고 변경에 유리하도록 작성)
public class User_Input {
	private int arrNum;
	// 사용자 입력 메소드

	User_Input() { // 기본 입력값 1개는 있도록
		this.arrNum = 1;
	}

	User_Input(int arrNum) {
		this.arrNum = arrNum;
	}

	// 사용자 입력값 배열로 받기
	public int[] user_Enter() { // 재사용성을 위해 try-catch문은 main으로 뺌
		int[] input = new int[arrNum]; // 사용자값 배열로 받기
		String[] words = new String[arrNum];
		Scanner sc = new Scanner(System.in);

		words = (sc.nextLine().replaceAll(" ", "")).split(""); // 한줄에 입력받기, 사용자 실수에 의한 공백 예외 replaceAll로 처리
		for (int i = 0; i < arrNum; i++) {
			input[i] = Integer.valueOf(words[i]);
			} 
		return input;

	}// end of Enter()

	public String help_Enter() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

}// end of User_Input
