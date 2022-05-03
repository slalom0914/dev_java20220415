package com.quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RandomGameView extends JFrame{
	private JPanel p_south = null;
	private JTextArea ta_result = null;
	private JScrollPane jsp = null;
	private JButton btn_zero = null;
	private JButton btn_one = null;
	private JButton btn_two = null;
	private JButton btn_three = null;
	private JButton btn_four = null;
	private JButton btn_five = null;
	private JButton btn_six = null;
	private JButton btn_seven = null;
	private JButton btn_eight = null;
	private JButton btn_nine = null;
	private JButton btn_exit = null;
	private JButton btn_newGame = null;
	//사용자가 입력한 값
	int user = 0;
	public RandomGameView(){
		initDisplay();
	}
	public void initDisplay(){
		p_south = new JPanel();
		p_south.setLayout(new GridLayout(2,5));
		ta_result = new JTextArea();
		jsp = new JScrollPane(ta_result,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		btn_zero = new JButton("0");
		btn_one = new JButton("1");
		btn_two = new JButton("2");
		btn_three = new JButton("3");
		btn_four = new JButton("4");
		btn_five = new JButton("5");
		btn_six = new JButton("6");
		btn_seven = new JButton("7");
		btn_eight = new JButton("8");
		btn_nine = new JButton("9");
		btn_exit = new JButton("종료");	
		btn_exit.setBackground(Color.red);
		btn_newGame = new JButton("새게임");	
		btn_newGame.setBackground(Color.green);
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
		new RandomGameView();
	}
}
