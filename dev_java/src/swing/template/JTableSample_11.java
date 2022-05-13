package swing.template;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableSample_11 implements ActionListener{
	// 윈도우 운영체제에서 창을 생성하기
	JFrame jf = new JFrame();
	// 테이블의 헤더를 구성할 때 사용할 1차 배열 선언
	String cols[] = {"HTML","자바","총점"};
	// JTable은 테이블 양식만 제공할 뿐 실제 데이터를 담는 클래스는 DefaultTableModel이다.
	// 실제로 데이터를 가지고 있는 것은 2차 배열이다.
	String data[][] = new String[3][3];
	// 만일 값을 접근하려면 DefaultTableModel안에 데이터셋이 있다.
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	// 나는 양식일 뿐이야 데이터를 가지고 있지 않아
	JTable 			  jtb = new JTable(dtm);
	JScrollPane 	  jsp = new JScrollPane(jtb
            ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//속지를 그리는데 사용됨 - 이 속지에 처리버튼과 종료 버튼을 추가해 보자.
	JPanel jp_north = new JPanel();
	JButton jbtn_add = new JButton("샘플점수추가");
	JButton jbtn_account = new JButton("성적처리");
	JButton jbtn_exit = new JButton("종료");
	
	public void initDisplay() {
		jbtn_account.addActionListener(this);
		jbtn_add.addActionListener(this);
		jp_north.setBackground(Color.orange);
		jp_north.add(jbtn_add);
		jp_north.add(jbtn_account);
		jp_north.add(jbtn_exit);
		jf.add("North", jp_north);
		jf.add("Center",jsp);
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		JTableSample_11 jtb = new JTableSample_11();
		jtb.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {// 자바에서 대신 주입해 준다. ActionEvent그래서 null이 아니야
		Object obj = e.getSource();
		if(obj == jbtn_account) {
			String html = (String)dtm.getValueAt(0, 0);
			String java = (String)dtm.getValueAt(0, 1);
			int hap = Integer.parseInt(html)+Integer.parseInt(java);
			System.out.println("html점수 : "+html);
			dtm.setValueAt(hap, 0, 2);
		}else if(obj == jbtn_add) {
			int datas[][] = {
					{85,76,0}
				   ,{95,85,0}
				   ,{75,78,0}
					
			};
			for(int i=0;i<data.length;i++) {
				for(int j=0;j<data[i].length;j++) {
					dtm.setValueAt(datas[i][j], i, j);
				}
			}
		}
		
	}

}
