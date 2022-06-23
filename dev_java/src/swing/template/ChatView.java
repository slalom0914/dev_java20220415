package swing.template;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ChatView extends JFrame {
	JPanel jp_first 	= new JPanel(); 
	JTextArea jta = new JTextArea("테스트",5,20);
	JScrollPane jsp_display = new JScrollPane(jta);
	JPanel jp_first_south 	= new JPanel(); 
	JPanel jp_first_east 	= new JPanel(); 
	JTextField jtf_msg = new JTextField(10);
	JButton jbtn_emoticon = new JButton("이모티콘");
	JButton jbtn_send = new JButton("전송");
	JPanel jp_second 	= new JPanel(); 
	JPanel jp_second_south 	= new JPanel(); 
	JButton jbtn_whisper = new JButton("1:1");
	JButton jbtn_member = new JButton("회원정보수정");
	JButton jbtn_exit = new JButton("나가기");
	
	String cols[] = {"대화명"};
	String data[][] = new String[3][1];
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb);
	JSplitPane jspp = new JSplitPane(SwingConstants.VERTICAL, jp_first,jp_second);
	public ChatView() {
		initDisplay();
	}
	public void initDisplay() {
		jp_second_south.setLayout(new GridLayout(1,3));
		jp_second_south.add(jbtn_whisper);
		jp_second_south.add(jbtn_member);
		jp_second_south.add(jbtn_exit);
		jp_first_south.setLayout(new BorderLayout());
		jp_first_east.setLayout(new GridLayout(1,2));
		jp_first_east.add(jbtn_emoticon);
		jp_first_east.add(jbtn_send);
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jp_first_east);
		jspp.setPreferredSize(new Dimension(400,200));
		//jspp.setOrientation(SwingConstants.VERTICAL);
		jp_first.setBackground(Color.orange);
		jp_second.setBackground(Color.green);
		jp_first.setLayout(new BorderLayout());
		jp_second.setLayout(new BorderLayout());
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jp_first_south);
		jp_second.add("Center", jsp);
		jp_second.add("South", jp_second_south);
		//this.add("Center",jp_first);
		//this.add("East",jp_second);
		this.add(jspp);
		this.setSize(600,400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ChatView();
	}

}
