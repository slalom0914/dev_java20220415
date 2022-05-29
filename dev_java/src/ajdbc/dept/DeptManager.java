package ajdbc.dept;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class DeptManager extends JFrame implements ActionListener{
	JPanel jp_north			= new JPanel();
	JButton jbtn_select		= new JButton("조회");
	JButton jbtn_insert		= new JButton("입력");
	JButton jbtn_update		= new JButton("수정");
	JButton jbtn_delete		= new JButton("삭제");
	String cols[] 			= {"부서번호","부서명","지역"};
	String data[][] 		= new String[0][3];
	DefaultTableModel dtm 	= new DefaultTableModel(data,cols);
	JTable jtb				= new JTable(dtm);
	JScrollPane jsp			= new JScrollPane(jtb);
	public DeptManager() {
		jbtn_select.addActionListener(this);
		jbtn_insert.addActionListener(this);
		jbtn_update.addActionListener(this);
		jbtn_delete.addActionListener(this);
		initDisplay();
	}
	public void initDisplay() {
		LineBorder lb = new LineBorder(Color.RED,3);
		LineBorder lb2 = new LineBorder(Color.BLUE,3);
		jp_north.setBorder(lb);
		jsp.setBorder(lb2);
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_select);
		jp_north.add(jbtn_insert);
		jp_north.add(jbtn_update);
		jp_north.add(jbtn_delete);
		this.add("North", jp_north);
		this.add("Center", jsp);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DeptManager();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if("조회".equals(command)) {
			System.out.println("조회 호출 성공");
		}
		else if("입력".equals(command)) {
			System.out.println("입력 호출 성공");
		}
		else if("수정".equals(command)) {
			System.out.println("수정 호출 성공");
		}
		else if("삭제".equals(command)) {
			System.out.println("삭제 호출 성공");
		}
	}

}
