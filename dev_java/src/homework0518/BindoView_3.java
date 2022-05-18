package homework0518;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BindoView_3 extends JFrame implements ActionListener{
	JPanel  jp_center	 = new JPanel();
	JPanel  jp_east 	 = new JPanel();
	JButton jbtns[]		 = null; 
	JButton jbtn_shuffle = new JButton("셔플");
	JButton jbtn_account = new JButton("집계");
	JButton jbtn_clear   = new JButton("지우기");
	JButton jbtn_exit    = new JButton("나가기");
	public BindoView_3() {
		jbtns = new JButton[]{jbtn_shuffle, jbtn_account, jbtn_clear, jbtn_exit};
	}
	public void initDisplay() {
		jp_center.setBackground(Color.GREEN);
		jp_east.setBackground(Color.orange);
		jp_east.setLayout(new GridLayout(4,1));
		for(int i=0;i<jbtns.length;i++) {
			jp_east.add(jbtns[i]);
			jbtns[i].addActionListener(this);
		}
		this.add("Center", jp_center);
		this.add("East", jp_east);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		BindoView_3 bv = new BindoView_3();
		bv.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼의 라벨을 가져온다.
		String command = e.getActionCommand();
		// 너 셔플 누른거니?
		if("셔플".equals(command)) {
			System.out.println("셔플 누른거니?");
			shuffle();
		}
		else if("집계".equals(command)) {
			System.out.println("집계를 볼래?");
		}
		if("지우기".equals(command)) {
			System.out.println("중앙 화면 지워볼까?");
		}
		if("나가기".equals(command)) {
			System.out.println("그만하려구?");
			exit();
		}
	}
	public void shuffle() {
		jp_center = null;
		jp_center = new JPanel();
		this.add("Center", jp_center);
		this.revalidate();
		JButton jbtns[] 		= new JButton[100];
		String  jbtns_label[] 	= new String[jbtns.length];
		/*
		for(int i=0;i<nanSus.length;i++) {
			nanSus[i] = (int)(Math.random()*10);
		}
		*/
		
	}
	public void exit() {
		System.exit(0);
	}
}
