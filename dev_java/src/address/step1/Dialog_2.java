package address.step1;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Dialog_2 extends JDialog {
	String title = null;
	public void initDisplay() {
    	this.setTitle(title);
    	this.setSize(300, 400);
    	this.setVisible(true);
	}
	public void set(String title) {
		this.title = title;
	}
}
