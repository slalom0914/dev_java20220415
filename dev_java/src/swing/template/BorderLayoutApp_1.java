package swing.template;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// BorderLayoutApp.java 소스는 하나인데 
// 클래스는 두 개가 만들어 져요. 
// BorderLayoutView.class
// BorderLayoutApp.class
// 이벤트 처리를 담당하는 인터페이스가 필요해요 - ActionListener -> 인터페이스 -> 인터페이스가 정의하고 있는 actionPerformed메소드를 재정의해야함
class BorderLayoutView1 implements ActionListener{
	JFrame jf = new JFrame();
	JButton jbtn_north = new JButton("북쪽");
	JButton jbtn_south = new JButton("남쪽");
	JButton jbtn_center = new JButton("중앙");
	JButton jbtn_east = new JButton("동쪽");
	JButton jbtn_west = new JButton("서쪽");
	int width = 500;
	int height = 400;
	public BorderLayoutView1() {
		System.out.println("디폴트 생성자 호출 성공");
		// 이벤트 소스(주소번지)와 
		jbtn_north.addActionListener(this);
	}
	public void initDisplay() {
		// 실행문
		System.out.println("initDisplay 호출 성공");
		jbtn_north.setBackground(Color.lightGray);
		jf.add("North", jbtn_north);
		jf.add("South", jbtn_south);
		jf.add("Center", jbtn_center);
		jf.add("East", jbtn_east);
		jf.add("West", jbtn_west);
		jf.setSize(width, height);
		jf.setVisible(true);
	}
	// 메소드 오버라이딩 - 어노테이션 - 강제사항
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//이벤트 소스를 가져온다
		System.out.println("주소번지  @4321bbca"+obj);
		String jbtnLabel = e.getActionCommand();
		System.out.println(jbtnLabel);
		if(jbtn_north == obj) {
			System.out.println("북쪽 버튼 클릭 성공");
		}
		
	} 
}
public class BorderLayoutApp_1 {

	public static void main(String[] args) {
		//insert here
		// 클래스타입 변수명(주소번지출력) = new 클래스명();
		BorderLayoutView1 blView = new BorderLayoutView1();
		blView.initDisplay();//메소드 호출

	}

}
