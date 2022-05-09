package com.day14;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Dialog_2 extends JDialog {
   String title = null;// 전변에 저장된다
   public void initDisplay() {
       this.setTitle(title);// 파라미터로 넘어온 입력,수정, 상세보기
       this.setSize(300, 400);
       this.setVisible(true);
   }
   public void set(String title) {// 입력 or 수정 or 상세보기
      this.title = title;
   }
}

