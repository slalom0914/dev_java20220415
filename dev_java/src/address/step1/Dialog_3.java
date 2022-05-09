package address.step1;

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
	JScrollPane jsp = new JScrollPane();
	JPanel jp_north = new JPanel();
	JButton jbtn_save = new JButton("저장");
	Main_3 main_3 = null;
	public Dialog_3() {
	}
	public Dialog_3(Main_3 main_3) {
		this.main_3 = main_3;
	}
	public void initDisplay() {
		jbtn_save.addActionListener(this);
		jp_north.add(jbtn_save);
		this.add("North", jp_north);
		this.add("Center",jsp);
    	this.setTitle(title);
    	this.setSize(300, 400);
    	this.setVisible(true);
	}
	public void set(String title) {
		this.title = title;
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
