package swing.template;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaSample_1 implements ActionListener{
	JFrame      jf	= new JFrame();
	JTextArea 	jta = new JTextArea();
	JTextField 	jtf = new JTextField();
	public void initDisplay() {
		jtf.addActionListener(this);
		jf.setTitle("JTextArea샘플");
		jtf.setBackground(Color.lightGray);
		jf.add("Center", jta);
		jf.add("South", jtf);
		jf.setSize(300, 400);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		JTextAreaSample_1 jtas = new JTextAreaSample_1();
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
