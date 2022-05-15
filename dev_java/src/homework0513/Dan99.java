package homework0513;

import java.util.Scanner;

public class Dan99 {

	public void forx(int fDan, int lDan) {
		for (int i = fDan; i <= lDan; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + "*" + j + "=" + i * j);
			}

		}
	}

	public void whilex(int fDan, int lDan) {
		int i = fDan;
		while (i <= lDan) {
			int j = 2;
			while (j <= 9) {
				System.out.println(i + "*" + j + "=" + i * j);
				j++;
			}
			i++;
		}

	}

	public static void main(String[] args) {
		Dan99 d = new Dan99();
		Scanner scanner = new Scanner(System.in);
		System.out.println("몇 단부터 시작할 건지?");
		int fDan = scanner.nextInt();
		System.out.println("몇 단까지 출력할 건지?");
		int lDan = scanner.nextInt();
		d.forx(fDan, lDan);
		d.whilex(fDan, lDan);
	}

}
