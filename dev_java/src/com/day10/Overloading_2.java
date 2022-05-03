package com.day10;
// 두 개의 클래스가 A is a  B관계에 있을 때 
// 객체 지향 언어에서는 상속관계로 설계한다
// 전변은 초기화를 생략할 수 있다 | 없다
// 전변의 경우 생성자를 통해서 초기화를 대신 지원 받는다.
class Super1{
	public int i = 0;
	// 필요가 없는 생성자라 하더라도 상속관계에 있을 때는 
	// 반드시 상위 클래스의 디폴트 생성자를 정의해야 합니다.
	Super1(){
		System.out.println("Super1 디폴트 생성자 호출");
	}
	Super1(String text){// 파라미터가 없는 생성자를 디폴트 생성자라 한다.
		System.out.println("Super1(text) 생성자 호출");
		this.i = 1;
	}
}
class Sub1 extends Super1{
	Sub1(String text){// 파라미터가 없는 생성자를 디폴트 생성자라 한다.
		// 내안에 변수 i가 선언되지 않았는데 왜 에러가 발생하지 않나요?
		// super는 상위 클래스를 가리키는 수정자 입니다.
		// 그 수정자뒤에 괄호가 붙으면 생성자를 호출하게 됩니다.
		super("Hello");
		i = 2;
	}

}
public class Overloading_2 {

	public static void main(String[] args) {
		// 자녀 클래스를 인스턴스화 하더라도 부모 클래스의 생성자를 
		// 먼저 호출하게 되는데 이때 선언된 생성자가 하나라도 존재하면
		// 디폴트 생성자라 하더라도 JVM이 제공하지 않는다.
		Sub1   sub = new Sub1("Hello");
		System.out.println(sub.i);//2
	}

}
