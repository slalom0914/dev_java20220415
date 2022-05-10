package com.day15;

import javax.swing.JFrame;

public class A_3 extends JFrame{
	B_3 b = new B_3();
	public void initDisplay() {
		this.setSize(400, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		A_3 a = new A_3();
		a.initDisplay();
	}
}
