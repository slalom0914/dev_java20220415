package array.lab;

public class IntArray {
	int is[];
	String names[] = new String[3];
	public IntArray() {
		System.out.println("디폴트 생성자 호출 성공");
		initArray();
		isArrayPrint();
		System.out.println("=====================================");
		namesArrayPrint();
	}
	void initArray() {
		is = new int[5];
		names[0] = "이순신"; 
		names[1] = "강감찬"; 
		names[2] = "김유신"; 
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
		new IntArray();
	}

}
