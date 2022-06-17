package ajdbc.member3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import address.view2.DBConnectionMgr;
import oracle.vo.MemberVO;

public class Member3Ship extends JFrame implements ActionListener, MouseListener {
	// 선언부
	JPanel      jp_center		= new JPanel();
	JLabel 		jlb_id 			= new JLabel("아이디 ");
	JTextField 	jtf_id 			= new JTextField("",20);
	JButton		jbtn_idcheck 	= new JButton("ID중복체크");
	JLabel 		jlb_pw 			= new JLabel("비밀번호 ");
	JTextField 	jtf_pw 			= new JTextField("",20);
	JLabel 		jlb_name 		= new JLabel("이름 ");
	JTextField 	jtf_name 		= new JTextField("",20);
	JLabel 		jlb_zipcode 	= new JLabel("우편번호 ");
	JTextField 	jtf_zipcode		= new JTextField("",20);
	JButton		jbtn_zipcode 	= new JButton("우편번호찾기");
	JLabel 		jlb_address 	= new JLabel("주소 ");
	JTextField 	jtf_address 	= new JTextField("",35);	
	JScrollPane jsp				= new JScrollPane(jp_center);
	JPanel 		jp_south		= new JPanel();
	JButton		jbtn_signup		= new JButton("회원가입");
	JButton		jbtn_cancel		= new JButton("취소");
	////////////////// DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs		= null;// 조회경우 커서를 조작 필요
	////////////////// DB연동 ///////////////////	
	Member3App memberApp = null;
	// 생성자
	public Member3Ship() {
		//initDisplay();
	}
	public Member3Ship(Member3App memberApp) {
		this.memberApp = memberApp;
	}
	public int memberInsert(MemberVO pmVO) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO member(mem_no,mem_id,mem_pw,mem_name,mem_zipcode,mem_address)");
		sql.append("VALUES(seq_member_no.nextval,?,?,?,?,?)");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setString(++i, pmVO.getMem_id());
			pstmt.setString(++i, pmVO.getMem_pw());
			pstmt.setString(++i, pmVO.getMem_name());
			pstmt.setString(++i, pmVO.getMem_zipcode());
			pstmt.setString(++i, pmVO.getMem_address());
			result = pstmt.executeUpdate();
			System.out.println("result : "+result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
		return result;
	}
	/*************************************************************************
	 * 아이디 중복체크 구현하기
	 * @param 사용자가 입력한 아이디
	 * @return boolean
	 * 만일 boolean을 선택했다면 false이면 사용할 수 없다.  true이면 사용할 수 있다.
	 * 만일 boolean을 선택했다면 false이면 사용할 수 있다.  true이면 사용할 수 없다.
	SELECT 1
	  FROM dual
	 WHERE EXISTS (SELECT mem_name
	                 FROM member
	                WHERE mem_id ='tomato') 
	 질문 1: tomato가 존재하는데 false가 뜹니다. 뭐가 문제인가요?
	 질문 2: java.sql.SQLException: 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1 일때
	        ?자리에 들어갈 값을 치환하지 않은 경우
	 질문 3: 토드에서 사용한 변수를 그대로 사용한 경우 반드시 ?로 바꾸어 쓸 것.
	 질문 4: java.sql.SQLSyntaxErrorException: ORA-00911: 문자가 부적합합니다
	       쿼리문 뒤에 세미콜론을 붙인 경우에 발생하는 오류 입니다.                       
	*************************************************************************/                
	public boolean idCheck(String user_id) {
		boolean isOk = false;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT 1                               ");
		sql.append("  FROM dual                            ");
		sql.append(" WHERE EXISTS (SELECT mem_name         ");
		sql.append("                 FROM member           ");
		sql.append("                WHERE mem_id =?)"); 	
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				isOk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 자원 반드시 반납할 것. - 자바 튜닝팀 지적사항
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		return isOk;
	}///////////////////////// end of idCheck

