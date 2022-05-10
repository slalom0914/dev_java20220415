package address.step1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Parent_2 extends JFrame{
	// 메인화면에 사용할 컴포넌트들을 선언합니다.
    private JButton btnInsert = new JButton("입력");
    private JButton btnUpdate = new JButton("수정");
    private JButton btnDelete = new JButton("삭제");
    private JButton btnSelect = new JButton("조회");
    private JButton btnDetail = new JButton("상세보기");
    Son_2 s = null;
    public Parent_2() {
    	System.out.println("디폴트 생성자 호출 성공");
    	initDisplay();
    	s = new Son_2();
    }
	public void initDisplay() {
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(new FlowLayout());
    	this.add(btnInsert);
    	this.add(btnUpdate);
    	this.add(btnDelete);
    	this.add(btnSelect);
    	this.add(btnDetail);
    	this.setTitle("메인 Ver1.0");
    	this.setSize(700, 500);
    	this.setVisible(true);
	}    
    
	public static void main(String[] args) {
		Parent_2 p = new Parent_2();
	}

}
