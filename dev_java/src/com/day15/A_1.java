package com.day15;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JVM이 자동으로 검색할 수 있는 패키지는 java.lang뿐입니다.
// 이것을 제외한 나머지 패키지에 대해서는 반드시 import해주어야 함
import javax.swing.JButton;
import javax.swing.JFrame;

public class A_1 extends JFrame implements ActionListener{
	// 인터페이스는 단독으로 인스턴스화가 불가하다.
	// 위의 이유로 해서 인터페이스 안에는 추상메소드만 올 수 있다.
	// 추상메소드란 선언부 뒤에 세미콜론으로 끝나는 경우를 말한다.
	// 아래 있는 initDisplay메소드의 경우 좌중괄호와 우중괄호가 있으니까
	// 추상메소드가 아니다.
	// 메소드 이름 뒤에 세미콜론으로 끝나면 메소드 호출이라 했잖아 
	// 추상메소드에는 리턴타입이 올 수 있음
	// 접근제한자도 올 수 있죠
	// 생성부에는 반드시 구현체 클래스 이름이 와야 한다.
	// ActionListener al = new A_1();
	B_1 b = new B_1();// 초기화와 생성을 한 번에 한 경우이다.
	JButton jbtn_insert = new JButton("입력");
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		//입력버튼이 눌려졌을때 이벤트를 감지하고 콜백메소드를 호출하는 코드추가
		//현재 클래스 안에 actionPerformed라는 메소드가 재정의(오버라이딩) 안됨
		// 이벤트 처리를 담당하는 클래스를 외부에 둘 수도 있다.
		// FlowLayout API를 이용해서 배치할때는 동,서, 남, 북, 중앙 배치 불가하다.
		// 어 그럼 아까는 왜 되는 건가요? - 디폴트라서 BorderLayout이 기본이라서 생략할 수 있어서
		this.setLayout(new FlowLayout());
		jbtn_insert.addActionListener(this);
		// this는 A_1클래스를 의미하고 add메소드는 JFrame창에 버튼을 붙이는기능
		// this에 무엇을 붙일 것인가는 파라미터를 통해서 결정할 수 없다.
		this.add(jbtn_insert);
		this.setSize(400, 500);
		this.setVisible(true);
	}/////// end of initDisplay
	public static void main(String[] args) {
		//A_1 a = new A_1();
		// 시스템이 중지하는 원인은 어느 라인에 있다고 생각하시나요?
		A_1 a = null;// 타입만 정해졌다.
		//a = new A_1();
		// A_1클래스에 대해서 선언만 되어 있고 생성이 되지 않은 상태에서 메소드 호출이 일어났다.
		a.initDisplay();// NullPointerException이 발생하면 그 뒤에 어떤 코드도 실행기회를 갖지 못함
	}
	
	// 아래 메소드는 ActionListener라는 인터페이스에 선언되어 있는 추상메소드이다.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
