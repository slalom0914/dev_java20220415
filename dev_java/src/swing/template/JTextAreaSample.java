package swing.template;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaSample {
	JFrame      jf	= new JFrame();
	JTextArea 	jta = new JTextArea();
	JTextField 	jtf = new JTextField();
	public void initDisplay() {
		jf.setTitle("JTextArea샘플");
		jtf.setBackground(Color.lightGray);
		jf.add("Center", jta);
		jf.add("South", jtf);
		jf.setSize(300, 400);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		JTextAreaSample jtas = new JTextAreaSample();
		jtas.initDisplay();
	}

}
