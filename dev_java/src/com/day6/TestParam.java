package com.day6;

class Param{
	int ival;// 전변 초기화 생략 가능 - 0
}
public class TestParam {
	void effectParam(Param p) {
		p = new Param();
		p.ival = 300;
		System.out.println("sub ival : "+p.ival);// 300
	}
	public static void main(String[] args) {
		TestParam tp = new TestParam();
		Param p = new Param();
		p.ival  = 500;
		tp.effectParam(p);
		System.out.println("main ival : " + p.ival);//300

	}

}
/*
 * 12번: 나 자신에 대한 인스턴스화 이다.
 * 왜 인스턴스화를 했나요? - 15번의 effectParam메소드를 호출하기 위해서
 * 14번에서는 13번에서 인스턴스화 된 클래스의 전변인 ival변수에
 * 초기값이 0 대신 500으로 덮어쓰기가 발생함 
 * 아직은 출력하는 문장을 만나지 못함
 * 15번 effectParam의 메소드를 경유하게 되는데 이때 13번에서 정의된 객체의
 * 주소번지를 가지고 7번으로 진입합니다.
 * 7번의 지변 p와 13번 p의 주소번지는 같다 if(s==s1)
 * 따라서 8번의 ival변수의 300은 13번에서 만들어진 원본 클래스의 전변이 변경
 * 되는 것입니다.
 * 
*/