package swing.template;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

// BorderLayoutApp.java 소스는 하나인데 
// 클래스는 두 개가 만들어 져요. 
// BorderLayoutView.class
// BorderLayoutApp.class
class BorderLayoutView{
	// 인스턴스화 하기 -  syntax-> 타입 인스턴스변수명 = new 생성할 클래스명();//  생성자
	// 생긴 모양이 괄호가 있으면 셋중에 하나이다. 메소드, 생성자, Casting연산자 -  메소드 오버라이딩과 메소드 오버로딩
	JFrame jf = new JFrame();
	// 상수로 되어 있는 것들을 변수로 바꿔보자
	String send = "전송";
	JButton jbtn_north = new JButton(send);
	JButton jbtn_south = new JButton("남쪽");
	JButton jbtn_center = new JButton("중앙");
	JButton jbtn_east = new JButton("동쪽");
	JButton jbtn_west = new JButton("서쪽");
	int width = 500;
	int height = 400;
	public void initDisplay() {
		// 실행문
		System.out.println("initDisplay 호출 성공");
		jbtn_north.setBackground(Color.red);
		// 버튼을 배치할 위치 정보를 담는 변수 선언
		String north = "North";
		jf.add(north, jbtn_north);
		jf.add("South", jbtn_south);
		jf.add("Center", jbtn_center);
		jf.add("East", jbtn_east);
		jf.add("West", jbtn_west);
		jf.setSize(width, height);
		jf.setVisible(true);
	} 
}
public class BorderLayoutApp {

	public static void main(String[] args) {
		//insert here
		// 클래스타입 변수명(주소번지출력) = new 클래스명();
		BorderLayoutView blView = new BorderLayoutView();
		blView.initDisplay();//메소드 호출

	}

}
