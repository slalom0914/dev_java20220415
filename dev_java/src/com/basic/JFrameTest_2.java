package com.basic;

import javax.swing.JFrame;

public class JFrameTest_2 {
	// 선언부
	JFrame jf = new JFrame();
	// 화면 처리부
	public void initDisplay(int width, int height, boolean isView) {
		jf.setSize(width, height);
		jf.setVisible(isView);
	}
	// 메인 메소드
	public static void main(String[] args) {
		JFrameTest_2 jft = new JFrameTest_2();
		int width = 300;
		int height = 500;
		boolean isView = true;
		jft.initDisplay(width, height, isView);
	}
}
