package com.day16;
// FlyWithWings는 FlyBehavior인터페이스의 구현체 클래스 이다.
// 왜 그렇게 말하는 거죠?
// FlyBehavior에 있는 추상메소드를 내가 오버라이딩 하고 있잖아
// 아래 클래스는 고무오리와 청둥오리중에 누구의 구현체 클래스가 되어야 하나요?

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("날고 있어요.");
	}

}
