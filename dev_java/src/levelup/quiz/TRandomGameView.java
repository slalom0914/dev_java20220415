package levelup.quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TRandomGameView extends JFrame{
	public JPanel p_south = null;
	public JTextArea ta_result = null;
	public JScrollPane jsp = null;
	public JButton btn_zero = null;
	public JButton btn_one = null;
	public JButton btn_two = null;
	public JButton btn_three = null;
	public JButton btn_four = null;
	public JButton btn_five = null;
	public JButton btn_six = null;
	public JButton btn_seven = null;
	public JButton btn_eight = null;
	public JButton btn_nine = null;
	public JButton btn_exit = null;
	public JButton btn_newGame = null;
	int count = 1;
	//Computer가 채번한 값
	int com = 0;
	//사용자가 입력한 값
	int user = 0;
	String hint = "";
	boolean isFlag = false;
	TRandomGameEvent event = new TRandomGameEvent(this);
	TRandomGameLogic logic = new TRandomGameLogic(this);
	public TRandomGameView(){
		initDisplay();
		logic.newGame();
	}
	public void initDisplay(){
		p_south = new JPanel();
		p_south.setLayout(new GridLayout(2,5));
		ta_result = new JTextArea();
		jsp = new JScrollPane(ta_result,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		btn_zero = new JButton("0");
		btn_zero.addActionListener(event);
		btn_one = new JButton("1");
		btn_one.addActionListener(event);
		btn_two = new JButton("2");
		btn_two.addActionListener(event);
		btn_three = new JButton("3");
		btn_three.addActionListener(event);
		btn_four = new JButton("4");
		btn_four.addActionListener(event);
		btn_five = new JButton("5");
		btn_five.addActionListener(event);
		btn_six = new JButton("6");
		btn_six.addActionListener(event);
		btn_seven = new JButton("7");
		btn_seven.addActionListener(event);
		btn_eight = new JButton("8");
		btn_eight.addActionListener(event);
		btn_nine = new JButton("9");
		btn_nine.addActionListener(event);
		btn_exit = new JButton("종료");	
		btn_exit.setBackground(Color.red);
		btn_newGame = new JButton("새게임");	
		btn_newGame.setBackground(Color.green);
		btn_newGame.addActionListener(event);
		p_south.add(btn_zero);
		p_south.add(btn_one);
		p_south.add(btn_two);
		p_south.add(btn_three);
		p_south.add(btn_four);
		p_south.add(btn_five);
		p_south.add(btn_six);
		p_south.add(btn_seven);
		p_south.add(btn_eight);
		p_south.add(btn_nine);
		p_south.add(btn_exit);
		p_south.add(btn_newGame);
		ta_result.setEnabled(false);
		getContentPane().add(p_south,BorderLayout.SOUTH);
		getContentPane().add(jsp,BorderLayout.CENTER);
		this.setTitle("숫자맞추기 게임");
		this.setSize(500,300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TRandomGameView();
	}


}
