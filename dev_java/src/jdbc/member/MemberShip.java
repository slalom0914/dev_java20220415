package jdbc.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import address.view2.DBConnectionMgr;

public class MemberShip extends JDialog implements ActionListener {
	// 입력, 수정, 조회 화면에 사용할 컴포넌트를 선언합니다.
	JLabel jlb_id;
	JTextField jtf_id;
	JButton jbtn_idcheck;
	JLabel jlb_pw;
	JTextField jtf_pw;
	JLabel jlb_name;
	JTextField jtf_name;
	JLabel jlb_zipcode;
	JTextField jtf_zipcode = new JTextField(20);
	JButton jbtn_zipcode;
	JLabel jlb_address;
	JTextField jtf_address = new JTextField(20);
	JScrollPane scrollPane;
	JPanel panel;
	JPanel panelBtn;
	Font font;

	String title;

	JButton jbtn_signup;
	JButton btnCancel;
	////////////////// DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs		= null;// 조회경우 커서를 조작 필요
	////////////////// DB연동 ///////////////////	
	MemberManager main = null;
	MemberVO mvo = null;
	public MemberShip() {
		//initDisplay();
	}
	// 타이틀, 수정여부, Value Object를 받아서 윈도우를 설정합니다.
	public void set(String title, boolean editable, MemberVO mvo, MemberManager main) {
		this.mvo = mvo;
		this.main = main;
		//this.set(title, editable);
		this.setEditable(editable);
		this.setTitle(title);
		this.setValue(mvo);
	}
	// 입력, 수정시는 칼럼값을 수정 가능하도록, 조회시는 불가능하게
	// 셋팅하는 메쏘드입니다.
	private void setEditable(boolean e) {
		jtf_id.setEditable(e);
		jtf_pw.setEditable(e);
		jtf_name.setEditable(e);	
		jtf_zipcode.setEditable(e);
		jtf_address.setEnabled(e);
	}
	public void setValue(MemberVO vo) {
		// 입력을 위한 윈도우 설정-모든값을 null로 셋팅합니다.
		if(vo == null) {
			setId("");
			setPw("");
			setName("");
	  		setZipcode("");
	  		setAddress("");
		// 조회, 수정시는 Value Object에서 받은 값으로 셋팅합니다.
		} else {
			setId(vo.getMem_id());
			setPw(vo.getMem_pw());
			setName(vo.getMem_name());
			setZipcode(vo.getMem_zipcode());
	  		setAddress(vo.getMem_address());
		}
	}	
	public int memberInsert(MemberVO pmVO) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO member2022(mem_no, mem_id, mem_pw");
		sql.append("                     , mem_name, mem_zipcode, mem_address)");
		sql.append(" VALUES(seq_member2022_no.nextval,?,?,?,?,?)");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setString(++i, pmVO.getMem_id());
			pstmt.setString(++i, pmVO.getMem_pw());
			pstmt.setString(++i, pmVO.getMem_name());
			pstmt.setString(++i, pmVO.getMem_zipcode());
			pstmt.setString(++i, pmVO.getMem_address());
			// select인 경우 커서를 리턴받고, insert, update, delete 인 경우는 int리턴 받음
			result = pstmt.executeUpdate();
			// 오라클 서버에서 입력 처리를 성공했을 때 1을 돌려 받는다.
			if(result == 1) {
				JOptionPane.showMessageDialog(this, "회원가입 성공","INFO", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				//main.refreshData();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}		return result;
	}
	public void initDisplay() {
		System.out.println("MemberShip initDisplay()호출 성공");
		//다이얼로그에 색상 정의할 때 사용
		this.getContentPane().setBackground(Color.red);
		// 데이터 칼럼명을 보여줄 레이블을 정의합니다.
		jlb_id = new JLabel("아이디 ");
		jlb_pw = new JLabel("비밀번호 ");
		jlb_name = new JLabel("이 름 ");
		jlb_zipcode = new JLabel("우편번호 ");
		jlb_address = new JLabel("주소 ");


		jlb_id.setFont(font);
		jlb_pw.setFont(font);
		jlb_name.setFont(font);
		jlb_zipcode.setFont(font);
		jlb_address.setFont(font);


		// 데이터를 보여줄 텍스트 필드등을 정의합니다.
		jtf_id = new JTextField(20);
		jbtn_idcheck = new JButton("id중복체크");
		jbtn_idcheck.addActionListener(this);
		jtf_pw = new JTextField(20);
		jtf_name = new JTextField(20);
		jbtn_zipcode = new JButton("우편번호찾기");
		jbtn_zipcode.addActionListener(this);


		// 버튼을 정의합니다.
		jbtn_signup= new JButton("확인");
		jbtn_signup.setFont(font);
		jbtn_signup.setEnabled(false);
		jbtn_signup.addActionListener(this);

		btnCancel = new JButton("취소");
		btnCancel.setFont(font);
		btnCancel.addActionListener(this);

		panel = new JPanel();
//컴넌트들의 위치를 정해줍니다.
		panel.setLayout(null);

		jlb_id.setBounds(20,20, 100,20);
		jtf_id.setBounds(120,20, 100,20);
		jbtn_idcheck.setBounds(230, 20, 100, 20);

		jlb_pw.setBounds(20, 45, 100,20);
		jtf_pw.setBounds(120,45, 100,20);

		jlb_name.setBounds(20,70, 100,20);
		jtf_name.setBounds(120,70, 150, 20);

		jlb_zipcode.setBounds(20,95, 100,20);
		jtf_zipcode.setBounds(120,95, 70,20);
		jbtn_zipcode.setBounds(200, 95, 120, 20);

		jlb_address.setBounds(20,120, 100,20);
		jtf_address.setBounds(120, 120, 200,20);



		// 컴포넌트들을 패널에 붙입니다.
		panel.add(jlb_id);
		panel.add(jtf_id);
		panel.add(jbtn_idcheck);
		panel.add(jlb_pw);
		panel.add(jtf_pw);
		panel.add(jlb_name);
		panel.add(jtf_name);
		panel.add(jlb_zipcode);
		panel.add(jtf_zipcode);
		panel.add(jbtn_zipcode);
		panel.add(jlb_address);
		panel.add(jtf_address);


		panel.add(jbtn_signup);
		panel.add(btnCancel);

		panelBtn= new JPanel();

		panelBtn.add(jbtn_signup);
		panelBtn.add(btnCancel);

		scrollPane = new JScrollPane(panel);

		setTitle(title);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(panelBtn, BorderLayout.SOUTH);

		setSize(430,400);		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MemberShip();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_zipcode) {
			ZipCodeSearch zcs = new ZipCodeSearch(this);
			zcs.initDisplay();
		}
		else if(obj == jbtn_signup) {
			MemberVO mvo = new MemberVO();
			mvo.setCommand("insert");
			mvo.setMem_id(getId());
			mvo.setMem_pw(getPw());
			mvo.setMem_name(getName());
			mvo.setMem_zipcode(getZipcode());
			mvo.setMem_address(getAddress());
			int result = memberInsert(mvo);
			if(result == 1) {
				main.refreshData();
			}
		}
		else if(obj == btnCancel) {
			
		}
		else if(obj == jbtn_idcheck) {
			boolean isOk = idCheck(getId());
			if(isOk) {
				JOptionPane.showMessageDialog(this, "사용할 수 없는 아이디 입니다.", "Error", JOptionPane.ERROR_MESSAGE);
				return;				
			}else {
				JOptionPane.showMessageDialog(this, "사용할 수 있는 아이디 입니다.", "INFO", JOptionPane.INFORMATION_MESSAGE);
				isOk = true;
				jbtn_signup.setEnabled(isOk);				
			}
		}
	}
	public boolean idCheck(String uid) {
		boolean isOk = false;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT 1                          ");
		sql.append("  FROM dual                       ");
		sql.append(" WHERE EXISTS (SELECT mem_name    ");
		sql.append("                 FROM member2022  ");
		sql.append("                WHERE mem_id=?) ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				isOk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isOk;
	}
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
}
