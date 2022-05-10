package address.step1;

import javax.swing.JDialog;

public class Son_1 extends JDialog{
	public Son_1() {
		initDisplay();
	}
	public void initDisplay() {
    	this.setTitle("자손창");
    	this.setSize(300, 400);
    	this.setVisible(true);
	}
	public static void main(String args[]) {
		Son_1 s = new Son_1();
		s.initDisplay();
	}
}
