package array.lab;

public class IntArray_1 {
	int is[]=new int[]{1,2,3};
	String names[] = {"scott","tiger","hr"};
	public IntArray_1() {
		System.out.println("디폴트 생성자 호출 성공");
		isArrayPrint();
		System.out.println("=====================================");
		namesArrayPrint();
	}
	void isArrayPrint() {
		for(int i=0;i<is.length;i++) {
			System.out.println("is["+i+"] - "+is[i]);
		}
	}
	void namesArrayPrint() {
		for(String name:names) {
			System.out.println(name);
		}
	}
	public static void main(String[] args) {
		new IntArray_1();
	}

}
