package com.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomGame4 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;
		int count = 5;
		int n = (int)(Math.random()*10)+1;
		while(true){
			System.out.println("0~9 중 숫자를 하나 입력해 주세요");
			input = Integer.parseInt(br.readLine());
			--count;
			if(input == n){
				System.out.println("정답입니다.");
				System.out.println("난수: "+n+"과 입력한 값 : "+input);
				System.exit(0);
			}else if(input > n){
				System.out.println("입력한 값 : "+input+"보다 난수가 작은 수 입니다.\t"+"남은 기회는 : "+count);
				if(count == 0){
					
					System.out.println("꽝 다음 기회를");
					System.exit(0);
				}
			}else if(input < n){
				System.out.println("입력한 값 : "+input+"보다 난수가 큰 수 입니다.\t"+"남은 기회는 : "+count);
				if(count == 0){
					System.out.println("꽝 다음 기회를");
					System.exit(0);
				}
			}					
		}//end of while
	}
}
