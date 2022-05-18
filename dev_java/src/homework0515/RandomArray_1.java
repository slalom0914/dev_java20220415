package homework0515;

import java.util.Random;

public class RandomArray_1 {
	int[] Array = new int[10];
	int n = Array.length;
	int i;

	public RandomArray_1() {
		n += -1;
		System.out.println("[-10부터 10까지 랜덤정수 10개를 배열에 담습니다.]");
		for (i = 0; i <= n; i++) {
			Array[i] = (int) (Math.random() * 21) - 10;
			System.out.print(Array[i] + ", ");
		}
	}

	public void hap() {
		System.out.println("\n[채번된 정수와 일치하는지 확인하세요.]");
		for (i = 0; i <= n; i++) {
			System.out.print(Array[i] + ", ");
		}
		System.out.println();
		int plushap = 0;
		int minushap = 0;
		for (i = 0; i <= n; i++) {
			if (Array[i] >= 0) {
				System.out.print(plushap + " + " + Array[i] + " = ");
				plushap += Array[i];
				System.out.println(plushap);
			} else {
//				System.out.print(minushap + " + " + Array[i] + " = ");
				minushap += Array[i];
//				System.out.println(minushap);
			}
		}
		System.out.println("양수의 합은 : " + plushap);
		System.out.println("음수의 합은 : " + minushap);

	}
}
