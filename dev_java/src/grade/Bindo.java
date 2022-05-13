package grade;

import java.util.Random;

public class Bindo {

	public static void main(String[] args) {
		int nums[] = new int[100];
		Random r = new Random();
		for(int i=0;i<100;i++) {
			nums[i] = r.nextInt(10);
		}
		for(int num:nums) {
			System.out.println(num);
		}
	}

}

/*
 2. 0 부터 9사이의 임의의 수를 100개를 채번하여 한 줄에 10개씩
    출력하고 그 숫자의 빈도수를 계산하여 출력하시오

 원본 :  0 1 2 3 4 5 6 7 8 9
         2 5 6 8 7 8 9 0 1 1
         5
         3
         3
         7
         9
         2
         0 4 5 6 6 7 8 8 9 9

 숫자 : 0  1  2  3  4  5  6  7  8  9
 갯수 : 10 9  18 11 7  9  15 14 7  5
*/