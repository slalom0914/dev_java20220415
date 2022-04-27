package swing.template;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableSample_3 implements ActionListener{
	JFrame jf = new JFrame();
	JPanel jp_north = new JPanel();
	JButton jbtn_select = new JButton("조회");
	JButton jbtn_insert = new JButton("입력");
	JButton jbtn_update = new JButton("수정");
	JButton jbtn_delete = new JButton("삭제");
	String cols[] = {"아이디","비번","이름"};
	String data[][] = new String[3][3];
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable 			  jtb = new JTable(dtm);
	JScrollPane 	  jsp = new JScrollPane(jtb
            ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public void initDisplay() {
		jbtn_select.addActionListener(this);
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_select);
		jp_north.add(jbtn_insert);
		jp_north.add(jbtn_update);
		jp_north.add(jbtn_delete);
		jf.add("North", jp_north);
		jf.add("Center",jsp);
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JTableSample_3 jtb = new JTableSample_3();
		jtb.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_select) {
			// 이미 테이블에 보여지는 데이터가 있는 경우 모두 삭제합니다.
			while(dtm.getRowCount() > 0)
				dtm.removeRow(0);			
			String datas[][] = {
				{"tomato","123","토마토"},
				{"apple","124","사과"},
				{"banana","125","바나나"},
			};
			for(int i=0;i<datas.length;i++) {
				dtm.addRow(datas[i]);
			}
		}
	}

}
