package homework0515;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlusMinusSum_List2 {

	public void plusMinusList() {
		Random ran = new Random();

		int plus = 0, minus = 0;

		List<Integer> plusMinus = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			plusMinus.add(ran.nextInt(21) - 10); // 랜덤으로 추출할 숫자의 범위 지정 후 plusMinus 리스트에 add
		}
		System.out.println("plusMinus" + plusMinus); // plusMinus list에 저장된 랜덤 숫자 10개

		// list를 배열로 바꾸기 (list 내에서 양수와 음수의 합을 구하는 것이 어려워서 ..)
		Integer[] plusMinusArr = plusMinus.toArray(new Integer[plusMinus.size()]);
		for (int i : plusMinusArr) { // 발전된 for문을 사용 - for(변수타입 변수이름 : 배열이름)
			// 배열의 길이만큼 실행문 반복 (길이가 10이니까 10회 반복한다.)
			// System.out.println(i); // 배열로 바뀐 ArrayList plusMinusArr

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
		PlusMinusSum_List2 l = new PlusMinusSum_List2();
		l.plusMinusList();
	}

}
