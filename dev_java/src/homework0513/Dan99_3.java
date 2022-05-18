package homework0513;

public class Dan99_3 {
	int [][] gugu = new int[10][10];
	public void dan99_3() {
		for (int i=2; i < gugu.length; i++) {
			if(i==2 || i==9) {
				System.out.print("\n");
				System.out.println("["+i+"단]");
			}
			for (int j=1; j < gugu[i].length; j++) {
				if(i!=2 && i!=9) {
					break;
				}
				gugu[i][j] = i*j;
				System.out.println(i+" x "+j+" = "+ gugu[i][j]);
			}
		}
	}
	public static void main(String[] args) {
		Dan99_3 d = new Dan99_3();
		d.dan99_3();
	}
}
