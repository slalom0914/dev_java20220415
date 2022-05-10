package com.day15;

import javax.swing.JDialog;

public class B_4 extends JDialog {
	String title = null;
	boolean isView = false;
	public B_4() {
		System.out.println("B_3()생성자 호출");
		initDisplay();
	}
	public void set(String title, boolean isView) {
		this.setTitle(title);
		this.setVisible(isView);
	}
	public void initDisplay() {
		System.out.println("initDisplay 호출");
		this.setTitle("자손창-다이얼로그");
		this.setSize(300, 500);
		this.setVisible(isView);
	}
}
