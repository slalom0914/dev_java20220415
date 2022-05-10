package com.day15;

public interface MoveBehavior {
	final int i = 0;
	public abstract void run();
	// 인터페이스에서 선언된 모든 메소드는 추상메소드이다.
	// 인터페이스에서 선언된 모든 메소드가 추상메소드 이므로
	// abstract예약어는 생략이 가능하다.
	// 인터페이스에서 선언된 메소드의 리턴타입이 있더라도
	// 좌중괄호와 우중괄호를 쓸 수 없으므로 return예약어를
	// 쓰지 않아도 된다.
	public abstract int stop();
}