	// 화면 처리부
	public void initDisplay() {
		//처음 화면이 열렸을 때는 아이디 중복검사가 되지 않았으니까 회원가입 버튼 비활성화
		jbtn_signup.setEnabled(false);
		// 이벤트 소스와 이벤트처리 핸들러 클래스 연결하기
		jbtn_zipcode.addActionListener(this);
		jbtn_idcheck.addActionListener(this);
		jbtn_signup.addActionListener(this);
		jp_center.setLayout(null);
		jlb_id.setBounds(20, 20, 100, 20);
		jtf_id.setBounds(120, 20, 100, 20);
		jbtn_idcheck.setBounds(230, 20, 120, 20);
		jlb_pw.setBounds(20, 45, 100, 20);
		jtf_pw.setBounds(120, 45, 100, 20);
		jlb_name.setBounds(20, 70, 100, 20);
		jtf_name.setBounds(120, 70, 100, 20);
		jlb_zipcode.setBounds(20, 95, 100, 20);
		jtf_zipcode.setBounds(120, 95, 70, 20);
		jbtn_zipcode.setBounds(200, 95, 120, 20);
		jlb_address.setBounds(20, 120, 100, 20);
		jtf_address.setBounds(120, 120, 200, 20);
		jp_center.add(jlb_id);
		jp_center.add(jtf_id);
		jp_center.add(jbtn_idcheck);
		jp_center.add(jlb_pw);
		jp_center.add(jtf_pw);
		jp_center.add(jlb_name);
		jp_center.add(jtf_name);
		jp_center.add(jlb_zipcode);
		jp_center.add(jtf_zipcode);
		jp_center.add(jbtn_zipcode);
		jp_center.add(jlb_address);
		jp_center.add(jtf_address);
		jp_south.add(jbtn_signup);
		jp_south.add(jbtn_cancel);
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setTitle("회원가입 하기");
		this.setSize(430, 380);
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
		if(obj == jbtn_zipcode) {
			Zipcode3Search zs = new Zipcode3Search(this);
			zs.initDisplay();
		}
		else if(obj == jbtn_signup) {
			MemberVO pmVO = new MemberVO();
			pmVO.setMem_id(getId());
			pmVO.setMem_pw(getPw());
			pmVO.setMem_name(getName());
			pmVO.setMem_zipcode(getZipcode());
			pmVO.setMem_address(getAddress());
			int result = memberInsert(pmVO);
			if(result == 1) {
				System.out.println("result ===> " + result);
				// insert here - 회원가입 성공 후 MemberApp클래스의 새로고침 메소드 호출하기
				//가입성공이 되면 가입화면은 닫아주세요
				this.dispose();
				if(memberApp != null) {
					memberApp.refreshData();					
				}
				
			}
		}
		// 너 아이디 중복체크 하려구?
		else if(obj == jbtn_idcheck) {
			boolean isOk = idCheck(getId());
			System.out.println("ID중복체크 호출");
			if(isOk) {
				JOptionPane.showMessageDialog(this, "사용할 수 없는 아이디 입니다.","ERROR",JOptionPane.ERROR_MESSAGE);
				return;
			}else{
				JOptionPane.showMessageDialog
				(this, "사용할 수 있는 아이디 입니다.","INFO",JOptionPane.INFORMATION_MESSAGE);
				isOk = true;
				jbtn_signup.setEnabled(isOk);
				
			}
		} 

	}///////////// end of actionPerformed
	// 각 컬럼의 값들을 설정하거나 읽어오는 getter/setter메소드 
	public String getId() { return jtf_id.getText(); }
	public void setId(String mem_id) { jtf_id.setText(mem_id); }
	public String getPw() { return jtf_pw.getText(); }
	public void setPw(String mem_pw) { jtf_pw.setText(mem_pw); }
	public String getName() { return jtf_name.getText(); }
	public void setName(String mem_name) { jtf_name.setText(mem_name); }
	public String getZipcode() { return jtf_zipcode.getText(); }
	public void setZipcode(String mem_zipcode) { jtf_zipcode.setText(mem_zipcode); }
	public String getAddress() { return jtf_address.getText(); }
	public void setAddress(String mem_address) { jtf_address.setText(mem_address); }

	public static void main(String[] args) {
		new Member3Ship();
	}

}
