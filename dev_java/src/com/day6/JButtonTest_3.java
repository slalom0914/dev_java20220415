package com.day6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 버튼에 이벤트 처리를 위해 ActionListener 인터페이스를 implements함
// 이벤트 처리를 담당하는 이벤트 핸들러 클래스 역할도 같이 하게 됨
public class JButtonTest_3 implements ActionListener{
	// 윈도우에 자바로 만든 창 생성하는데 필요함
	JFrame jf = new JFrame();
	// 버튼을 생성할 수 있는 타입
	JButton jbtn_north = null;// 선언만 하였음
	JButton jbtn_center = new JButton("중앙");
	JButton jbtn_change = new JButton("변경");
	// 변경 버튼을 눌렀을 때 토글버튼 처리를 위한 변수 선언
	int i = 0;
	// 화면을 그리는 메소드 선언
	public void initDisplay() {
		// 이벤트 소스와 이벤트 처리 담당 핸들러 클래스 매핑해줌
		// 파라미터에 this는 이벤트 처리를 하는 메소드가 내안에 있을 때 사용
		jbtn_change.addActionListener(this);
		// 선언부와 생성부를 나누어서 인스턴스화 할 수 있다.
		jbtn_north = new JButton("조회");
		// 버튼을 북쪽에 배치함
		jf.add("North", jbtn_north);
		// 버튼을 중앙에 배치함
		jf.add("Center", jbtn_center);
		// 버튼을 남쪽에 배치함
		jf.add("South", jbtn_change);
		// 창의 가로는 500 세로는 400으로 함
		jf.setSize(500, 400);
		// 화면에 보여주세요 - true
		jf.setVisible(true);
	}
	// 사용자 정의 메소드 선언 및 구현함
	public boolean buttonChange() {
		System.out.println("buttonChange() 호출 성공");
		// 버튼의 변경 처리 결과를 담을 변수 선언
		boolean isOk = false;
		jbtn_north = null;
		// 새로운 주소번지를 갖는다
		jbtn_north = new JButton("입력");
		if(i==0) {
			// 버튼의 배경색 바꾸기
			jbtn_north.setBackground(Color.cyan);
			// 아래 초기화를 하지 않거나 생략한다면 어떤 결과가???
			i = 1;
		}
		else if(i==1) {
			jbtn_north.setBackground(Color.orange);
			// 아래 초기화를 하지 않거나 생략한다면 어떤 결과가???
			i = 0;
		}
		jf.add("North", jbtn_north);
		// 이미 화면이 한 번 그려진 상태에서 변경된 버튼을 반영하여 새로 렌더링 하기
		jf.revalidate();
		isOk = true;
		return  isOk;
	}
	public static void main(String[] args) {
		JButtonTest_3 jbt = new JButtonTest_3();
		jbt.initDisplay();

	}
	// 이벤트 감지가 되었을 때 시스템에서 호출되는 콜백메소드 임
	// ActionListener인터페이스의 구현체 클래스이면 반드시 재정의해야 하는
	// 메소드 입니다 - 메소드 오버라이딩 이라고 함
	// 자바에서는 같은 이름의 메소드를 여러개 정의할 수  있습니다
	// 그것을 가능하게 해주는 컨벤션 입니다
	// 메소드 오버로딩도 같은 이름의 메소드를 여러개 정의할 수 있는 컨벤션 입니다.
	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트가 감지된 주소번지가 담겨요
		Object obj = e.getSource();
		// 만일 버튼의 라벨을 알고 싶다면? 아래처럼 사용합니다
		String command = e.getActionCommand();
		if(obj == jbtn_change) {
			System.out.println("변경 버튼 눌렸어요");
			boolean isOk = buttonChange();
			if(isOk) System.out.println("버튼이 변경되었습니다.");
		}
	}
}
