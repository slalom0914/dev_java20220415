package ajdbc.member3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import address.view2.DBConnectionMgr;

// JFrame jf = new JFrame(); 
// jf.setTitle("자바실습")
// JFrame jf = new JFrame("자바실습");

public class Member3App extends JFrame implements ActionListener, MouseListener {
	JPanel jp_north = new JPanel();
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	String cols[] = {"번호","아이디","이름","주소"};
	String data[][] = new String[0][4];
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable			  jtb = new JTable(dtm);
	Font			  font = new Font("돋움체",Font.BOLD,18);
	JScrollPane       jsp  = new JScrollPane(jtb);
	DBConnectionMgr   dbMgr = new DBConnectionMgr();
	Connection		  con	= null;
	PreparedStatement pstmt = null;
	ResultSet 		  rs	= null;
	Member3Ship		  ms	= new Member3Ship(this);
	public Member3App() {
		// 이벤트 소스와 이벤트 처리 클래스를 매핑
		jbtn_sel.addActionListener(this);
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		initDisplay();
		refreshData();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_ins) {
			ms.initDisplay();
		}
		else if(obj == jbtn_sel) {
			refreshData();
		}

	}
	public void refreshData() {
		
		List<Map<String,Object>> memList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT mem_no, mem_id, mem_pw        ");
	    sql.append("  ,mem_name, mem_zipcode, mem_address");
	    sql.append("  FROM member                        ");
	    sql.append(" ORDER BY mem_no desc                ");
	    try {
			// insert here
	    	con = dbMgr.getConnection();
	    	pstmt = con.prepareStatement(sql.toString());
	    	rs = pstmt.executeQuery();
	    	Map<String,Object> rmap = null;
	    	while(rs.next()) {
	    		rmap = new HashMap<>();
	    		rmap.put("mem_no", rs.getInt("mem_no"));
	    		rmap.put("mem_id", rs.getString("mem_id"));
	    		rmap.put("mem_name", rs.getString("mem_name"));
	    		rmap.put("mem_address", rs.getString("mem_address"));
	    		memList.add(rmap);
	    	}
	    	// insert here
	    	//System.out.println(memList);
	    	// 기존에 조회된 결과 즉 목록 삭제하기
	    	while(dtm.getRowCount() > 0 ) {
	    		dtm.removeRow(0);
	    	}
	    	// Iterator는 자료구조가 갖고 있는 정보의 유무를 체크하는데 필요한 메소드를 제공하고 있다.
	    	Iterator<Map<String,Object>> iter = memList.iterator();
	    	Object keys[] = null;
	    	while(iter.hasNext()) {
	    		Map<String,Object> data = iter.next();
	    		keys = data.keySet().toArray();
	    		Vector<Object> oneRow = new Vector<>();
	    		oneRow.add(data.get(keys[2]));
	    		oneRow.add(data.get(keys[1]));
	    		oneRow.add(data.get(keys[0]));
	    		oneRow.add(data.get(keys[3]));
	    		dtm.addRow(oneRow);
	    	}
	    } catch (SQLException se) {
	    	System.out.println("[[query]]"+ sql.toString());
	    	System.out.println(se.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 자원 반납은 생성된 역순으로 한다.
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}

	}
	public void initDisplay() {
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jbtn_sel.setBackground(new Color(158,9,9));
		jbtn_sel.setForeground(new Color(212,212,212));
		jp_north.add(jbtn_sel);
		jbtn_ins.setBackground(new Color(7,84,170));
		jbtn_ins.setForeground(new Color(212,212,212));
		jp_north.add(jbtn_ins);
		jbtn_upd.setBackground(new Color(19,99,57));
		jbtn_upd.setForeground(new Color(212,212,212));
		jp_north.add(jbtn_upd);
		jbtn_del.setBackground(new Color(54,54,54));
		jbtn_del.setForeground(new Color(212,212,212));
		jp_north.add(jbtn_del);
		this.add("North", jp_north);
		this.add("Center",jsp);
		this.setTitle("회원관리시스템 Ver1.0");
		this.setSize(600, 400);
		this.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}



	public static void main(String[] args) {
		new Member3App();
	}

}
