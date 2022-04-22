package com.quiz;

import javax.swing.JOptionPane;

public class Quiz1 {

	public static void main(String[] args) {
		// 당신의 몸무게를 알고 싶다.
		String userWeight = null;
		userWeight = JOptionPane.showInputDialog("당신의 몸무게는 얼마 입니까?");		
		// 달의 몸무게를 담을 변수 선언
		double moon_weight = 10.0;
		// 메소드의 파라미터에 String을 주면 double으로 형전환을 해주는 메소드
		double earth_weight = Double.parseDouble(userWeight);
		//userWeight*(17/100)
		System.out.println(earth_weight*(17/100.0));
		moon_weight = earth_weight*(17/100.0);
		System.out.println(moon_weight);
	}

}
