package grade;

import java.util.Random;

public class Nansu {

	public static void main(String[] args) {

		Random r = new Random();
		int[] jumsu = new int[5]; // 정수 5개 담는 배열
		int sum = 0; // 평균을 구하기 위해 합계변수 설정
		double avg; // 평균

		for (int i = 0; i < jumsu.length; i++) {
			jumsu[i] = r.nextInt(100) + 1; // 100도 포함됨
			sum += jumsu[i]; // 합계에 누적시킴
			System.out.print(jumsu[i] + " "); // 난수 점수 5개 출력

		} // for문

		System.out.println("\n"); // 한줄 띄우고

		avg = sum / jumsu.length; // 평균 도출

		int[] rank = new int[jumsu.length]; // 순위 배열.점수의 길이 5개.

		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1; // 0위는 없음. 1위로 초기화
		}
		for (int i = 0; i < jumsu.length; i++) {
			for (int j = 0; j < jumsu.length; j++) {
				if (jumsu[i] < jumsu[j]) {
					rank[i]++; // i값이 j보다 작으면 순위가 밀리므로 ++
				}
			}
		}
		for (int i = 0; i < rank.length; i++) {
			System.out.println(jumsu[i] + "점: " + rank[i] + "등");

		}

		System.out.print("\n합계:" + sum + "점" + "\n평균:" + avg + "점");

	} // end main()

}
