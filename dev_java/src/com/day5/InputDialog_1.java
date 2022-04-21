package com.day5;

import javax.swing.JOptionPane;

//사용자로 부터 입력받는 값을 읽어오는데 필요한 다이얼로그 화면입니다

public class InputDialog_1 {

	public static void main(String[] args) {
		// 사용자에 의한 첫번째 문자열 입력
		String inputValue = null;
		inputValue = JOptionPane.showInputDialog("당신의 국어점수는 몇점 입니까?");
		System.out.println("당신의 국어 점수는 : " + inputValue);
	}

}
