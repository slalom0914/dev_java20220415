package grade;

import java.util.Arrays;

public class Calculate{
	int[] total, rank;
	double[] avg;
	int[][] score;
	
	Calculate(int[][] score) {
		this.score = score;
		this.total = new int[score.length];
		this.rank = new int[score.length];
		this.avg = new double[score.length];
		total();
		avg();
		rank();
	}
	// 총점
	public int[] total() {
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; ++j) {
				total[i] += score[i][j];
			}
		}
		return total;
	}
	// 평균
	public double[] avg() {
		for (int i = 0; i < score.length; i++) {
			avg[i] = Math.round(total[i] /score[i].length * 10) / 10.0;
		}
		return avg;
	}
	// 순위
	public int[] rank() {
		Arrays.fill(rank, 1);
		for (int i = 0; i < total.length; i++) {
			for (int j = 0; j < total.length; j++) {
				if (total[i] < total[j]) {
					rank[i] = rank[i] + 1;
				}
			}
		}
		return rank;
	} 
}
