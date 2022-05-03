package test.kh0503;

public class Overloading {

	public void test() {}
	public void test(String str) {}
	public void test(int i) {}
	// 6번에 같은 갯수를 갖는 그리고 타입도 String으로 같은 메소드있음-에러발생함
	// 변수명이 str 과 s가 다른 것은 영향이 없다. 
	public void test(String s) {}
	// 파라미터가 1개 인건 있지만 char타입인건 없어서 합법
	public void test(char ch) {}
	// 파라미터의 갯수가 2개인건 없으니까 합법
	public void test(String str, int i) {}
	// 파라미터 갯수가 2개인게 14번라인에 있지만 
	public void test(int i, String str) {}
	// 위 7번 라인에 선언된 메소드와 중복 선언으로 에러발생함
	public void test(double d) {}
	// 파라미터가 한 개이면서 동시에 타입이 int메소드가 7번에 있어서
	// 아래 return타입만 바뀐 메소드는 중복선언으로 봐서 에러발생함
	public int test() {return 0;}
	
}

/*
 * 메소드 오버로딩 규칙
 * 무조건 파라미터의 갯수나 타입이 달라야 한다.
 * 접근제한자가 있고 없고는 영향이 없다.
 * 리턴타입이 있고 없고는 영향이 없다.
 * 파라미터의 변수이름이 다른것은 영향이 없다.
 * 
*/

// 문제해결 시나리오 평가는 예제 소스를 제시하고
// 원인과 조치내용에 대해 기술하는 평가입니다.