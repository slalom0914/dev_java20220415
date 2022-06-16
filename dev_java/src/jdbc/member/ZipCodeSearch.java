package jdbc.member;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import address.view2.DBConnectionMgr;


/*
 * dispose에 대한 설명임
 * 이 Window, 하위 구성 요소 및 모든 소유 된 하위 구성 요소에서 사용하는 모든 기본 화면 리소스를 
 * 해제합니다. 즉, 이러한 구성 요소에 대한 리소스가 파괴되고 사용하는 모든 메모리가 OS로 반환되며 
 * 표시 할 수없는 것으로 표시됩니다.

Window 및 하위 구성 요소는 pack 또는 show에 대한 후속 호출로 네이티브 리소스를 다시 빌드하여 
다시 표시 가능하게 만들 수 있습니다. 다시 생성 된 Window 및 해당 하위 구성 요소의 상태는 Window가 
삭제 된 시점에서 이러한 개체의 상태와 동일합니다 (해당 작업 간의 추가 수정은 고려하지 않음).
 * 
 * setVisiable에 대한 설명임.
 * 재정의 : 구성 요소의 setVisible (...)
매개 변수 : b true이면 Window를 표시하고 그렇지 않으면 Window를 숨 깁니다. 
Window 및 / 또는 해당 소유자가 아직 표시 가능하지 않은 경우 둘 다 표시 가능하게됩니다. 
창은 보이기 전에 유효성이 검사되며 창이 이미 보이는 경우에는 창을 앞으로 가져옵니다.
false이면이 Window, 하위 구성 요소 및 모든 소유 자식을 숨 깁니다. Window 및 해당 하위 구성 
요소는 #setVisible (true)를 호출하여 다시 표시 할 수 있습니다.
 */
