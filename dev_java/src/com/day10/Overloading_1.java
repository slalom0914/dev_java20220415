package com.day10;
// 두 개의 클래스가 A is a  B관계에 있을 때 
// 객체 지향 언어에서는 상속관계로 설계한다
// 전변은 초기화를 생략할 수 있다 | 없다
// 전변의 경우 생성자를 통해서 초기화를 대신 지원 받는다.
class Super{
	// 파라미터가 아무것도 없으니까 생략하면 JVM 대신 로딩해준다.
	Super(){// 파라미터가 없는 생성자를 디폴트 생성자라 한다.
		System.out.println("Super() 호출 성공");
	}
	public void methodA() {
		System.out.println("Super - methodA호출 성공");
	}
}
class Sub extends Super{
	Sub(){// 파라미터가 없는 생성자를 디폴트 생성자라 한다.
		System.out.println("Sub() 호출 성공");
	}
	@Override
	public void methodA() {
		System.out.println("Sub - methodA호출 성공");
	}
	
}
public class Overloading_1 {

	public static void main(String[] args) {
		//Super sup = new Super();
		//sup.methodA();// Super - methodA호출 성공
		Sub   sub = new Sub();
		sub.methodA();// Sub - methodA호출 성공
		// 선언부의 타입과 생성부의 타입이 다를 수 있다. -  폴리모피즘,  다형성
		//Super sup1 = new Sub();
		// 자바에서는 선언부의 이름으로 생성된다 | 아니다 생성부의 이름으로 생성된다.
		//sup1.methodA();
	}

}
