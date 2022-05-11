package com.day16;
// Ctrl + Shift +F :자동정렬
public class IntArray_2 {
	// 부서번호를 담을 배열 선언
	int deptnos[] = null;// 나는 1차 배열 입니다.
	// 아래 디폴트 생성자는 언제 호출되나요? -28
	public IntArray_2() {
		deptnos = new int[3];// 배열 생성 - 어떤 장애를 갖고 있나? 오직 int만 담을 수 있다. - 해결점:컬렉션프레임워크 공부하면 된다. 자료구
		System.out.println(deptnos);
		initArray();
		arrayPrint();
	}

	public void initArray() {
		deptnos[0] = 10;
		deptnos[1] = 20;
		deptnos[2] = 30;
	}

	public void arrayPrint() {
		// 개선된 for 문 - 전체조회 할때는
		// for(변수선언:내안에 있는 타입:배열의 변수명)
		for (int deptno : deptnos) {
			System.out.println(deptno);
		}
	}

	public static void main(String[] args) {
		// 인스턴스 변수를 재사용하지 않는 경우라면 아래처럼 해도 괜찮아
		// 메소드 호출을 생성자에서 하고 있잖아
		new IntArray_2();
	}

}

