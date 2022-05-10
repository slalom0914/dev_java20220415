package com.day15;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_4 extends JFrame implements ActionListener{
	B_4 b = new B_4();
    private JButton btnInsert = new JButton("가입");
    private JButton btnUpdate = new JButton("수정");
    private JButton btnDelete = new JButton("삭제");
    private JButton btnSelect = new JButton("조회");
    private JButton btnDetail = new JButton("상세보기");	
	public void initDisplay() {
	       this.setLayout(new FlowLayout());
	       btnInsert.addActionListener(this);
	       btnUpdate.addActionListener(this);
	       btnDetail.addActionListener(this);
	       this.add(btnInsert);
	       this.add(btnUpdate);
	       this.add(btnDelete);
	       this.add(btnSelect);
	       this.add(btnDetail);		
		this.setSize(400, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		A_4 a = new A_4();
		a.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// if문 세번이면 무조건 비교를 3번하게 되므로 비효율적이다.
		// 만일 else if로 하였다면 위에 조건이 만족되었을 때 아래 조건은 따지지 않으니까
		// 비용이 절약된다.
		// 부모창이 열릴때 열리는 창의 타이틀은 부모창에서 결정된다.
		// 부모창에서 어떤 버튼이 선택되는가에 따라 자손창의 제목이 결정됨 - 구조
		if(btnInsert == obj) {
			String label = btnInsert.getText();
			System.out.println(label);
			b.set(label, true);
		}
		else if(btnUpdate == obj) {
			String label = btnUpdate.getText();
			System.out.println(label);
			b.set(label, true);
		}
		else if(btnDetail == obj) {
			String label = btnDetail.getText();
			System.out.println(label);		
			b.set(label, true);
		}		
	}
}
