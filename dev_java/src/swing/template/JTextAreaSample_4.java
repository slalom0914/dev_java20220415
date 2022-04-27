package swing.template;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaSample_4 implements ActionListener{
	JMenuBar    jmb			= new JMenuBar();
	JMenu       jm_file		= new JMenu("File");
	JMenuItem   jmi_new		= new JMenuItem("New");
	JMenuItem   jmi_open	= new JMenuItem("Open");
	JMenuItem   jmi_save	= new JMenuItem("Save");
	JSeparator  js_exit	    = new JSeparator();
	JMenuItem   jmi_exit	= new JMenuItem("종료");
	JMenu       jm_game		= new JMenu("Game");
	JMenuItem   jmi_ngame	= new JMenuItem("새게임");
	JMenuItem   jmi_dap 	= new JMenuItem("정답");
	JMenuItem   jmi_clear	= new JMenuItem("지우기");
	JMenuItem   jmi_out 	= new JMenuItem("나가기");
	JFrame      jf			= new JFrame();
	JPanel 	    jp_center 	= new JPanel();
	JTextArea 	jta 		= new JTextArea();
	JScrollPane jsp 		= new JScrollPane(jta
			, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
			, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextField 	jtf 		= new JTextField();
	JPanel 	    jp_east   	= new JPanel();
	JButton 	jbtn_new  	= new JButton("새게임");
	JButton 	jbtn_dap  	= new JButton("정답");
	JButton 	jbtn_clear  = new JButton("지우기");
	JButton 	jbtn_exit  	= new JButton("종료");
	public void initDisplay() {
		jtf.addActionListener(this);
		jm_file.add(jmi_new);
		jm_file.add(jmi_open);
		jm_file.add(jmi_save);
		jm_file.add(js_exit);
		jm_file.add(jmi_exit);
		jm_game.add(jmi_ngame);
		jm_game.add(jmi_dap);
		jm_game.add(jmi_clear);
		jm_game.add(jmi_out);
		jmb.add(jm_file);
		jmb.add(jm_game);
		jf.setJMenuBar(jmb);
		jf.setTitle("JTextArea샘플");
		jtf.setBackground(Color.lightGray);
		jp_center.setLayout(new BorderLayout());
		jp_center.add("Center", jsp);
		jp_center.add("South", jtf);
		jf.add("Center", jp_center);
		jp_east.setLayout(new GridLayout(4,1));
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit);
		jf.add("East", jp_east);
		jf.setSize(400, 300);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		JTextAreaSample_4 jtas = new JTextAreaSample_4();
		jtas.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jtf) {
			jta.append(jtf.getText()+"\n");
			jtf.setText("");
		}
	}
}
