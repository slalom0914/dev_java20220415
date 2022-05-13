package grade;

import java.util.Random;

public class Jumsu_2 {
	Random r = new Random();
	int    tot; 			 	   											// 총점 변수
	double avg;		 			   											// 평균 점수
	int    Jumsu_2[] = new int[5]; 											// 배열에 담은 변수 개수(?)
	int    i;																// 반복변수
	
	public Jumsu_2(int i) {
		int rdjumsu;    												    // 랜덤점수 담는 변수
		for (i = 0; i < 5; i++) { 											// 5번 반복
			rdjumsu = r.nextInt(101); 										// 랜덤점수 발생
				System.out.println("랜덤정수 발생 : " + rdjumsu); 			    // 랜덤정수 출력
			Jumsu_2[i] = rdjumsu; 											// 각 배열위치에 랜덤점수를 배치
				System.out.println(i + "번 째 배열 : " + Jumsu_2[i] + "\n");	// i번째 배열의 랜덤점수 출력
		}
	}///////////////////////////////////////////////////////////////////////[end of Jumsu_2 construtor]
	public int tot(int i,int tot) {
		this.i = 0;															// i == 5 → i = 0 초기화
		while (i < 5) {														// while 반복문
			this.tot += Jumsu_2[i]; 								// 총점구하는 식	
			System.out.println(i + " 번째 더하기" + this.tot); 					// n번째 누적 수 출력
			i++;   
		}
		System.out.println("총점 : " + this.tot);   							// 총점 출력
		return this.tot;
	}///////////////////////////////////////////////////////////////////////[end of tot method]
	
	public double avg(double avg) {
		avg = (double)tot / 5.0;											// 평균
		System.out.println("평균 : " + avg);									// 평균점수 출력
		return avg;
	}///////////////////////////////////////////////////////////////////////[end of avg mehod]

}///////////////////////////////////////////////////////////////////////////[end of class Jumsu_2]
