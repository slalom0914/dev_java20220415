package homework0513;

public class Dan99_2 {
	public void dan99_2() {
		for(int i=2; i<=9; i++) {
			System.out.println("["+i+"단]");
			for(int j=1; j<=9; j++) {
				if(i!=2 && i!=9) {
					System.out.println("생략");
					break; }
				System.out.println(i+" x "+j+" = "+ (i*j));
			}
			System.out.print("\n");
		}
	}
	public static void main(String[] args) {
		Dan99_2 d = new Dan99_2();
		d.dan99_2();
	}
}
