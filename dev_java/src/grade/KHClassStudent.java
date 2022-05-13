package grade;

/** 성적 계산 추상클래스 상속 받 **/
/** 학생 성적의 총합, 평균, 석차를 내는 구체 클래스 **/
public class KHClassStudent extends ScoreCalculator {
		
	// 배열로도 넣어볼 것..
		int stuTotal1;
		int stuTotal2;
		int stuTotal3;
		int stuTotal4;
		int stuTotal5;
		
		double avgStu1;
		double avgStu2;
		double avgStu3;
		double avgStu4;
		double avgStu5;
		
	// 평균과 석차를 담을 배열 생성
		double[] avgStu = new double[5];
		int[] rank = new int[5];
		
		@Override
			public void addUpScore () {
				for (int i = 0; i < subject; i ++) {
					stuTotal1 = stuTotal1 + score[0][i];
					stuTotal2 = stuTotal2 + score[1][i];
					stuTotal3 = stuTotal3 + score[2][i];
					stuTotal4 = stuTotal4 + score[3][i];
					stuTotal5 = stuTotal5 + score[4][i];
				}
				System.out.println("학생 1의 총 성적 합은 : " + stuTotal1);
				System.out.println("학생 2의 총 성적 합은 : " + stuTotal2);
				System.out.println("학생 3의 총 성적 합은 : " + stuTotal3);
				System.out.println("학생 4의 총 성적 합은 : " + stuTotal4);
				System.out.println("학생 5의 총 성적 합은 : " + stuTotal5);
			}
		
		@Override
			public void avgScore () {
				avgStu1 = (stuTotal1 / subject);
				avgStu2 = (stuTotal2 / subject);
				avgStu3 = (stuTotal3 / subject);
				avgStu4 = (stuTotal4 / subject);
				avgStu5 = (stuTotal5 / subject);
				
				System.out.println("학생 1의 성적 평균은 : " + avgStu1);
				System.out.println("학생 2의 성적 평균은 : " + avgStu2);
				System.out.println("학생 3의 성적 평균은 : " + avgStu3);
				System.out.println("학생 4의 성적 평균은 : " + avgStu4);
				System.out.println("학생 5의 성적 평균은 : " + avgStu5);
		}
		
		@Override
			public void rankingScore () {
			this.avgStu = new double[] {avgStu1, avgStu2, avgStu3, avgStu4, avgStu5};
			
			for (int i = 0; i < rank.length; i ++) {
				rank[i] = 1;
			}
			
			for(int i = 0; i < avgStu.length; i ++) {
				for(int j = 0; j < avgStu.length; j ++) {
					if(avgStu[i]>avgStu[j]) {
						rank[j]++;
					}
				}
			} for (int i = 0; i < rank.length; i ++) {
				System.out.println("석차 : " + rank[i] + " 등 ( 평균 점수 : " + avgStu[i] +" )");
			} 
		}
		
}
