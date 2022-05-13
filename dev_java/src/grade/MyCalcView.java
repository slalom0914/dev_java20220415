package grade;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalcView {
	JFrame f = new JFrame("계산기");
	JTextField m_ResultField = null;
	//계산기 버튼의 Caption
	final String[][] BUTTON_CAPTION = {
										{"1","2","3","+"},
										{"4","5","6","-"},
										{"7","8","9","*"},
										{".","0","=","/"}
	                                  };
	public MyCalcView() 
	{
		//이벤트 처리
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});		
		initDisplay();
	} 
	public void initDisplay() {
		f.getContentPane().setLayout(new BorderLayout(4,4));
		//Button이 위치할 Panel을 만든다.
		JPanel buttonPanel = new JPanel(new GridLayout(4,4,3,3));
		
		//Button을 생성하고 Panel에 붙인다.
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				JButton button = new JButton(BUTTON_CAPTION[i][j]);
				buttonPanel.add(button);
			}
		}//버튼 16개를 패널에 붙이기 
		//TextField 및 Clear 버튼을 만든다.
		JButton clearButton = new JButton("C");
		JButton backButton = new JButton("←");
		m_ResultField = new JTextField("0");
		//Font font = new Font("돋움",Font.BOLD,12);
		//m_ResultField.setFont(font);
		m_ResultField.setHorizontalAlignment(JTextField.RIGHT);
		//TextField 및 Clear 버튼을 붙일 Panel을 만든 후 붙인다.
		JPanel northPanel = new JPanel(new GridLayout(2,1,3,3));
		JPanel northPanelSub = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		northPanelSub.add(clearButton);
		northPanelSub.add(backButton);
		northPanel.add(m_ResultField);
		northPanel.add(northPanelSub);
		
		//Frame에 buttonPanel, northPanel을 붙인다.
		f.getContentPane().add("North", northPanel);
		f.getContentPane().add("Center", buttonPanel);
		
		//Frame 의 사이즈를 최적화 시킨다.
		f.pack();
		f.setVisible(true);		
	}
	public static void main(String[] args) {
		new MyCalcView();
	}
}
