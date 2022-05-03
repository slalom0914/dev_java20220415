package array.lab;

public class IntArray_2 {
	boolean isOk[]={true,false,true};
	double ds[] = new double[3];
	public IntArray_2() {
		System.out.println("디폴트 생성자 호출 성공");
		dsArrayPrint();
		System.out.println("=====================================");
		isOkArrayPrint();
	}
	void dsArrayPrint() {
		ds[0] = 1.14;
		ds[1] = 2.14;
		ds[2] = 3.14;
		for(int i=0;i<ds.length;i++) {
			System.out.println("ds["+i+"] - "+ds[i]);
		}
	}
	void isOkArrayPrint() {
		for(boolean ok:isOk) {
			System.out.println(ok);
		}
	}
	public static void main(String[] args) {
		new IntArray_2();
	}

}
