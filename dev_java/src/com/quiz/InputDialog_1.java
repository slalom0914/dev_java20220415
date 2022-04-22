package com.quiz;

import javax.swing.JOptionPane;

class Moon {
	static double Gv= Earth.Gv * 0.17; 
}
class Earth {
	static int Gv  = 1;
}
public class InputDialog_1 {
	public static void main(String[] args) {		
		String inputValue = null;
		inputValue = JOptionPane.showInputDialog("당신의 몸무게는?");
		Double Weight = Double.valueOf(inputValue);
		System.out.println("지구몸무게 : " + (Weight * Earth.Gv));
		System.out.println("달 몸무게 : " + (Weight * Moon.Gv + "kg"));
	}
}

