package com.day19;

import java.util.ArrayList;
import java.util.List;
// 생성자도 메소드 오버로딩의 컨벤션을 따른다.
// 같은 이름의 생성자를 여러개 가질 수 있다.
// 클래스 쪼개기 자유자재로 구성할 수 있다.- 생성자 역할 필수임
// MVC패턴을 적용한 게시판 구현, 프로젝트 구현시 
public class ListTest_1 {
	// 다형성 누릴 수  있다.
	// 변수 list는 List타입이고요, 구현체 클래스 이름은 ArrayList입니다.
	// 선언부와 생성부의 타입이 다르다 - 다형성
	List<String> list = new ArrayList<>();
	// 인터페이스 이름은 생성부에 올 수 없다.
	//List<String> list2 = new List<>();
	public ListTest_1() {
		System.out.println("디폴트 생성자 호출");
	}
	public ListTest_1(int i) {
		System.out.println("파라미터가 int인 생성자 호출");
		list.add("토마토");
		list.add(1,"딸기");
		list.add("수박");
	}
	public static void main(String[] args) {
		ListTest_1 lt = new ListTest_1();//디폴트 생성자 호출
		// 문제제기 - 디폴트 생성자에는 ArrayList에 대한 초기화가 없다.
		// 인스턴스화만 되어있는 상태와 원소까지도 추가된 상태인지를 구분해야 한다.
		int cnt = lt.list.size();//0출력
		System.out.println(cnt);
		lt = new ListTest_1(10);
		cnt = lt.list.size();//3출력
		System.out.println(cnt);
	}

}

/*
	인스턴스화 유형 3가지
	왜 하는거니? 클래스 내부에 정의된 변수, 메소드(static있고 , 없는)
	첫번째 유형 - 기초
	선언부와 생성부가 같은 타입이다. -  다형성을 기대할 수 없다.
	A a = new A();
	Sonata myCar = new Sonata();
	MallardDuck herDuck = new MallardDuck();
	두번째 유형 - 메소드의 리턴타입으로 객체를 생성받는다.
	A a = 주소번지.methodA();// 메소드 호출을 통해서 객체를 주입 받는다.
	변수와 메소드를 누릴 수 있다. - 다른 클래스의 메소드를 호출할 수 있다. -재사용할 수 있다.
	public A methodA(){}
	
	변수는 같은 타입만 담을 수있다. - 단점
	배열도 같은 타입만 담을 수 있다. -단점
	그래서 객체 배열이 나왔다. Sonata myCars[] = new Sonata[5];
	중간에 끼워넣기가 불가하다
	늘였다 줄였다가 안된다.
	그런데 List는 다른 타입도 담을 수 있고 끼워넣기도 가능하고(list.add(2,"토마토"))
	add하면 계속 방이 늘어나고 remove(3) 방이 줄어든다.
	Object이면 모두 담을 수 있다. 타입이 달라도 담을 수 있다.
	
	세번째 유형 - 다형성을 기대할 수 있다.
	List nameList = new ArrayList();
	// 제네릭 - 내안에 있는 타입을 명시한다.
	List<String> nameList2 = new ArrayList<String>();
	// 생성부에 오는 명시적인 타입은 생략 가능하다. 대신 <> 다이어몬드 연산자를 붙여야 한다. 
	List<String> nameList2 = new ArrayList<>();
	
	// get(int i):Object - API
	오른쪽에 오는 타입이 왼쪽에 오는 타입 보다 절대로 반드시 큰 타입은 불가하다.
	만일 강제로 타입을 바꾸고 싶으면 캐스팅 연산자를 사용할것
	String name = (String)nameList.get(2);
	// 제네릭을 사용하는 경우에는 다이어몬드 연산자 안에 타입을 적어 놓았으므로 
	   명시적으로 알 수 있다 따라서 강제 형전환이 필요 없다
	String name = nameList2.get(2);
*/








