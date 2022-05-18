package homework0518;
/*
 *
도전 문제
0 부터 9사이의 임의의 수를 100개를 채번하여 한 줄에 10개씩
출력하고 그 숫자의 빈도수를 계산하여 출력하시오

원본 : 4  4  1  2  5  7  9  6  0  6
	  5  0  1  2  1  7  0  9  4  8
	  8  6  0  1  0  1  6  1  0  2
	  8  3  3  4  0  2  4  6  2  4
	  9  9  2  4  4  2  2  2  3  3
	  7  9  4  3  2  2  3  4  8  7
	  4  6  3  8  2  0  2  0  2  2
	  5  2  7  0  0  6  8  3  7  6
	  6  9  0  9  6  3  1  9  6  3
	  1  4  6  3  2  6  7  1  7  6
	
 숫자:  0  1  2  3  4  5  6  7  8  9
 개수: 12  9 17 11 12  3 14  8  6  8
 * 
 */
public class BinDoTemplate {
	public BinDoTemplate() {
		int nanSus[] = new int[100];
		int pCount[] = new int[10];
		//insert here
		
	}
	// 배열의 초기화
	void initArray(int nanSus[], int size) {
		//insert here
		
	}
	// 빈도 검사  nanSus에 들어 있는 숫자의 빈도를 pCount에 저장함
	void numberCount(int nanSus[], int size, int pCount[]) {
		//insert here
		
	}
	// 배열 출력 한 줄에 10개씩 출력하고 줄바꿈 하기
	void print10PerLine(int nanSus[], int size) {
		System.out.printf("원본 : 	");
		for(int i=0;i<size;i++) {
			System.out.printf("%3d", nanSus[i]);
			if(i%10 == 9) System.out.printf("\n	");
		}
	}
	// 빈도 출력 빈도 배열과 인덱스를 함께 출력
	void printResult(int pCount[], int size) {
		//insert here
		
	}
	public static void main(String[] args) {
		new BinDoTemplate();
	}

}
