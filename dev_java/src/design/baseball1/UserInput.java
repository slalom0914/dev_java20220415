package design.baseball1;

public class UserInput {
	int my[] = new int[3];
	public void inputValue(String user) {
		int temp = Integer.parseInt(user);
		my[0] = temp/100;//백자리를 받는다.
		my[1] = (temp%100)/10;//십자리를 받는다.
		my[2] = temp%10;		
	}
	public static void main(String[] args) {
		UserInput ui = new UserInput();
		ui.inputValue("578");
		for(int i=0;i<ui.my.length;i++) {
			System.out.println(ui.my[i]);
		}
	}
}
