package grade;

public class StudentScore_1 {

	public static void main(String[] args) {
		// 2차 배열 초기화. 3행 5열 == 15개의 int 값 저장 가능하다.
		int[][] score = {
				{ 100, 90, 80 }, 	// 학생 1
				{ 85, 90, 80 }, 	// 학생 2
				{ 70, 70, 80 }, 	// 학생 3
				{ 90, 60, 65 }, 	// 학생 4
				{ 75, 80, 70 } 		// 학생 5
		};

		int total = 0; 		// 각 학생의 총점 초기화
		double avg = 0.0; 	// 각 학생의 평균 초기화
		int[] totalRank = new int[5]; // 5명의 총점을 담을 배열 생성 

		// 각 학생의 총점과 평균 구하기
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				total += score[i][j]; // 각 학생의 총점 
				totalRank[i] = total; // 각 학생의 총점을 1차 배열에 담기
			} 

			avg = total / 3.0; // 각 학생의 평균

			System.out.println((i + 1) + "번 학생\n총 점수 => " + total + "\n평균  ===> " + avg);
			System.out.println();

			total = 0;
			avg = 0.0;
		}
		
//		System.out.println("totalRank => " + totalRank); // totalRank의 배열 주소번지 확인
		
		// 각 학생의 등수 구하기 (totalRank)
		int rank[] = { 1, 1, 1, 1, 1 };

		for (int i = 0; i < totalRank.length; i++) {
			for (int j = 0; j < totalRank.length; j++) {
				if (totalRank[i] < totalRank[j]) {
					rank[i]++;
				}
			}
		}
		
		for (int i = 0; i < totalRank.length; i++) {
			System.out.println(totalRank[i] +" : "+ rank[i]);
		}
	}
}
