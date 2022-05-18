package homework0518;

public class BinDo {
	public BinDo() {
		int nanSus[] = new int[100];
		int pCount[] = new int[10];
		initArray(nanSus, 100);
		numberCount(nanSus, 100, pCount);
		print10PerLine(nanSus, 100);
		printResult(pCount, 10);
	}
	// 배열의 초기화
	void initArray(int nanSus[], int size) {
		for(int i=0;i<nanSus.length;i++) {
			nanSus[i] = (int)(Math.random()*10);
		}
	}
	// 빈도 검사  nanSus에 들어 있는 숫자의 빈도를 pCount에 저장함
	void numberCount(int nanSus[], int size, int pCount[]) {
		int nIndex = 0;
		for(int i=0;i<size;i++) {
			nIndex = nanSus[i];
			pCount[nIndex]++;
		}	
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
		System.out.printf("\n ");
		System.out.printf("숫자:");
		for(int i=0;i<size;i++) {
			System.out.printf("%3d", i);			
		}
		System.out.printf("\n ");
		System.out.printf("개수:");
		for(int i=0;i<size;i++) {
			System.out.printf("%3d", pCount[i]);						
		}
	}
	public static void main(String[] args) {
		new BinDo();
	}

}
