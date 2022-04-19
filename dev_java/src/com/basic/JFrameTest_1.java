package com.basic;

import javax.swing.JFrame;

public class JFrameTest_1 {
	// 선언부
	JFrame jf = new JFrame();
	// 화면 처리부
	public void initDisplay(int width, int height) {
		jf.setSize(width, height);
		jf.setVisible(true);
	}
	// 메인 메소드
	public static void main(String[] args) {
		JFrameTest_1 jft = new JFrameTest_1();
		int width = 300;
		int height = 500;
		jft.initDisplay(width, height);
	}
}
