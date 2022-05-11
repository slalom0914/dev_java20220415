package com.day16;

public class IntArray_11 {
	// 부서번호를 담을 배열 선언
	int deptnos[] = null;
	// 디폴트 생성자 선언
	public IntArray_11() {
		// 배열의 생성 - 방이 3개 만들어 진다.
		deptnos = new int[3];// deptnos[0]=0, deptnos[1]=0, deptnos[2]=0
		// 배열의 초기화를 담당하는 메소드 호출
		initArray();
		// 위 메소드를 경유(호출)하면 0 0 0 대신에 새로운 값인 10 20 30으로 초기화됨
		arrayPrint();
	}
	// 아래 메소드가 호출되야 deptnos 1차배열의 초기화가 된다.
	public void initArray() {
		deptnos[0] = 10;//deptnos[0]=10
		deptnos[1] = 20;//deptnos[1]=20
		deptnos[2] = 30;//deptnos[2]=30
	}// end of initArray
	// 배열의 원소의 갯수를 카운트 해줌
	public void arrayPrint() {
		for (int i = 0; i < 4; i++) {
			try {
				System.out.println(deptnos[i]);				
			} catch (Exception e) {
				System.out.println("지금 장애가 발생하였습니다.");
			}
		}
		System.out.println("여기");
	}// end of arrayPrint

	public static void main(String[] args) {
		// 배열을 초기화 하는 initArray호출 또 초기화된 배열을 출력하는 arrayPrint호출
		// 모두 생성자에서 처리되었다.
		// 그래서 생성자 호출이 필요함.
		new IntArray_11();
	}// end of main

}

