package com.day16;

public class DuckSimulation {

	public static void main(String[] args) {
		Duck myDuck = new MallardDuck();
		// MallardDuck은 FlyBehavior 의  구현체 클래스가 아니다.
		// MallardDuck은 fly메소드를 직접 오버라이딩 하지 않는다.
		myDuck.performFly();
		myDuck.display();
		myDuck = null;
		myDuck = new RubberDuck();
		myDuck.display();
		myDuck.performFly();
		WoodDuck herDuck = new WoodDuck();
		herDuck.display();
		herDuck.performFly();
		herDuck = (WoodDuck)myDuck;
		herDuck.display();
		//myDuck = herDuck;
	}

}
