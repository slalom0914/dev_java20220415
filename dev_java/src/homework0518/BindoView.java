package homework0518;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BindoView extends JFrame {
	JButton jbtn_shuffle = new JButton("셔플");
	JButton jbtn_account = new JButton("집계");
	JButton jbtn_clear   = new JButton("지우기");
	JButton jbtn_exit    = new JButton("나가기");
	public BindoView() {
		
	}
	public void initDisplay() {
		
	}
	public static void main(String[] args) {
		BindoView bv = new BindoView();
	}

}
