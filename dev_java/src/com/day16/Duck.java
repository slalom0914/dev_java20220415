package com.day16;
// 클래스 선언부에 abstract가 붙으면 추상클래스 선언이다.
public abstract class Duck {
	FlyBehavior flyBehavior = null;
	// 추상클래스는 생성자를 가질 수 있다.
	public Duck() {
	//  추상클래스에서는 구현체 클래스를 결정할 수 없다.
	// 왜냐하면 구체적인 클래스가 정해지지 않았다.  
	// WoodDuck인지 RubberDuck인지 아니면 MallardDuck인지가
		//flyBehavior = new FlyWithWings();
	}
	//QuackBehavior quackBehavior = null;
	// 고무오리와 나무오리와 청둥오리는 외모가 각기 다르다.
	// 서로 다른 외모를 구현하려면 구현체 클래스가 필요하다.
	public abstract void display();
	public void performFly() {// 바로 이코드로 인해 결합도가 낮아지게 된다.
		flyBehavior.fly();
	}
	public void swimming() {
		System.out.println("모든 오리는 물 위에 뜬다.");
	}
}
