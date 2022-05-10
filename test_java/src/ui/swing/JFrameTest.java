package ui.swing;

import javax.swing.*;
import java.awt.*;

public class JFrameTest extends JFrame {
    private JButton btnInsert = new JButton("입력");
    private JButton btnUpdate = new JButton("수정");
    private JButton btnDelete = new JButton("삭제");
    private JButton btnSelect = new JButton("조회");
    private JButton btnDetail = new JButton("상세보기");
    public void initDisplay() {
        //창의 x버튼을 눌렀을 때 열린 화면에 자원을 회수합니다.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JFrame은 디폴트 레이아웃이 BorderLayout인데 내가 굳이 일부러 FlowLayout변경설정합니다.
        // FlowLayout은 디폴트가 왼쪽에서 오른쪽으로 배치가 되는 레이아웃을 담당하는 클래스 입니다.
        this.setLayout(new FlowLayout());
        // 입력 버튼이 눌려졌을 때 누가? JVM이 감지하고 이벤트 처리 메소드를 호출해주는 역할
        // 아래 코드가 없으면 느낄 수가 없다. - 딱 한번만 호출되어야 한다.
        // this: who? Main_1 ,  super: who? JFrame
        // 내(나-Main_1) 안에서 add, setTitle, setSize, setVisible 메소드를 선언 및 구현한 적이 없다.
        this.add(btnInsert);// 부모가 제공하는 메소드를 호출한다. 세미콜론으로 끝났잖아요
        this.add(btnUpdate);
        this.add(btnDelete);
        this.add(btnSelect);
        this.add(btnDetail);
        this.setTitle("메인 Ver1.0");
        this.setSize(700, 500);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        JFrameTest abook = new JFrameTest();
        abook.initDisplay();
    }
}
