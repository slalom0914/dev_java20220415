package swing.template;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableSample_1 {
	JFrame jf = new JFrame();
	String cols[] = {"아이디","비번","이름"};
	String data[][] = new String[3][3];
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable 			  jtb = new JTable(dtm);
	JScrollPane 	  jsp = new JScrollPane(jtb
            ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public void initDisplay() {
		jf.add("Center",jsp);
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		JTableSample_1 jtb = new JTableSample_1();
		jtb.initDisplay();
	}

}
