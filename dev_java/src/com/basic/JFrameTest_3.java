package com.basic;

import javax.swing.JFrame;

public class JFrameTest_3 {
	// 선언부
	JFrame jf = new JFrame();
	// 화면 처리부
	public void initDisplay(int width, int height, boolean isView, String title) {
		jf.setTitle(title);
		jf.setSize(width, height);
		jf.setVisible(isView);
	}
	// 메인 메소드
	public static void main(String[] args) {
		JFrameTest_3 jft 	= new JFrameTest_3();
		int 		 width  = 300;
		int 		 height = 500;
		boolean 	 isView = true;
		String 		 title  = "윈도창 띄우기";
		jft.initDisplay(width, height, isView, title);
	}
}
