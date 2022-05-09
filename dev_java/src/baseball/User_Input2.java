package baseball;

import java.util.Scanner;

// 사용자 입력 클래스 (재상용성 높이고 변경에 유리하도록 작성)
public class User_Input2 {
	private int arrNum;
	// 사용자 입력 메소드

	User_Input2() { // 기본 입력값 1개는 있도록
		this.arrNum = 1;
	}

	User_Input2(int arrNum) {
		this.arrNum = arrNum;
	}

	// 사용자 입력값 배열로 받기
	public int[] user_Enter() { // 재사용성을 위해 try-catch문은 main으로 뺌
		int[] input = new int[arrNum]; // 사용자값 배열로 받기
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		input[0]=temp/100;
		input[1]=(temp%100)/10;
		input[2]=temp%10;
		return input;
	}// end of Enter()

	public String help_Enter() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

}// end of User_Input
