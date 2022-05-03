package array.lab;

public class ParameterIntArray_3 {	
	public ParameterIntArray_3() {
		int is[] = methodA();
		for(int i=0;i<is.length;i++) {
			System.out.println(is[i]);
		}		
	}
	public int[] methodA() {
		int is[] = {1,2,3};
		return is;
	}
	public static void main(String[] args) {
		new ParameterIntArray_3();
	}
}
