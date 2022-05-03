package test.kh0503;

class Circle {
	// 정적 변수 double타입 선언 - PI는 인스턴스화 없이 다른 클래스에서도 사용가능
	// 변수 선언시 final이 붙으면 상수가 되어 다른값으로 재정의 불가함
	// 따라서 setPi 메소드는 생성되지 않는다
	public static final double PI = 3.14;
	// 반지름을 담을 변수 선언 - 전변이므로 초기화 생략가능 - double의 디폴트값은 0.0임
	public double radius;
	// 파라미터 있는 생성자 선언 및 전변 radius 초기화 구현함
	// Circle c=new Circle()로는 double radius가 없는 생성자 호출은 불가함
	public Circle(double radius) {
		this.radius = radius;
	}
	// getter메소드 호출하면 반지름이 저장된 값이 반환됨
	public double getRadius() {
		return radius;
	}
	// 파라미터로 넘어온 반지름값을 전변에 저장해줌
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public static double getPi() {
		return PI;
	}
	// 호출되면 반지름 3.1cm인 원을 그립니다.
	public void draw() {
		System.out.println("반지름 " +  radius + "cm인 원을 그립니다.");
	}
}

public class Run {

	public static void main(String[] args) {
		// 만일 아래서 Circle c = new Circle()로 작성하면 컴파일 에러 발생함
		// 왜냐하면 12번 라인에서 디폴트생성자가 아닌 그러니까 파라미터가 없는 생성자가 아닌
		// 파라미터가 double타입 1개인 생성자를 선언하고 있다.
		Circle c = new Circle(2);// 생성자 괄호안에 2를 안 적으면 컴파일 에러 발생함
		// 20번라인의 메소드 호출될 때 괄호안에 3.1이 20번 setRadius 파라미터에 복사되고
		// 21번 라인에서 this가 붙은 전역변수 radius에 3.1이 저장됨
		c.setRadius(3.1);
		c.draw();
		
	}

}
