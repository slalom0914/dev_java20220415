package baseball;

import java.util.ArrayList;
import java.util.HashSet;


// 랜덤 배열 생성 클래스(재사용성 높이고 변경에 유리하도록 작성)
public class Random {
	private int arr_index;

	public Random(int arr_index) {
		this.arr_index = arr_index;
	}

	// 랜덤값 구하기(HashSet, ArrayList 사용하기)
	public int[] auto_random() {
		HashSet<Integer> random = new HashSet<Integer>(); // HashSet : 중복x 허용x

		while (random.size() < arr_index) {
			random.add((int) (Math.random() * 9));
		}
		ArrayList<Integer> number = new ArrayList<Integer>(random); // 배열로 인덱스 있도록 저장

		int[] numarr = new int[arr_index];

		for (int i = 0; i < number.size(); i++) {
			numarr[i] = number.get(i);
		}
		return numarr;
	}
}
