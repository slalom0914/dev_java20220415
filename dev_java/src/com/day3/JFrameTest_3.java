package com.day3;

import javax.swing.JFrame;

public class JFrameTest_3 {
	// 선언부
	JFrame jf = new JFrame();
	int width = 600;//변수 선언
	int height = 400;
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jf.setSize(300,400);
		jf.setSize(width,height);//변수 사용
		jf.setLayout(null);
		jf.setVisible(true);
		
	}// end of initDisplay
	public static void main(String[] args) {
		JFrameTest_3 jtf = new JFrameTest_3();
		jtf.initDisplay();
	}

}// end of JFrameTest