public class ZipCodeSearch extends JFrame implements MouseListener
                                                   , ItemListener
                                                   , FocusListener
                                                   , ActionListener {
	//선언부
	String zdo = null;
	//물리적으로 떨어져 있는 db서버와 연결통로 만들기
	Connection 			con 	= null;
	//위에서 연결되면 쿼리문을 전달할 전령의 역할을 하는 인터페이스 객체 생성하기
	PreparedStatement 	pstmt 	= null;
	//조회된 결과를 화면에 처리해야 하므로 오라클에 커서를 조작하기 위해 ResultSet추가
	ResultSet 			rs 		= null;
	JPanel jp_north = new JPanel();
	//insert here
	String zdos[] = {"전체","서울","경기","강원"};
	String zdos2[] = {"전체","부산","전남","대구"};
	Vector<String> vzdos = new Vector<>();//vzdos.size()==>0
	JComboBox jcb_zdo = new JComboBox(zdos);//West
	JComboBox jcb_zdo2 = null;//West
	JTextField jtf_search = new JTextField("동이름을 입력하세요.");//Center
	JButton jbtn_search = new JButton("조회");//East
	String cols[] = {"우편번호","주소"};
	String data[][] = new String[0][2];
	DefaultTableModel dtm_zipcode = new DefaultTableModel(data,cols);
	JTable jtb_zipcode = new JTable(dtm_zipcode);
	JTableHeader jth = jtb_zipcode.getTableHeader();
	JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	String zdos3[] = null;
	MemberShip memberShip = null;
	//생성자
	public ZipCodeSearch() {
		zdos3 = getZdoList();
	}
	public ZipCodeSearch(MemberShip memberShip) {
		this();
		this.memberShip = memberShip;
	}
	//화면처리부
	public void initDisplay() {
		jtb_zipcode.requestFocus();
		jtb_zipcode.addMouseListener(this);
		jbtn_search.addActionListener(this);
		jtf_search.addFocusListener(this);
		jtf_search.addActionListener(this);
		jp_north.setLayout(new BorderLayout());
		/*	*/
		//vzdos.copyInto(zdos2);
		for(int x=0;x<zdos2.length;x++) {
			vzdos.add(zdos2[x]);
		}
		for(String s:vzdos) {
			System.out.println("s===>"+s);
		}
/* String배열에 있는 정보를 굳이 벡터에 담아야 한다.
 * 생성자 선택을 Vector타입으로 결정했기 때문이다.
 * 벡터 자체는 값을 가지고 있지 않는 상태이다.
 * 값은 1차 배열 안에 초기화 되어 있다.
 * 이것을 벡터에 재 초기화 한다.
 * 그 후에 콤보박스를 생성하고 화면에 장착해야 리스트에서 값을 볼 수 있을 것이다.
 * 	
 */
//		jcb_zdo2 = new JComboBox(vzdos);//West
		jcb_zdo2 = new JComboBox(zdos3);//West
		jcb_zdo2.addItemListener(this);
		jp_north.add("West",jcb_zdo2);
		jp_north.add("Center",jtf_search);
		jp_north.add("East",jbtn_search);
		this.add("North",jp_north);
		this.add("Center",jsp_zipcode);
		this.setTitle("우편번호 검색");
		this.setSize(430, 400);
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		ZipCodeSearch zcs = new ZipCodeSearch();
		zcs.initDisplay();
	}
	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("focusGained 호출 성공");
		if(e.getSource() == jtf_search) {
			jtf_search.setText("");
		}
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	public String[] getZdoList() {
		//원격에 있는 오라클 서버에 접속하기 위해 DBConnectionMgr객체 생성하기
		DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
		//물리적으로 떨어져 있는 서버에 연결통로 확보하기
		con = dbMgr.getConnection();
		String[] zdos = null;
		//insert here -DB 연동하기-쿼리문 준비
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT '전체' zdo FROM dual");               
		sql.append(" UNION ALL                ");
		sql.append("SELECT zdo                        ");
		sql.append("  FROM (SELECT distinct(zdo) zdo  ");
		sql.append("          FROM zipcode_t          ");
		sql.append("        ORDER BY zdo asc)         ");
		try {//인터넷이 끊겼을 경우 에러 발생
			//전령 객체 메모리에 로딩
			pstmt = con.prepareStatement(sql.toString());
			//전령객체를 로딩할 때 파라미터로 select문을 전달했다.
			//그 문을 처리해 주세요. 만일 insert할때는 executeUpdate호출함.
			rs = pstmt.executeQuery();
			String imsi = null;
			Vector<String> v = new Vector<>();
			//List<String> v2 = new Vector<>();
			while(rs.next()) {
				imsi = rs.getString("zdo");
				v.add(imsi);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
			//v2.copyInto(zdos);
		} catch (Exception e) {
			System.out.println("Exceptioin : "+e.toString());
		}
		return zdos;
	}
	public void refreshData(String zdo, String dong) {
		System.out.println("zdo:"+zdo+", dong:"+dong);
		DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
		con = dbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT zipcode, address");
		sql.append("  FROM zipcode_t");
		sql.append(" WHERE 1=1");
		if(zdo!=null && zdo.length()>0) {
			sql.append(" AND zdo=?");
		}
		if(dong!=null) {
			sql.append(" AND dong LIKE '%'||?||'%'");
		}
		System.out.println("sql : "+sql);
		//물음표의 갯수가 달라지므로 변수로 처리함.
		//물음표 자리는 1부터 이다.
		int i=1;
		try {
			//파라미터로 넘어온 select문을 스캔 - ?갯수를 파악
			pstmt = con.prepareStatement(sql.toString());
			//위에서 물음표 자리에 들어갈 값을 파라미터로 받아서 설정하기
			if(zdo!=null && zdo.length()>0) {
				pstmt.setString(i++, zdo);//콤보박스에서 가져온 값
			}
			if(dong!=null && dong.length()>0) {
				pstmt.setString(i++, dong);//텍스트 필드에서 가져온 값
			}
			rs = pstmt.executeQuery();
			//내안에 있는 타입을 꺽쇠안에 직접 써주면 타입체크를 별도로 안함.
			//제네릭이라고 함.
			//선언부에는 반드시 써야하고 생성부에는 생략가능함
			//그러나 다이아몬드 연산자는 작성
			Vector<ZipCodeVO> v = new Vector<>();
			//List v2 = new Vector();
			ZipCodeVO zVOS[] = null;
			ZipCodeVO zVO = null;
			while(rs.next()) {
				zVO = new ZipCodeVO();
				zVO.setZipcode(rs.getInt("zipcode"));
				zVO.setAddress(rs.getString("address"));
				v.add(zVO);
			}
			//List타입으로 선언된 v2로는  copyInto라는 메소드를 호출불가
			//이유:부모가 가진 메소드를 재정의한것만 호출가능하기 때문
			zVOS = new ZipCodeVO[v.size()];
			v.copyInto(zVOS);
			//질문:두 번 조회할 경우 앞에 조회결과가 남아 있어요. 이것을 초기화 하고 싶습니다. 
			//어떡하죠?
			if(v.size()>0) {
				while(dtm_zipcode.getRowCount() > 0) {
					dtm_zipcode.removeRow(0);
				}
			}
			//조회된 결과를 DefaultTableModel에 매칭시키기
			for(int x=0;x<zVOS.length;x++) {
				Vector<Object> oneRow = new Vector<>();
				oneRow.add(0,zVOS[x].getZipcode());
				oneRow.add(1,zVOS[x].getAddress());
				dtm_zipcode.addRow(oneRow);
			}
		} catch (SQLException se) {
			System.out.println(se.toString());
			System.out.println("[[query]]=="+sql.toString());
		} catch (Exception e) {
			System.out.println(e.toString());			
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_search || obj == jtf_search) {
			String user = jtf_search.getText();
			refreshData(zdo,user);
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj == jcb_zdo2) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				zdo = zdos3[jcb_zdo2.getSelectedIndex()];
			}
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount()==2) {
			System.out.println("더블 클릭 한거야");
			int index[] = jtb_zipcode.getSelectedRows();
			if(index.length == 0) {
				JOptionPane.showMessageDialog(this,"조회할 데이터를 선택하시오.");
				return;
			}
			else if(index.length > 1) {
				JOptionPane.showMessageDialog(this,"데이터를 한 건만 선택하시오.");
				return;
			}
			else {
				int zipcode = (Integer)dtm_zipcode.getValueAt(index[0], 0);
				String address = (String)dtm_zipcode.getValueAt(index[0], 1);
				System.out.println(zipcode+" , "+address);
				memberShip.jtf_zipcode.setText(String.valueOf(zipcode));
				memberShip.jtf_address.setText(String.valueOf(address));
				//this.dispose();
				this.setVisible(false);
				//refreshData();
			}
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}





















