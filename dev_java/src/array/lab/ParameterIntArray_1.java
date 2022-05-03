package array.lab;

public class ParameterIntArray_1 {
	
	public ParameterIntArray_1() {
		int is[] = {1,2,3};
		methodA(is);
	}
	public void methodA(int[] is) {
		for(int i=0;i<is.length;i++) {
			System.out.println(is[i]);
		}
	}
	public static void main(String[] args) {
		new ParameterIntArray_1();
	}

}
