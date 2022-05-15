package homework0513;

import java.util.Scanner;

public class A0513_S {
	int i = 0;
	int j = 0;
	// 끝단 담을 변수
	int m = 0;
	// 시작단 담을 변수 선언
	int n = 0;
	public void Scan() {
		System.out.println("시작 단을 입력하시오.");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("끝 단을 입력하시오.");
		int m = sc.nextInt();
		int dan[][] = new int[(m-n)+1][9];
		System.out.println(dan.length+", "+dan[0].length);
		// 2차 배열의 로우값을 담을 변수
		int s = 0;
		// 2차 배열의 컬럼값을 담을 변수
		int e = 0;
		for(int i=n;i < m+1;i++) {
			for(int j=1;j < 10; j++) {
				System.out.println(i+", "+j);
				dan[s][e] = i * j;
				System.out.println("["+i+"]*["+j+"]="+dan[s][e]);
				// 2차배열의 2번째 컬럼값을 1씩 증가시킴
				e++;
			}/////////// end of inner for
			// 시작단을 9번 출력하고 나면 다시 2차배열의 로우값을 1증가시킴
			s++;
			// 2차 배열의 로우값이 1증가되고 나면 그 로우의 컬럼값도 0으로 초기화해줌
			e = 0;
		}/////////////// end of outter for	
	}/////////////////// [Scan] //////////////////
}
