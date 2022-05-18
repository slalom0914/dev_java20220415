package homework0515;

public class PlusMinusSum_Array {

	public void plusMinusArray() {

		int[] plusMinus = new int[10]; // -10에서 10까지의 숫자를 랜덤으로 담을 길이 10의 배열
		int plus = 0, minus = 0;

		for (int i = 0; i < plusMinus.length; i++) {
			plusMinus[i] = (int) (Math.random() * 20) - 9; // plusMinus[i]에 -10 부터 10 까지의 수 중 랜덤으로 10개를 채번하여
															// plusMinus[i]에 저장
			System.out.println("plusMinus[" + i + "] = " + plusMinus[i]);

			if (plusMinus[i] > 0) {
				// System.out.println("양수 : " + plusMinus[i]);
				plus += plusMinus[i];

			} else if (plusMinus[i] < 0) {
				// System.out.println("음수 : " + plusMinus[i]);
				minus += plusMinus[i];
			}
		}
		System.out.println("양수의 합 : " + plus);
		System.out.println("음수의 합 : " + minus);

	}

	public static void main(String[] args) {
		PlusMinusSum_Array a = new PlusMinusSum_Array();
		a.plusMinusArray();
	}

}