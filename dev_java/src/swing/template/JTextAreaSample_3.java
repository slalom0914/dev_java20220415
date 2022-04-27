package swing.template;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaSample_3 implements ActionListener{
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
		JTextAreaSample_3 jtas = new JTextAreaSample_3();
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
