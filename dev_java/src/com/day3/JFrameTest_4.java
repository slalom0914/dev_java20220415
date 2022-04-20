package com.day3;

import javax.swing.JFrame;

public class JFrameTest_4 {
	// 선언부
	JFrame jf = new JFrame();
	int width = 600;//변수 선언
	int height = 400;
	// 타입 변수명(네 마음대로... a,b,c...) = 값
	String name = "홍길동";
	public void initDisplay() {
		
		System.out.println("initDisplay 호출 성공");
		
		jf.setSize(width,height);//변수 사용
		jf.setTitle(name);// 홍길동 출력
		jf.setTitle("이순신");// 문자열 상수 - 이순신으로 덮어쓰기가 됨
		jf.setLayout(null);
		
		jf.setVisible(true);
		
		///
	}// end of initDisplay
	public static void main(String[] args) {
		JFrameTest_4 jtf = new JFrameTest_4();
		jtf.initDisplay();
	}

}// end of JFrameTest
