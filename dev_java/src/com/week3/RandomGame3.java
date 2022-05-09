package com.week3;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomGame3 {
	public static void main(String[] args) throws Exception{
		Random rand = new Random();
		int randInt = rand.nextInt(10)+1;
		int limitLoop = 5;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("숫자를 입력해 주세요");
		for(int i=0;i<limitLoop;i++){
			int inputInt = Integer.parseInt(br.readLine());
			if(randInt == inputInt){
				System.out.println("정답입니다.");
				System.exit(0);
			}else if(randInt > inputInt){
				System.out.println("입력값이 작다");
			}else{
				System.out.println("입력값이 크다");
			}
			System.out.println();
		}//end of for
		System.out.println("모두 틀렸습니다.");
	}

}

