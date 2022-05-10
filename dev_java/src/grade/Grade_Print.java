package grade;

public class Grade_Print{
	int[] total, rank;
	double[] avg;
	int[][] score;
	
	Grade_Print(Calculate c){
		this.total = c.total;
		this.rank = c.rank;
		this.avg = c.avg;
		this.score = c.score;
	}
	
	// 3개 한번에 출력
	public void grade_Print() {
		for (int i = 0; i < total.length; i++) {
			System.out.println("score[" + i + "]의 총점 : " + total[i] + "  평균: " + avg[i] + " 순위: " + rank[i] + "등");
		}
	}
	
	// 총점 or 순위만 출력할 경우(오버로딩)
	public void grade_Print(int[] arr) {
		if (arr == total) {
			for (int i = 0; i < total.length; i++) {
				System.out.println("score[" + i + "]의 총점은 : " + total[i] + "점 입니다.");
			}
		} else if (arr == rank) {
			for (int i = 0; i < rank.length; i++) {
				System.out.println("score[" + i + "]의 등수는  : " + rank[i] + "등 입니다.");
			}
		}
	}
	// 평균만 출력할 경우(오버로딩)
	public void grade_Print(double[] arr) {
		if (arr == avg) {
			for (int i = 0; i < avg.length; i++) {
				System.out.println("score[" + i + "]의 평균은 : " + avg[i] + "점 입니다.");
			}
		}

	}

}
