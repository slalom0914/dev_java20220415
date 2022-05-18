package homework0515;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusMinusSum_List1 {

	public void plusMinusList() {

		int plus = 0, minus = 0;

		List<Integer> plusMinus = new ArrayList<>();

		for (int i = -10; i <= 10; i++) {
			plusMinus.add(i);
		}
		// System.out.println("plusMinus" + plusMinus);

		// 랜덤을 인스턴스하여 사용하는 대신 shuffle을 이용하여 -10 ~ 10을 섞어서 10개를 추출하기
		Collections.shuffle(plusMinus);
		// System.out.println("plusMinusShuffle: " + plusMinus);

		// 랜덤으로 섞인 수 순서대로 10개 추출 (비효율적인 것 같다.)
		plusMinus = plusMinus.subList(0, 9);
		System.out.println("plusMinus10List" + plusMinus);

		// list를 배열로 바꾸기 (list 내에서 양수와 음수의 합을 구하는 것이 어려워서 ..)
		Integer[] plusMinusArr = plusMinus.toArray(new Integer[plusMinus.size()]);
		for (int i : plusMinusArr) { // 발전된 for문을 사용 - for(변수타입 변수이름 : 배열이름)
			// 배열의 길이만큼 실행문 반복 (길이가 10이니까 10회 반복한다.)
			System.out.println(i); // 배열로 바뀐 ArrayList plusMinusArr

			if (i > 0) {
				// System.out.println("양수 : " + i);
				plus += i;
			} else if (i < 0) {
				// System.out.println("음수 : " + i);
				minus += i;
			}
		}
		System.out.println("양수의 합 : " + plus);
		System.out.println("음수의 합 : " + minus);
	}

	public static void main(String[] args) {
		PlusMinusSum_List1 l = new PlusMinusSum_List1();
		l.plusMinusList();
	}

}
