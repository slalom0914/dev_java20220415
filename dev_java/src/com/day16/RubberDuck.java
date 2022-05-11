package com.day16;

public class RubberDuck extends Duck {
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
	}
	@Override
	public void display() {
		System.out.println("나는 고무오리 입니다.");
	}

}
