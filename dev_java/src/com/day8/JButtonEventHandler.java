package com.day8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonEventHandler implements ActionListener {
	// 선언부
	JButtonView jButtonView = null;
	public JButtonEventHandler(JButtonView jButtonView) {
		this.jButtonView = jButtonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String command = e.getActionCommand();
		//if(obj == jButtonView.jbtn_north) {
		if("조회".equals(command)) {
			System.out.println("조회 버튼 클릭 성공");
		}

	}

}
