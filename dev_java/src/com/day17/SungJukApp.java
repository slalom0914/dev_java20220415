package com.day17;

public class SungJukApp {
	int score[][] = {
			 {100,90,80}
			,{85,90,80}
			,{80,70,80}
			,{90,90,85}
			,{65,80,70}
	};	
	double results[][] = new double[score.length][3];
	public void account() {
		int tot = 0;
		for(int i=0;i<score.length;i++){
			tot = score[i][0]+score[i][1]+score[i][2];
			results[i][0] = tot;
			double d_avg = 0.0;
			d_avg = tot/3.0;
			results[i][1] = d_avg;
			results[i][2] = 1;
			//초기화 
			tot = 0;
			d_avg = 0.0;
		}
		// 석차 구하기 - 굳이 자기자신과 비교할 필요가 있나요? -  일량 줄일 수 있다.
		for(int x=0;x<score.length;x++) {
			for(int y=0;y<score.length;y++) {
				if(results[x][0] < results[y][0]) {
					results[x][2]++;
				}
			}
		}
		for(int j=0;j<score.length;j++) {
			System.out.println(results[j][0]+", "+results[j][1]+ ", "+(int)(results[j][2]));
		}
	}
	public static void main(String[] args) {
		SungJukApp sj = new SungJukApp();
		sj.account();
	}

}
