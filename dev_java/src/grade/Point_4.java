package grade;

import java.util.Scanner;

public class Point_4 {
	Scanner sc = new Scanner(System.in);
	int[] jumsu = new int[5]; // 점수 배열
	String[] name = { "김동현", "이유리", "김민준", "이기현", "이성욱" }; // 이름 선언
	String[] subject = { "국어", "영어", "수학", "사회", "과학" }; // 과목 선언
	double[] avgs = new double[5]; // 평균 배열

	public void pp4() {
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i]); // 이름 프린트

			for (int s = 0; s < subject.length; s++) {
				System.out.println(subject[s] + "점수를 입력하시오 :");
				int subject = sc.nextInt();
				jumsu[s] = subject; // 점수 배열에 점수 입력
			}
		}
		int total = 0;
		for (int i = 0; i<jumsu.length; i++) {
			total += jumsu[i];
			double avg = (double) total / 5.0;
			avgs[i] = avg; // 평균 배열에 평균 초기화
			System.out.println(name[i] + " 총점: " + total + " 평균은: " + avg);
		}
		int rank[] = {1,1,1,1,1};
		for(int a=0; a < avgs.length; a++) {
			for(int j=0; j< avgs.length;j++) {
				if(avgs[a] < avgs[j]) {
					rank[a]++;
				}
			}
		}
		for(int rnk:rank) {
			System.out.println(rnk);
		}
	}///////////// end of pp4
}///////////////// end of Point_4