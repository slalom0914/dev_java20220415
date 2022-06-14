package jdbc.member;

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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import address.view2.DBConnectionMgr;


public class MemberManager extends JFrame implements ActionListener, MouseListener {
	JPanel 		jp_north 	= new JPanel();// 디폴트레이아웃:FlowLayout
	JButton 	jbtn_sel 	= new JButton("조회");
	JButton 	jbtn_ins 	= new JButton("입력");
	JButton 	jbtn_upd 	= new JButton("수정");
	JButton 	jbtn_del 	= new JButton("삭제");
	// 서로 의존관계에 있다. - 의존성 주입(인스턴스화-싱글톤패턴), 객체 주입법, annotion
	String 		cols[] 		= {"번호","아이디","이름","주소"};
	String 		data[][] 	= new String[0][4];
	DefaultTableModel dtm	= new DefaultTableModel(data,cols);
	JTable		jtb			= new JTable(dtm);
	JTableHeader jth		= jtb.getTableHeader();
	Font f = new Font("돋움체",Font.BOLD,16);
	JScrollPane jsp			= new JScrollPane(jtb);	
	////////////////// DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs		= null;// 조회경우 커서를 조작 필요
	////////////////// DB연동 ///////////////////	
	MemberShip ship = new MemberShip();
	public MemberManager() {
		initDisplay();
		refreshData();
	}
	/*****************************************************************
	 * 전제 데이터를 다시 조회하는 메소드 구현
	 * 
	 *****************************************************************/
	public void refreshData() {
		List<Map<String,Object>> memList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT mem_no, mem_id, mem_name, mem_address FROM member2022");
		sql.append(" ORDER BY mem_no desc");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();// 같은 이름의 변수이지만 서로 다른 주소번지를 갖는다.
				rmap.put("mem_no", rs.getInt("mem_no"));
				rmap.put("mem_id", rs.getString("mem_id"));
				rmap.put("mem_name", rs.getString("mem_name"));
				rmap.put("mem_address", rs.getString("mem_address"));
				memList.add(rmap);// 순서가 정해진다.기본정렬은 오라클에서 하는 것이 빠르다
			}
			//System.out.println(deptList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}		
		//기존에 조회된 결과 즉 목록을 삭제하기
		while(dtm.getRowCount() > 0) {
			// 파라미터에 0을 주어서 테이블의 인덱스가 바뀌는 문제를 해결함	
			dtm.removeRow(0);
		}
		System.out.println(memList);
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
			// 데이터셋인 DefaultTableModel에 조회 결과  담기 - 반복처리함 => 10, 20, 30, 40
			dtm.addRow(oneRow);
		}
	}//////////////end of refreshData	
	public void initDisplay() {
		jbtn_ins.addActionListener(this);
		jth.setFont(f);
		jth.setBackground(Color.RED);
		jth.setForeground(Color.WHITE);
		//테이블 헤더 위치 변경 불가처리
		jth.setReorderingAllowed(false);
		jtb.setRowHeight(20);//전체높이설정
		jtb.setSelectionBackground(Color.lightGray);
		jtb.setSelectionForeground(Color.WHITE);
		jtb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtb.setGridColor(Color.RED); 		
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		this.add("North", jp_north);
		this.add("Center",jsp);
		this.setTitle("회원관리시스템");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_ins) {
			ship.set("입력", true, null,this);
			ship.setVisible(true);	
		}

	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new MemberManager();
	}

}
