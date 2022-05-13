package grade;

public class StudentScore {
	public static void main(String[] args) {
		// 2차 배열 초기화. 3행 5열 == 15개의 int 값 저장 가능하다.
		int[][] score = {
				{ 100, 90, 80 }, // 학생 1
				{ 85, 90, 80 }, // 학생 2
				{ 70, 70, 80 }, // 학생 3
				{ 90, 60, 65 }, // 학생 4
				{ 75, 80, 70 } // 학생 5
		};
		int total = 0; // 각 학생의 총점 초기화
		double avg = 0.0; // 각 학생의 평균 초기화
		double imsi[][] = new double[score.length][3];
		for (int i = 0; i < score.length; i++) {
			total = score[i][0]+score[i][1]+score[i][2];
			avg = total / 3.0; // 각 학생의 평균
			// 학생별 총점 배열에 담기
			imsi[i][0] = total;
			imsi[i][1] = avg;
			// 석차를 1로 초기화하기
			imsi[i][2] = 1;
			total = 0;
			avg = 0.0;
		}
		// 석차를 매겨줌
		for(int i=0;i<score.length;i++) {
			for(int j=0;j<score.length;j++) {
				if(imsi[i][0] < imsi[j][0]) {
					imsi[i][2]++;
				}
			}////// end of inner for
		}////////// end of outter for
		for(int x=0;x<score.length;x++) {
			System.out.println((x + 1) + "번 학생\n총 점수 => " + imsi[x][0] + "\n평균  ===> " + imsi[x][1]+ "\n석차  ===> " + (int)(imsi[x][2]));
			//System.out.println();			
		}
	}// end of main
}
