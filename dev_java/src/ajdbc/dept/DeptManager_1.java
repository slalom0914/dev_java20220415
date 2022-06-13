package ajdbc.dept;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import address.view2.DBConnectionMgr;

public class DeptManager_1 extends JFrame implements ActionListener, MouseListener{
	JPanel jp_north			= new JPanel();
	JButton jbtn_select		= new JButton("조회");
	JButton jbtn_insert		= new JButton("입력");
	JButton jbtn_update		= new JButton("수정");
	JButton jbtn_delete		= new JButton("삭제");
	JPanel jp_south			= new JPanel();
	JTextField jtf_deptno	= new JTextField("", 10);
	JTextField jtf_dname	= new JTextField("", 20);
	JTextField jtf_loc		= new JTextField("", 20);
	String cols[] 			= {"부서번호","부서명","지역"};
	String data[][] 		= new String[0][3];
	DefaultTableModel dtm 	= new DefaultTableModel(data,cols);
	JTable jtb				= new JTable(dtm);
	JScrollPane jsp			= new JScrollPane(jtb);
	DBConnectionMgr dbMgr	= new DBConnectionMgr();
	Connection 	      con	= null;
	PreparedStatement pstmt = null;
	ResultSet         rs	= null;
	public DeptManager_1() {
		jbtn_select.addActionListener(this);
		jbtn_insert.addActionListener(this);
		jbtn_update.addActionListener(this);
		jbtn_delete.addActionListener(this);
		jtb.addMouseListener(this);
		initDisplay();
	}
	public void initDisplay() {
		LineBorder lb = new LineBorder(Color.RED,3);
		LineBorder lb2 = new LineBorder(Color.BLUE,3);
		jp_north.setBorder(lb);
		jsp.setBorder(lb2);
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_select);
		jp_north.add(jbtn_insert);
		jp_north.add(jbtn_update);
		jp_north.add(jbtn_delete);
		jp_south.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_south.add(jtf_deptno);
		jp_south.add(jtf_dname);
		jp_south.add(jtf_loc);
		this.add("North", jp_north);
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setSize(600, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DeptManager_1();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if("조회".equals(command)) {
			System.out.println("조회 호출 성공");
			getDeptList();
		}
		else if("입력".equals(command)) {
			System.out.println("입력 호출 성공");
			String deptno = jtf_deptno.getText();
			String dname  = jtf_dname.getText();
			String loc    = jtf_loc.getText();
			deptInsert(deptno, dname, loc);
		}
		else if("수정".equals(command)) {
			System.out.println("수정 호출 성공");
			String deptno = jtf_deptno.getText();
			String dname  = jtf_dname.getText();
			String loc    = jtf_loc.getText();
			deptUpdate(deptno, dname, loc);
		}
		else if("삭제".equals(command)) {
			System.out.println("삭제 호출 성공");
			int index[] = jtb.getSelectedRows();
			if (index.length == 0) {
				JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요...", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				Integer id = (Integer)dtm.getValueAt(index[0], 0);
				System.out.println("id : "+id);
				deptDelete(id);
			}
			
		}
	}
	public int deptInsert(String deptno, String dname, String loc) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO dept(deptno, dname, loc)");
		sql.append(" VALUES(?,?,?)");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int ideptno = Integer.parseInt(deptno);
			pstmt.setInt(1, ideptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			result = pstmt.executeUpdate();
			if(result == 1) {
				JOptionPane.showMessageDialog(this,"데이터가 입력 되었습니다.","Info" ,JOptionPane.INFORMATION_MESSAGE);				
				getDeptList();
			}
			DBConnectionMgr.freeConnection(pstmt, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	public int deptDelete(int deptno) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM dept");
		sql.append(" WHERE deptno=?");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate();
			if(result == 1) {
				JOptionPane.showMessageDialog(this,"데이터가 삭제되었습니다.","Info" ,JOptionPane.INFORMATION_MESSAGE);				
				getDeptList();
			}
			DBConnectionMgr.freeConnection(pstmt, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	public int deptUpdate(String deptno, String dname, String loc) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE dept");
		sql.append("   SET dname=?");
		sql.append("      ,loc=?");
		sql.append(" WHERE deptno=?");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int ideptno = Integer.parseInt(deptno);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, ideptno);
			result = pstmt.executeUpdate();
			if(result == 1) {
				JOptionPane.showMessageDialog(this,"데이터가 수정되었습니다.","Info" ,JOptionPane.INFORMATION_MESSAGE);				
				getDeptList();
			}
			DBConnectionMgr.freeConnection(pstmt, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	public void getDeptList() {
		System.out.println("getDeptList 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT deptno, dname, loc FROM dept");
		List<Map<String,Object>> deptList = new ArrayList<>();
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("deptno", rs.getInt("deptno"));
				rmap.put("dname", rs.getString("dname"));
				rmap.put("loc", rs.getString("loc"));
				deptList.add(rmap);
			}
			if(deptList == null || deptList.size() < 1) {
				JOptionPane.showMessageDialog(this,"데이터가 없습니다.","Info" ,JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				// 이미 테이블에 보여지는 데이터가 있는 경우 모두 삭제합니다.
				while(dtm.getRowCount() > 0)
					dtm.removeRow(0);
				Iterator<Map<String,Object>> iter = deptList.iterator(); 
				Object keys[] = null;
				while(iter.hasNext()) {
					Map<String,Object> data = iter.next();
					System.out.println(data);
					keys = data.keySet().toArray();
					Vector<Object> oneRow = new Vector();
					oneRow.addElement(data.get(keys[2]));
					oneRow.addElement(data.get(keys[1]));
					oneRow.addElement(data.get(keys[0]));
					dtm.addRow(oneRow);
				}
				DBConnectionMgr.freeConnection(rs, pstmt, con);
			}			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}//////////////////////// end of getDeptList
	public void getDeptDetail(int deptno) {
		System.out.println("getDeptDetail 호출 성공 deptno : " + deptno);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT deptno, dname, loc FROM dept");
		sql.append(" WHERE deptno=?");
		Map<String,Object> rmap = null;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("deptno", rs.getInt("deptno"));
				rmap.put("dname", rs.getString("dname"));
				rmap.put("loc", rs.getString("loc"));
			}
			if(rmap == null || rmap.size() < 1) {
				JOptionPane.showMessageDialog(this,"데이터가 없습니다.","Info" ,JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				jtf_deptno.setText(rmap.get("deptno").toString());
				jtf_dname.setText(rmap.get("dname").toString());
				jtf_loc.setText(rmap.get("loc").toString());
			}	
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}//////////////////////// end of getDeptList	
	@Override
	public void mouseClicked(MouseEvent me) {
		System.out.println("mouseClicked");
		int index[]= jtb.getSelectedRows();
		// 테이블의 데이터를 선택하지 않은 경우
		if(index.length == 0) {
			JOptionPane.showMessageDialog(this, "조회할 데이터를 선택하세요...", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} 		
//		getDeptDetail(20);
		int udeptno = 0;
		udeptno = Integer.parseInt(dtm.getValueAt(index[0], 0).toString());
		getDeptDetail(udeptno);
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
}
