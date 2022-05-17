package com.day18;
import java.awt.FlowLayout;
import java.awt.Font;

// java.lang이 아닌 모든 패키지는 JVM이 접근할 수 없다.
// 반드시 import를 별도로 해야 한다.
import javax.swing.JFrame;

public class ToDoListView extends JFrame {
	javax.swing.JLabel jlb_timer = new javax.swing.JLabel("현재시간:");
	Font f = new Font("궁서체",Font.BOLD,40);
	public ToDoListView() {
		// 화면을 그리는 메소드를 디폴트 생성자에서 호출해 보기 -  표현력을 키운다, 위치를 다양하게 표현하기
		// 생성자 안에서 호출할 때는 인스턴스화가 필요없다.
		// 직접 호출이 가능하다.
		initDisplay();
		// 객체주입
		TimeClient tc = new TimeClient(jlb_timer);
		tc.start();// run()호출이 된다. - Thread검색 start()
	}
	public void initDisplay() {
		jlb_timer.setFont(f);
		this.setTitle("TODO Ver1.0");
		this.setLayout(new FlowLayout());
		this.add(jlb_timer);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		ToDoListView tv = new ToDoListView();
		//tv.initDisplay();
	}

}
