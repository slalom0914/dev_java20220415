package homework0518;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BindoView_6 extends JFrame implements ActionListener{
	JPanel  jp_north	 = new JPanel();
	JPanel  jpnorth_row0 = new JPanel();
	JPanel  jpnorth_row1 = new JPanel();
	JPanel  jp_center	 = new JPanel();
	JPanel  jp_east 	 = new JPanel();
	JButton jbtns[]		 = null; 
	JLabel  jlb_nums[]   = new JLabel[10];
	JLabel  jlb_bindo[]  = new JLabel[10];
	JButton jbtn_shuffle = new JButton("셔플");
	JButton jbtn_account = new JButton("집계");
	JButton jbtn_clear   = new JButton("지우기");
	JButton jbtn_exit    = new JButton("나가기");
	public BindoView_6() {
		jbtns = new JButton[]{jbtn_shuffle, jbtn_account, jbtn_clear, jbtn_exit};
		for(int i=0;i<jlb_nums.length;i++) {
			jlb_nums[i]  = new JLabel(""+i);
			jlb_bindo[i] = new JLabel("0");
		}
	}
	public void initDisplay() {
		jp_north.setBackground(Color.gray);
		jp_north.setLayout(new GridLayout(2,1));
		jpnorth_row0.setLayout(new GridLayout(1,10));
		for(int i=0;i<jlb_nums.length;i++) {
			jpnorth_row0.add(jlb_nums[i]);
			jpnorth_row1.add(jlb_bindo[i]);
		}
		jpnorth_row1.setLayout(new GridLayout(1,10));
		jp_north.add(jpnorth_row0);
		jp_north.add(jpnorth_row1);
		jp_center.setBackground(Color.GREEN);
		jp_east.setBackground(Color.orange);
		jp_east.setLayout(new GridLayout(4,1));
		for(int i=0;i<jbtns.length;i++) {
			jp_east.add(jbtns[i]);
			jbtns[i].addActionListener(this);
		}
		this.add("North", jp_north);
		this.add("Center", jp_center);
		this.add("East", jp_east);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		BindoView_6 bv = new BindoView_6();
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
			clear();
		}
		if("나가기".equals(command)) {
			System.out.println("그만하려구?");
			exit();
		}
	}
	public void shuffle() {
		jp_center = null;
		jp_center = new JPanel();
		jp_center.setLayout(new GridLayout(10,10));
		JButton jbtns[] 		= new JButton[100];
		String  jbtns_label[] 	= new String[jbtns.length];
		
		for(int i=0;i<jbtns.length;i++) {
		}
		
		for(int i=0;i<jbtns.length;i++) {
			jbtns_label[i] = String.valueOf((int)(Math.random()*10));
			JButton jbtn = new JButton(jbtns_label[i]);
			jbtns[i] = jbtn;
			jp_center.add(jbtns[i]);
		}
		this.add("Center", jp_center);
		this.revalidate();
	}
	public void clear() {
		jp_center = null;
		jp_center = new JPanel();
		this.add("Center", jp_center);
		this.revalidate();		
	}
	public void exit() {
		System.exit(0);
	}
}
