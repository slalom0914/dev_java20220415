package com.day16;

public class MallardDuck extends Duck {
	public MallardDuck() {
		flyBehavior = new FlyWithWings();
		//flyBehavior = new FlyNoWay();
	}
	@Override
	public void display() {
		System.out.println("나는 청둥오리 입니다.");
	}

}
