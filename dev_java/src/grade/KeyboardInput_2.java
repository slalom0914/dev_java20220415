package grade;

import java.util.Scanner;

public class KeyboardInput_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nansu[] = new int[5];
		int i = 0;
		while(i<5) {
			System.out.println(i+"번째 숫자를 입력하세요.");
			nansu[i] = scan.nextInt();
			i++;
		}
		for(int j=0;j<5;j++){
			System.out.println(nansu[j]);
		}
	}

}

/*
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
at grade.KeyboardInput.main(KeyboardInput.java:13)
*/