package homework0518;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BindoView_7 extends JFrame implements ActionListener{
	JPanel  jp_north	 = new JPanel();
	JPanel  jpnorth_row0 = new JPanel();
	JPanel  jpnorth_row1 = new JPanel();
	JPanel  jp_center	 = new JPanel();
	JPanel  jp_east 	 = new JPanel();
	JButton jbtns_menu[] = null; 
	JLabel  jlb_nums[]   = new JLabel[10];
	JLabel  jlb_bindo[]  = new JLabel[10];
	JButton jbtn_shuffle = new JButton("셔플");
	JButton jbtn_account = new JButton("집계");
	JButton jbtn_init    = new JButton("초기화");
	JButton jbtn_exit    = new JButton("나가기");
	
	JButton jbtns[] 	 = new JButton[100];
	JLabel  jlbs[] 		 = new JLabel[100];
	String  jbtns_label[] 	= new String[jbtns.length];
	
	public BindoView_7() {
		jbtns_menu = new JButton[]{jbtn_shuffle, jbtn_account, jbtn_init, jbtn_exit};
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
		for(int i=0;i<jbtns_menu.length;i++) {
			jp_east.add(jbtns_menu[i]);
			jbtns_menu[i].addActionListener(this);
		}
		this.add("North", jp_north);
		this.add("Center", jp_center);
		this.add("East", jp_east);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		BindoView_7 bv = new BindoView_7();
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
		if("초기화".equals(command)) {
			System.out.println("초기화 해볼까?");
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
		
		for(int i=0;i<jlbs.length;i++) {
			jbtns_label[i] = String.valueOf((int)(Math.random()*10));
			JLabel jlb = new JLabel(jbtns_label[i]);
			jlbs[i] = jlb;
			jp_center.add(jlbs[i]);
		}
		this.add("Center", jp_center);
		this.revalidate();
	}
	public void clear() {
		for(int i=0;i<jbtns.length;i++) {
			if(jlbs[i] != null) {
				jlbs[i].setText("0");				
			}
		}
		this.add("Center", jp_center);
		this.revalidate();		
	}
	public void exit() {
		System.exit(0);
	}
}
