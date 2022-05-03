package com.day10;
class TestSuper{
	// 파라미터가 있는 생성자가 하나라도 있다면 자동으로 제공안됨.
	TestSuper(){}
	TestSuper(int i){
		System.out.println("TestSuper(int i)호출 성공");
	}
}
class TestSub extends TestSuper{
	
}
public class TestAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
