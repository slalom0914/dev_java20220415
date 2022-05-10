package com.week4;

/********************************************************************************
 * 재사용성과 이식성을 높이는 코딩을 전개한다.
 * 재사용성을 높이는 첫번째 단계가 메소드 중심의 코딩을 전개하는 것이다.
 * 1)리턴타입을 활용할 수 있다.
 * 2)파라미터를 활용할 수 있다.
 *
 *******************************************************************************/
public class SungJukArray {

	public static void main(String[] args) {
int score[][] = {
		 {100,90,80}
		,{85,90,80}
		,{70,70,80}
		,{90,60,65}
		,{65,80,70}
};
		int imsi[][] = new int[5][2];//총점과 석차를 담을 2차배열
		double avg[] = new double[5];//평균은 실수타입이므로 별도의 1차배열의 선언
		for(int i=0;i<score.length;i++)
		{
			int tot = score[i][0]+score[i][1]+score[i][2];
			imsi[i][0] = tot;
			avg[i] = Math.round(tot/3.0);
			imsi[i][1] = 1;//석차를 1로 설정하고
		}
		//석차를 매겨보자.
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(imsi[i][0] < imsi[j][0]){
					imsi[i][1]++;
				}
			}
		}
		//평균 출력하기
		for(int j=0;j<score.length;j++){
			System.out.print(avg[j]+" ");
		}
		System.out.println();
		//총점 출력하기
		for(int j=0;j<score.length;j++){
			System.out.print(imsi[j][0]+" ");
		}
		System.out.println();
		//석차 출력하기
		for(int j=0;j<score.length;j++){
			System.out.print(imsi[j][1]+" ");
		}
	}
}
