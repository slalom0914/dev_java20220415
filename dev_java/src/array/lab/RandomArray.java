package array.lab;

public class RandomArray {
	int com[] = new int[3];
	public RandomArray() {
		for(int i=0;i<10;i++) {
			randomNumber();
			System.out.println(com[0]+""+com[1]+""+com[2]);			
		}
	}
	public void randomNumber() {
		com[0] = (int)(Math.random()*10);
		do {
			com[1] = (int)(Math.random()*10);
		}while(com[0]==com[1]);
		do {
			com[2] = (int)(Math.random()*10);
		}while(com[0]==com[2]||com[1]==com[2]);		
	}
	public static void main(String[] args) {
		new RandomArray();
		
	}

}
