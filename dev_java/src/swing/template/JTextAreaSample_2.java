package swing.template;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaSample_2 implements ActionListener{
	JFrame      jf	= new JFrame();
	JTextArea 	jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta
			, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
			, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextField 	jtf = new JTextField();
	public void initDisplay() {
		jtf.addActionListener(this);
		jf.setTitle("JTextArea샘플");
		jtf.setBackground(Color.lightGray);
		jf.add("Center", jsp);
		jf.add("South", jtf);
		jf.setSize(300, 400);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		JTextAreaSample_2 jtas = new JTextAreaSample_2();
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
