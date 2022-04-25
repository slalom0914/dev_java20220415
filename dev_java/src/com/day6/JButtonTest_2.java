package com.day6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest_2 implements ActionListener{
	JFrame jf = new JFrame();
	JButton jbtn_north = null;
	JButton jbtn_center = new JButton("중앙");
	JButton jbtn_change = new JButton("변경");
	// 화면을 그리는 메소드 선언
	public void initDisplay() {
		// 이벤트 소스와 이벤트 처리 담당 핸들러 클래스 매핑해줌
		// 파라미터에 this는 이벤트 처리를 하는 메소드가 내안에 있을 때 사용
		jbtn_change.addActionListener(this);
		// 선언부와 생성부를 나누어서 인스턴스화 할 수 있다.
		jbtn_north = new JButton("조회");
		jf.add("North", jbtn_north);
		jf.add("Center", jbtn_center);
		jf.add("South", jbtn_change);
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	public boolean buttonChange() {
		System.out.println("buttonChange() 호출 성공");
		boolean isOk = false;
		jbtn_north = null;
		// 새로운 주소번지를 갖는다
		jbtn_north = new JButton("입력");
		jbtn_north.setBackground(Color.cyan);
		jf.add("North", jbtn_north);
		jf.revalidate();
		return  isOk;
	}
	public static void main(String[] args) {
		JButtonTest_2 jbt = new JButtonTest_2();
		jbt.initDisplay();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트가 감지된 주소번지가 담겨요
		Object obj = e.getSource();
		// 만일 버튼의 라벨을 알고 싶다면? 아래처럼 사용합니다
		String command = e.getActionCommand();
		if(obj == jbtn_change) {
			System.out.println("변경 버튼 눌렸어요");
			buttonChange();
		}
		
	}

}
