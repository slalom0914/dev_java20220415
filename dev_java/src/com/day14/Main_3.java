package com.day14;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.util.List;
// 메인에서 입력 혹은 수정 혹은 상세보기라는 3가지 업무에 대해서 Dialog_3 하나의 클래스를
// 단 한번만 인스턴스화 한 자료를 가지고 모두 처리를 하고 싶다. 어떡하지?
// 입력할때는 빈칸을 제공하고 새로입력한 값을 저장해야 한다. - 업무 역할
// 수정일때는 기존에 등록된 정보에 대해서 일부를 변경지원한다.
// 입력한 내용 또는 수정할 때 기존 정보를 제공하기 위해서라도 한 건에 대한 상세조회가 선행되어야 한다.
public class Main_3 extends JFrame implements ActionListener{
   // 메인화면에 사용할 컴포넌트들을 선언합니다.
    private JButton btnInsert = new JButton("입력");
    private JButton btnUpdate = new JButton("수정");
    private JButton btnDelete = new JButton("삭제");
    private JButton btnSelect = new JButton("조회");
    private JButton btnDetail = new JButton("상세보기");
    Dialog_3 dialog = new Dialog_3();
    static Main_3 abook = null;
    public Main_3() {
       initDisplay();
    }
   public void initDisplay() {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLayout(new FlowLayout());
       btnInsert.addActionListener(this);
       btnUpdate.addActionListener(this);
       btnDetail.addActionListener(this);
       this.add(btnInsert);
       this.add(btnUpdate);
       this.add(btnDelete);
       this.add(btnSelect);
       this.add(btnDetail);
       this.setTitle("메인 Ver1.0");
       this.setSize(700, 500);
       this.setVisible(true);
   }
   public void refreshData() {
      System.out.println("refreshData 호출 성공");
      // 새로고침 후에 자손 화면을 닫기(자손클래스의 자원 반납을 받는 메소드 호출)
      dialog.dispose();
   }
   public static void main(String[] args) {
      abook = new Main_3();
      //abook.initDisplay();
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if(btnInsert == obj) {
    	 // 자손 클래스에서 부모클래스의 refreshData메소드를 호출하고 싶어요
    	 // 그래서 this를 자손클래스의 set메소드의 파라미터로 넘겨주자
         dialog.set("입력",true, this);
      }
      else if(btnUpdate == obj) {
         dialog.set("수정", true, this);
      }
      else if(btnDetail == obj) {
         dialog.set("상세조회", true, this);
      }
   }
}

