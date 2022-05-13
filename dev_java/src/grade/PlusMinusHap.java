package grade;

import java.util.Random;

public class PlusMinusHap {

	public static void main(String[] args) {
		Random r = new Random();
		int nums[] = new int[10];
		for (int i = 0; i < nums.length; i++) { 							
			nums[i] = r.nextInt(21)-10; 								
		}
		for(int num:nums) {
			System.out.println(num);
		}
	}

}

/*
-10에서 10사이의 정수 10개를 랜덤하게 채번하여  음수와 양수의 합계를 구하시오.
출력)
배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0

음수합 : -24
양수합 : 17
*/