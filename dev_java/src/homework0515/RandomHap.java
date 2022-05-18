package homework0515;

/*
-10에서 10사이의 정수 10개를 랜덤하게 채번하여  음수와 양수의 합계를 구하시오.
[요구사항 : 채번한 숫자는 1차 배열에 담아서 처리해 주세요]
출력)
배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0

음수합 : -24
양수합 : 17
*/

public class RandomHap {
	int mhap = 0;
	int phap = 0;
	void initArray(int is[], int size) {
		int i =0;
		for(i=0;i<size;i++) {
			int nanSu = (int)(Math.random()*21)-10;
			is[i] = nanSu;
		}
	}
	void sumMinusAndPlus(int is[], int mhap, int phap) {
		for(int i=0;i<is.length;i++) {
			if(is[i]>0) {
				phap += is[i];
			}else {
				mhap += is[i];
			}
		}
		this.phap = phap;
		this.mhap = mhap;
	}
	public static void main(String[] args) {
		int size = 10;
		int is[] = new int[size];
		RandomHap rh = new RandomHap();
		rh.initArray(is, size);
		int mhap = 0;
		int phap = 0;
		rh.sumMinusAndPlus(is, mhap, phap);
		for(int x=0;x<is.length;x++) {
			System.out.println(is[x]);
		}
		System.out.println("양수의 합은 "+rh.phap);
		System.out.println("음수의 합은 "+rh.mhap);
	}

}
