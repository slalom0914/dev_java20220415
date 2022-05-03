package com.day10;

import javax.swing.JButton;

// 가능하면 main메소드에 코딩을 하지 않는다. - 잘하는 사람
public class SonataSimulation {

	public static void main(String[] args) {
		Sonata myCar = new Sonata(65,"자주색",4);
		Sonata herCar = new Sonata("핑크");
		System.out.println(herCar.carColor);
		System.out.println(myCar+", "+herCar);
		System.out.println(myCar.toString()+", "+herCar.toString());
		JButton jbtn = new JButton("전송");
		System.out.println(jbtn);
	}

}
