package com.week1;
class A{
	
}
public class ASimulation {

	public static void main(String[] args) {
		A a = new A();
		A as[] = new A[3];
		A a1 = new A();
		as[0] = a1;
		System.out.println(a);// 주소번지가 출력된다 - 참조형 변수이다
		System.out.println(as[0]);// 주소번지가 출력된다 - 참조형 변수이다
	}

}
