package com.week1;

import javax.swing.JButton;

public class ReferenceType_2 {

	public static void main(String[] args) {
		JButton jbtns[] = new JButton[3];
		JButton jbtn1 = new JButton("하나");
		jbtns[0] = jbtn1;
		System.out.println(jbtns);
		System.out.println(jbtns[0]);
	}

}
