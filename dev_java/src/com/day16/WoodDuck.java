package com.day16;

public class WoodDuck extends Duck {
	// flyBehavior라는 인터페이스 타입 변수로 구현체 클래스를 생성한다.
	public WoodDuck() {
		// 생성부에 어떤 클래스가 오는가에 따라 동일한 메소드가 호출되더라도
		// 기능이 다 다르다
		flyBehavior = new FlyNoWay();
	}
	// 외모를 구현함
	@Override
	public void display() {
		System.out.println("나무 오리 입니다.");
	}

}
