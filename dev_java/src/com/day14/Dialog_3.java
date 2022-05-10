package com.day14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Dialog_3 extends JDialog implements ActionListener{
   String title = null;
   boolean isView = false;// false이면 메모리에는 로딩되어 있지만 화면에는 비활성화 해줘 true이면 화면에도 보여줘
   JScrollPane jsp = new JScrollPane();
   JPanel jp_north = new JPanel();
   JButton jbtn_save = new JButton("저장");
   Main_3 main_3 = null;
   public Dialog_3() {
	   initDisplay();
   }
   // 자손의 클래스를 인스턴스화 하면 화면을 그리는 initDisplay() 호출되게 하자
   public Dialog_3(Main_3 main_3) {
	  //왜 파라미터에 부모의 주소를 받아야 하는가? 
      this.main_3 = main_3;
   }
   public void initDisplay() {
	   jbtn_save.addActionListener(this);
      jp_north.add(jbtn_save);
      this.add("North", jp_north);
      this.add("Center",jsp);
       this.setTitle(title);
       this.setSize(300, 400);
       this.setVisible(isView);
   }
   public void set(String title) {
      this.title = title;
   }
   public void set(String title, boolean isView, Main_3 main_3) {
	   this.setTitle(title);
	   this.setVisible(isView);
	   // 파라미터로 넘어온 주소번지를 전변에 재저장하기 - 원본의 주소번지를 담는다.
	   this.main_3 = main_3;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if(obj == jbtn_save) {
         // insert here - 부모의 메소드 호출하기 실습
         main_3.refreshData();
      }
   }
}

