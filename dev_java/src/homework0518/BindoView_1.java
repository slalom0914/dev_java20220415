package homework0518;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BindoView_1 extends JFrame{
	JPanel  jp_center	 = new JPanel();
	JPanel  jp_east 	 = new JPanel();
	JButton jbtns[]		 = null; 
	JButton jbtn_shuffle = new JButton("셔플");
	JButton jbtn_account = new JButton("집계");
	JButton jbtn_clear   = new JButton("지우기");
	JButton jbtn_exit    = new JButton("나가기");
	public BindoView_1() {
		jbtns = new JButton[]{jbtn_shuffle, jbtn_account, jbtn_clear, jbtn_exit};
	}
	public void initDisplay() {
		jp_center.setBackground(Color.GREEN);
		jp_east.setBackground(Color.orange);
		jp_east.setLayout(new GridLayout(4,1));
		for(int i=0;i<jbtns.length;i++) {
			jp_east.add(jbtns[i]);
		}
		this.add("Center", jp_center);
		this.add("East", jp_east);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		BindoView_1 bv = new BindoView_1();
		bv.initDisplay();
	}

}
