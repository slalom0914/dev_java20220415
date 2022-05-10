package com.week4;

import java.util.Random;

/*********************************************************************************
 * 오라클 성적을 난수 발생을 통해서 5개 받아서 총점과 평균 구하기 
 *
 *
 *********************************************************************************/
public class OracleJumsu {
	
	public static void main(String[] args) {
		//사용자가 입력한 점수를 받을 배열 선언하고 생성하기
		int jumsu[] = new int[5];
		//5개의 임의의 점수를 입력 받아야 하므로 반복문 사용하기
		for(int i=0;i<5;i++){
			Random r = new Random();
			jumsu[i] = r.nextInt(101);
			System.out.println(jumsu[i]);
		}
		//총점 구하기 - 변수 선언
		int tot = 0;
		for(int j=0;j<5;j++){
			tot = tot + jumsu[j];
		}
		System.out.println("총점 : " + tot);
		//평균 구하기 - 변수 선언
		double avg = 0.0;
		avg = tot/5.0;
		System.out.println("평균 : " + avg);
	}////////////// end of main
}////////////////// end of OracleJumsu
