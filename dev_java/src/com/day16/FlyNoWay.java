package com.day16;
// FlyNoWay는 고무오리 혹은 나무오리의 구현체 클래스이면 된다.
// 고무오리와 청둥오리는 공통점이 있다.
// 둘다 물위에 뜬다.
public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("저는 못 날아요.");
	}

}
