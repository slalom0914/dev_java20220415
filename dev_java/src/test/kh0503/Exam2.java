package test.kh0503;
// 변수 선언시 타입 앞에 final이 있으면 상수가 된다.
// 메소드 앞에 final이 오면 오버라이딩이 안된다.
// 클래스 앞에 final이 오면 상속이 안된다.
public class Exam2 {
	// 너는 클래스급 인데 왜 문자열 값이 나오지?
	String name = "이순신";
	double PI = 3.14;
	public static void main(String[] args) {
		Exam2 e2 = new Exam2();
		System.out.println(e2.name);
		System.out.println(e2.PI);// 3.14
		e2.PI = 5.1;

	}

}
