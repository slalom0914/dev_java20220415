package com.day19;

import com.day16.Duck;
import com.day16.MallardDuck;
import com.day16.RubberDuck;
// 생성부와 선언부의 이름이 다르면 안된다. - 상속관계, 인터페이스를 implements
public class DuckTest {
	// 파라미터에 더 상위 클래스 타입을 적어주면 다양한 구현체 클래스를 받을 수 있다. - 다형성 기대 가능함
	// 같은 이름의 메소드가 호출되더라도 기능이 서로 다르게 동작된다.
	// 선언부와 생성부의 이름이 다를때 가능하다.
	// 이것이 가능하려면 상속관계 or 인터페이스의 구현체 클래스 이라면 가능함
	public void methodA(Duck duck) {
		System.out.println("methodA(Duck)");
		if(duck instanceof RubberDuck) {// 너 RubberDuck타입 이니?
			System.out.println("나는 RubberDuck 타입 입니다.");
		}else if(duck instanceof MallardDuck) {
			System.out.println("나는 MallardDuck 타입 입니다.");			
		}else {// 그 나머지 else인 경우에는  조건문이 올 수 없다.
			System.out.println("나는 기타 Duck 타입 입니다.");						
		}
		System.out.println(duck);
	}
	public void methodA(MallardDuck duck) {
		System.out.println("methodA(MallardDuck)");
		System.out.println(duck);		
	}
	// 메소드의 파라미터 자리는 선언만. 초기화는  불가함 - 그변수의 값을 정할 수 없다.
	public void methodC(int i) {
		System.out.println(i);
	}
	public static void main(String[] args) {
		DuckTest dt = new DuckTest();
		Duck myDuck = new RubberDuck();
		Duck herDuck = new MallardDuck();
		// 인스턴스 변수가 있으면 다른 변수나 다른 메소드 호출시 재사용 가능함
		// new RubberDuck(); 한번만 사용가능함 - 재사용 불가
		dt.methodA(new RubberDuck());// 
		dt.methodA(herDuck);// 
		dt.methodA(myDuck);// pass by value(주소번지-원본) <-> call by value(복사본)
		//dt.methodB(new MallardDuck());
		dt.methodC(5);
		//dt.methodA(참조형타입);// 타입이 달라요
	}

}
