package address.step1;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.util.List;

public class Main_2 extends JFrame implements ActionListener{
	// 메인화면에 사용할 컴포넌트들을 선언합니다.
    private JButton btnInsert = new JButton("입력");
    private JButton btnUpdate = new JButton("수정");
    private JButton btnDelete = new JButton("삭제");
    private JButton btnSelect = new JButton("조회");
    private JButton btnDetail = new JButton("상세보기");
    Dialog_2 dialog = null;
	public void initDisplay() {
		dialog = new Dialog_2();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(new FlowLayout());
    	btnInsert.addActionListener(this);
    	btnUpdate.addActionListener(this);
    	btnDetail.addActionListener(this);
    	this.add(btnInsert);
    	this.add(btnUpdate);
    	this.add(btnDelete);
    	this.add(btnSelect);
    	this.add(btnDetail);
    	this.setTitle("메인 Ver1.0");
    	this.setSize(700, 500);
    	this.setVisible(true);
	}
	public static void main(String[] args) {
		Main_2 abook = new Main_2();
		abook.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(btnInsert == obj) {
			dialog.set("입력");
			dialog.initDisplay();
		}
		else if(btnUpdate == obj) {
			dialog.set("수정");
			dialog.initDisplay();
		}
		else if(btnDetail == obj) {
			dialog.set("상세조회");
			dialog.initDisplay();
		}
	}
}
