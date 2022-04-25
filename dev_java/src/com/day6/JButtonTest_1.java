package com.day6;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest_1 {
	JFrame jf = new JFrame();
	// 선언과 생성을 나우어 처리하는 경우에는 객체 생성에 대한
	// 시점에 문제가 발생할 수 있다.
	// 선언이 먼저 사용이 나중이다
	// 선언만 되어 있어도 문법 에러는 발생하지 않는다.
	// 그러나 new예약어를 통해서 실제 클래스가 메모리에 로딩이 
	// 안되어 있다면 NullPointerException과 같은
	// 런타임 에러를 만날 수 있다.
	JButton jbtn_north = null;
	JButton jbtn_center = new JButton("중앙");
	// 화면을 그리는 메소드 선언
	public void initDisplay() {
		// 선언부와 생성부를 나누어서 인스턴스화 할 수 있다.
		jbtn_north = new JButton("조회");
		jbtn_north = null;
		// 새로운 주소번지를 갖는다
		jbtn_north = new JButton("입력");
		jf.add("North", jbtn_north);
		jf.add("Center", jbtn_center);
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		JButtonTest_1 jbt = new JButtonTest_1();
		jbt.initDisplay();

	}

}
