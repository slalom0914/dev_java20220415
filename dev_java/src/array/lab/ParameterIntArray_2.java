package array.lab;

public class ParameterIntArray_2 {	
	int is[] = {1,2,3};
	public ParameterIntArray_2() {
		methodA();
	}
	public void methodA() {
		for(int i=0;i<is.length;i++) {
			System.out.println(is[i]);
		}
	}
	public static void main(String[] args) {
		new ParameterIntArray_2();
	}
}
