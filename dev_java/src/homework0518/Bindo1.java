package homework0518;

import java.util.Random;

public class Bindo1 {
	int k;
	int nanSus[] = new int[100];
	int pCount[] = new int[10];

	public Bindo1() {
		Random random = new Random();
		System.out.printf("원본 : 	");
		for (int i = 0; i < 100; i++) {
			k = (int) (Math.random() * 10);
			nanSus[i] = k;
			System.out.printf("%3d", nanSus[i]);
			// System.out.print(nanSus[j]); 확인용
			if (i % 10 == 9)
				System.out.printf("\n        ");
		}

		System.out.printf("\n");
		System.out.print("숫자 :  ");
		for (int m = 0; m < pCount.length; m++) {

			System.out.print(m + "   ");
		}

		System.out.printf("\n");
		System.out.print("개수 :  ");
		for (int n = 0; n < nanSus.length; n++) {
			pCount[nanSus[n]]++;
		}
		// System.out.println(pCount[2]); 확인용
		for (int n = 0; n < pCount.length; n++) {
			System.out.print(pCount[n] + "  ");
		}
	}

	public static void main(String[] args) {
		new Bindo1();
	}
}